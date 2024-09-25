package com.example.servlet;

import com.example.dao.PlatoDAO;
import com.example.model.Plato;
import com.example.util.DatabaseUtil;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MenuServlet: doGet iniciado");



        PlatoDAO platoDAO = new PlatoDAO();
        List<Plato> platos = platoDAO.getAllPlatos();

        System.out.println("Número de platos recuperados: " + (platos != null ? platos.size() : "null"));

        if (platos != null && !platos.isEmpty()) {
            for (Plato plato : platos) {
                System.out.println("Plato: " + plato.getNombre_plato() + ", Precio: " + plato.getPrecio());
            }
        } else {
            System.out.println("No se recuperaron platos de la base de datos.");
        }

        request.setAttribute("platos", platos);
        request.getRequestDispatcher("menu").forward(request, response);

        System.out.println("MenuServlet: doGet completado");
    }
}