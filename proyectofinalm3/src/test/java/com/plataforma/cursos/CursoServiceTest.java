package com.plataforma.cursos;
import org.junit.jupiter.api.*;

import com.plataforma.cursos.Model.Curso;
import com.plataforma.cursos.Service.CursoService;
import com.plataforma.cursos.exception.CursoNoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

public class CursoServiceTest {

    @Test
    void agregarCursoTest() {
       CursoService cursoService= new CursoService();
        cursoService.agregarCurso(new Curso("C002", "Python Basico", 3));
        assertEquals(1, cursoService.listaCursos().size());
    }

    @Test
    void buscarCursoPorCodigoTest() throws CursoNoEncontradoException {
        CursoService cursoService= new CursoService();
        Curso curso= new Curso("C003", "Java Intermedio", 2);
        cursoService.agregarCurso(curso);
        Curso encontrar= cursoService.buscarCursoPorCodigo("C003");
        assertNotNull(encontrar);
    }
    
    @Test
    void buscarCursoInexistenteTest() {
        CursoService cursoService= new CursoService();
        Exception exception= assertThrows(CursoNoEncontradoException.class, ()-> {
            cursoService.buscarCursoPorCodigo("");
        });
        assertEquals("Curso con el codigo  no encontrado", exception.getMessage());
    }
    
    @Test
    void listarCursosTest() {
        CursoService cursoService= new CursoService();
        cursoService.agregarCurso(new Curso("C001", "Java Basico", 5));
        cursoService.agregarCurso(new Curso("C002", "Java Avanzado", 10));
        cursoService.agregarCurso(new Curso("C003", "Python Basico", 8));
        assertEquals(3, cursoService.listaCursos().size());
    }

}
