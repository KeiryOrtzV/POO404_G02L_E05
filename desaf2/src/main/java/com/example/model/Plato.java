package com.example.model;
public class Plato {
    private int id_plato;
    private String nombre_plato;
    private String descripcion;
    private double precio;
    private boolean disponibilidad;

    // Constructor
    public Plato(int id_plato, String nombre_plato, String descripcion, double precio, boolean disponibilidad) {
        this.id_plato = id_plato;
        this.nombre_plato = nombre_plato;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    // Getters y setters
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

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    // Método para representar el objeto como String (opcional)
    @Override
    public String toString() {
        return "Plato{" +
                "id_plato=" + id_plato +
                ", nombre_plato='" + nombre_plato + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", disponibilidad=" + disponibilidad +
                '}';
    }
}