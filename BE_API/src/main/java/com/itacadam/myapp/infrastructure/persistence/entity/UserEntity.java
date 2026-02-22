package com.itacadam.myapp.infrastructure.persistence.entity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "edad")
    private int edad;

    @Column(name = "administrador")
    private boolean administrador;
   

    public UserEntity() {
    }

    public UserEntity(Long id, String nombre, String contrasena, int edad, boolean administrador) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.edad = edad;
        this.administrador = administrador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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





}
