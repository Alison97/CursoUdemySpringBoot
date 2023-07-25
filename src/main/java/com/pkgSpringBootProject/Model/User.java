package com.pkgSpringBootProject.Model;

public class User {
    private String nombre;
    private String apellido;
    private String email;

    public User() {
    }

    //CONSTRUCTOR
    public User(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() { return email; }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) { this.email = email; }
}
