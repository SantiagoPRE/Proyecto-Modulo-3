package com.plataforma.cursos.Model;
import java.util.List;
import java.util.ArrayList;

public class Curso {
    
    private String codigo;
    private String nombre;
    private int capacidad;
    private List<Estudiante> estudiantesInscritos;

    public Curso(String codigo, String nombre, int capacidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estudiantesInscritos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }


    public List<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void setEstudiantesInscritos(List<Estudiante> estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }

    public boolean estaLleno() {
       return estudiantesInscritos.size()>= capacidad;
    }

    @Override
    public String toString() {
        return "Curso [codigo=" + codigo + ", nombre=" + nombre + ", capacidad=" + capacidad + ", estudiantesInscritos="
                + estudiantesInscritos + "]";
    }

    public void agregarEstudiante(Estudiante estudiante) {
       if (!estaLleno()) {
        estudiantesInscritos.add(estudiante);
       }
    }

    
    
}
