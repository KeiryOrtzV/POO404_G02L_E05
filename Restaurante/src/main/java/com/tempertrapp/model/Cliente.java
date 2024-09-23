package com.tempertrapp.model;

public class Cliente extends Usuario {
    private String telefono;
    private String direccion;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(int id, String nombre, String email, String password, String telefono, String direccion) {
        super(id, nombre, email, password);
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Getters y setters
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
