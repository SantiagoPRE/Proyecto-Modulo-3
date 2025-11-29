package com.plataforma.cursos.exception;

public class EstudianteNoEncontradoException extends Exception{


public EstudianteNoEncontradoException(String mensaje){
    super(mensaje);
}

public EstudianteNoEncontradoException(String mensaje, Throwable cause){
    super("El estudiante no se encontro en el sistema",cause);}
    
}

