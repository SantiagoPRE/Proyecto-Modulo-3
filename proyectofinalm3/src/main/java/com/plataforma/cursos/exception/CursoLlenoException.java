package com.plataforma.cursos.exception;

public class CursoLlenoException extends Exception {

   public CursoLlenoException(String mensaje){
    super(mensaje);
   }


   public CursoLlenoException(String mensaje, Throwable cause){
    super("El curso alcanzo su capacidad maxima por lo que no puede recibir mas estudiantes",cause);

   }
}

