package com.tempertrapp.model;

public class Empleado extends Usuario {
    private String rol;

    // Constructor vacío
    public Empleado() {
    }

    // Constructor con parámetros
    public Empleado(int id, String nombre, String email, String password, String rol) {
        super(id, nombre, email, password);
        this.rol = rol;
    }

    // Getters y setters
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
