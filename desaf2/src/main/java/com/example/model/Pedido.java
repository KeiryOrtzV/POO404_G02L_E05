package com.example.model;


import com.example.model.DetallePedido;

import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Date fechaPedido;
    private String estado;
    private String formaPago;
    private String comentarios;
    private double total;
    private List<DetallePedido> detalles;
    private String comentariosEmpleado;
    private String nombreEmpleado;


    // Constructor
    public Pedido(int id, Date fechaPedido, String estado, String formaPago, String comentarios, double total) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.formaPago = formaPago;
        this.comentarios = comentarios;
        this.total = total;
    }
    public Pedido() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }
    // Nuevos getters y setters
    public String getComentariosEmpleado() {
        return comentariosEmpleado;
    }

    public void setComentariosEmpleado(String comentariosEmpleado) {
        this.comentariosEmpleado = comentariosEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
}