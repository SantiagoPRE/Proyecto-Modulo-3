package com.plataforma.cursos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.plataforma.cursos.Model.Curso;
import com.plataforma.cursos.Model.Estudiante;
import com.plataforma.cursos.Service.CursoService;
import com.plataforma.cursos.Service.InscripcionService;
import com.plataforma.cursos.exception.CursoLlenoException;
import com.plataforma.cursos.exception.EstudianteNoEncontradoException;

public class InscripcionServiceTest {

    /**
     * Test para inscribir un estudiante en un curso exitosamente.
     */
    @Test
    void inscribirEstudianteTest() throws CursoLlenoException {
        CursoService cursoService= new CursoService();
        Curso curso= new Curso("C001", "Java Basico", 2);
        cursoService.agregarCurso(curso);
        InscripcionService inscripcionService= new InscripcionService();
        Estudiante estudiante= new Estudiante("12", "santiago", "santiago@ejemplo.com");
        inscripcionService.inscribirEstudiante(estudiante, curso);
        assertEquals(1,curso.getEstudiantesInscritos().size());

    }

    /**
     * Test para verificar que se lance una excepción cuando se intenta inscribir un estudiante en un curso lleno.
     */
    @Test
    void inscribirEstudianteCursoLlenoTest() throws CursoLlenoException {
        CursoService cursoService= new CursoService();
        Curso curso= new Curso("C002", "Python Basico", 1);
        cursoService.agregarCurso(curso);
        InscripcionService inscripcionService= new InscripcionService();
        Estudiante estudiante1= new Estudiante("13", "maria", "maria@ejemplo.com");
        Estudiante estudiante2= new Estudiante("14", "juan", "juan@ejemplo.com");
         inscripcionService.inscribirEstudiante(estudiante1, curso);
        Exception exception= assertThrows(CursoLlenoException.class, () -> {
            inscripcionService.inscribirEstudiante(estudiante2, curso);
        });
        assertEquals("El curso Python Basico esta lleno no se puede inscribir al estudiante", exception.getMessage());
    }

    /**
     * Test para buscar inscripciones por estudiante.
     */
    @Test
    void buscarInscrionesPorEstudianteTest() throws CursoLlenoException, EstudianteNoEncontradoException {
        CursoService cursoService= new CursoService();
        Curso curso1= new Curso("C003", "Java Avanzado", 2);
        Curso curso2= new Curso("C004", "JavaScript Basico", 2);
        cursoService.agregarCurso(curso1);
        cursoService.agregarCurso(curso2);
        InscripcionService inscripcionService= new InscripcionService();
        Estudiante estudiante= new Estudiante("15", "lucia", "lucia@ejemplo.com");
        inscripcionService.inscribirEstudiante(estudiante, curso1);
        inscripcionService.inscribirEstudiante(estudiante, curso2);
        assertFalse(inscripcionService.buscarInscripcionesPorEstudiante(estudiante).isEmpty());
    }

    /**
     * Test para verificar que se lance una excepción cuando no se encuentran inscripciones para un estudiante.
     */
    @Test
    void buscarInscripcionesVaciasPorEstudianteTest() {
        InscripcionService inscripcionService= new InscripcionService();
        Estudiante estudiante= new Estudiante("16", "carlos", "carlos@ejemplo.com");
        assertThrows(EstudianteNoEncontradoException.class,()-> {
            inscripcionService.buscarInscripcionesPorEstudiante(estudiante);
        });
}

    /**
     * Test para listar todas las inscripciones de un estudiante.
     */
    @Test
    void listarinscripcionesTest() throws CursoLlenoException, EstudianteNoEncontradoException {
        CursoService cursoService= new CursoService();
        Curso curso= new Curso("C005", "C++ Basico", 2);
        cursoService.agregarCurso(curso);
        Curso curso2= new Curso("C006", "Ruby Basico", 2);
        cursoService.agregarCurso(curso2);
        Curso curso3= new Curso("C007", "Go Basico", 2);
        cursoService.agregarCurso(curso3);
        InscripcionService inscripcionService= new InscripcionService();
        Estudiante estudiante= new Estudiante("17", "ana", "ana@ejemplo.com");
        inscripcionService.inscribirEstudiante(estudiante, curso);
        inscripcionService.inscribirEstudiante(estudiante, curso2);
        inscripcionService.inscribirEstudiante(estudiante, curso3);
        assertTrue(inscripcionService.buscarInscripcionesPorEstudiante(estudiante).size()==3);
       
    }
}