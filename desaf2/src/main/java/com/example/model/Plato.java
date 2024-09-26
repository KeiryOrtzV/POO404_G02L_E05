package com.example.model;

public class Plato {
    private int id_plato;
    private String nombre_plato;
    private String descripcion;
    private double precio;
    private boolean disponible;

    public Plato(int id_plato, String nombre_plato, String descripcion, double precio, boolean disponible) {
        this.id_plato = id_plato;
        this.nombre_plato = nombre_plato;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = disponible;
    }

    // Getters y Setters
    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
