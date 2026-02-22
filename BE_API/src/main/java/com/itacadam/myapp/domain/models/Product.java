package com.itacadam.myapp.domain.models;

public class Product {
    private Long id;
    private String nombre;
    private String descripcion;
    private String imagenPath;
    private int stock;
    private double precio;

    public Product() {
    }

    public Product(Long id, String nombre, String descripcion, String imagenPath, int stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenPath = imagenPath;
        this.stock = stock;
        this.precio = precio;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenPath() {
        return imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
