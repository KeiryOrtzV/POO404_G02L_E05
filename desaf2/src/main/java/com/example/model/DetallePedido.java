package com.example.model;

public class DetallePedido {
    private int id;
    private Plato plato;
    private int cantidad;
    private double subtotal;

    // Constructor
    public DetallePedido(int id, Plato plato, int cantidad, double subtotal) {
        this.id = id;
        this.plato = plato;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetallePedido() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}