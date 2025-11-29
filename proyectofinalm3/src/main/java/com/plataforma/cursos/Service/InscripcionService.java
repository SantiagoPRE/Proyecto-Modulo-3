package com.plataforma.cursos.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.plataforma.cursos.Model.Inscripcion;
import com.plataforma.cursos.exception.CursoLlenoException;
import com.plataforma.cursos.exception.EstudianteNoEncontradoException;
import com.plataforma.cursos.Model.Curso;
import com.plataforma.cursos.Model.Estudiante;

public class InscripcionService {

        private static final Logger logger= LogManager.getLogger(InscripcionService.class);
        private List<Inscripcion> inscripciones;

        public InscripcionService(){
        this.inscripciones= new ArrayList<>();
        }


    public void inscribirEstudiante(Estudiante estudiante, Curso curso) throws CursoLlenoException{
        if (curso.estaLleno()) {
            logger.error("Intento de inscripcion fallido: curso lleno {} en el curso {}: cupo lleno"+curso.getNombre());
            throw new CursoLlenoException("El curso "+curso.getNombre()+" esta lleno no se puede inscribir al estudiante");
        }
        curso.agregarEstudiante(estudiante);
        Inscripcion inscripcion= new Inscripcion(estudiante, curso);
        inscripciones.add(inscripcion);
        logger.info("Estudiante {} agregado exitosamente al curso {}."+estudiante.getNombre(), curso.getNombre());
    }

    public List<Inscripcion> buscarInscripcionesPorEstudiante(Estudiante estudiante) throws EstudianteNoEncontradoException{

        List<Inscripcion> resultado= new ArrayList<>();
        
        for(Inscripcion inscripcion: inscripciones){
            if(inscripcion.getEstudiante().getId().equals(estudiante.getId())){
                resultado.add(inscripcion);
            }
        }
        if(resultado.isEmpty()){
            logger.warn("No se encontraron inscripciones para el estudiante con ID: {}"+estudiante.getId());
            throw new EstudianteNoEncontradoException("No se encontraron inscripciones para el estudiante");
        }
        else{
            logger.info("Se encontraron {} inscripciones para el estudiante con ID: {}"+resultado.size(), estudiante.getId());
        }
        return resultado;
    }
}




 