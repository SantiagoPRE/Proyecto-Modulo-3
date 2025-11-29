package com.plataforma.cursos.Model;

public class Estudiante {

    private String id;
    private String nombre;
    private String correo;


    public Estudiante(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }


    public String getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    


}
