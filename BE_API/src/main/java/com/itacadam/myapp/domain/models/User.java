package com.itacadam.myapp.domain.models;

public class User {

    private Long id;
    private String nombre;
    private String contrasena;
    private int edad;
    private boolean administrador;
    private String rol;

    public User() {
    }

    public User(Long id,String nombre, String contrasena, int edad, boolean administrador) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.edad = edad;
        this.administrador = administrador;
        this.rol = administrador ? "ADMIN" : "USER";
    }


    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public boolean isAdministrador() {
        return administrador;
    }
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


}