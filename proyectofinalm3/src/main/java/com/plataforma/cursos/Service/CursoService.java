package com.plataforma.cursos.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import com.plataforma.cursos.Model.Curso;
import com.plataforma.cursos.exception.CursoNoEncontradoException;

public class CursoService {
    private static final Logger logger= LogManager.getLogger(CursoService.class);


private List<Curso> cursos;


public CursoService(){
this.cursos= new ArrayList<>();
}


public void agregarCurso(Curso curso){
    cursos.add(curso);
    logger.info("Curso agregado: "+curso.getNombre());

}

public List<Curso>listaCursos(){
    return cursos;
}


public Curso buscarCursoPorCodigo(String codigo)throws CursoNoEncontradoException{
for (Curso curso: cursos) {
    if(curso.getCodigo().equals(codigo)){
        return curso;
    }
}
logger.warn("Curso no encontrado con codigo: "+codigo);
throw new CursoNoEncontradoException("Curso con el codigo "+codigo+" no encontrado");
}


}