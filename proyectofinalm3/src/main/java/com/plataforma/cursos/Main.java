package com.plataforma.cursos;



import org.apache.logging.log4j.*;

import com.plataforma.cursos.Model.Curso;
import com.plataforma.cursos.Model.Estudiante;
import com.plataforma.cursos.Service.CursoService;
import com.plataforma.cursos.Service.InscripcionService;
import com.plataforma.cursos.exception.CursoLlenoException;

public class Main {
    public static void main(String[] args) {
    CursoService cursoService= new CursoService();
    InscripcionService inscripcionService= new InscripcionService();

    Logger logger= LogManager.getLogger(Main.class);
    Curso javaBasico= new Curso ("C001","Java Basico", 2);
    Curso pythonBasico= new Curso ("C002","Python Basico", 2);

    cursoService.agregarCurso(javaBasico);
    cursoService.agregarCurso(pythonBasico);

    Estudiante estudiante1= new Estudiante("E001","Juan Perez","juanperez@gmail.com");
    Estudiante estudiante2= new Estudiante("E002","Maria Gomez","mariagomez@gmail.com");
    Estudiante estudiante3= new Estudiante("E003","Carlos Lopez","carloslopez@gmail.com");

    try {
        inscripcionService.inscribirEstudiante(estudiante1, javaBasico);
        inscripcionService.inscribirEstudiante(estudiante2, pythonBasico);
        inscripcionService.inscribirEstudiante(estudiante3, javaBasico);
        inscripcionService.inscribirEstudiante(estudiante2, javaBasico);
    } catch (CursoLlenoException e) {
        logger.error("Error de inscripcion: "+e.getMessage());
    }
    
    //Mostrar cursos y sus estudiantes inscritos
    System.out.println("Cursos Disponibles: ");
    for (Curso curso: cursoService.listaCursos()) {
        System.out.println("Curso: "+curso.getNombre());
        System.out.println("Estudiantes Inscritos: ");
        for (Estudiante estudiante: curso.getEstudiantesInscritos()) {
            System.out.println("- "+estudiante.getNombre());
        }
    }

}
}
