package com.itacadam.myapp.domain.models;

public class Order {
    private Long id;
    private String descripcion;
    private double precio;
    private String estado;
    private String comprador;

    public Order(Long id, String descripcion, double precio, String estado, String comprador) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.comprador = comprador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }
}
