package com.plataforma.cursos.Model;

import java.time.LocalDate;

public class Inscripcion {

    private Curso curso;
    private Estudiante estudiante;
    private LocalDate fecha;


    public Inscripcion( Estudiante estudiante, Curso curso) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.fecha = LocalDate.now();
    }


    public Curso getCurso() {
        return curso;
    }


    public void setCurso(Curso curso) {
        this.curso = curso;
    }


    public Estudiante getEstudiante() {
        return estudiante;
    }


    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }


    public LocalDate getFecha() {
        return fecha;
    }


    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return "Inscripcion [curso=" + curso + ", estudiante=" + estudiante + ", fecha=" + fecha + "]";
    }

    
    
}
