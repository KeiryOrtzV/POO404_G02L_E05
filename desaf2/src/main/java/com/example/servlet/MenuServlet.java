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

        // Verificar la conexión a la base de datos
        System.out.println("Probando conexión a la base de datos...");
        if (DatabaseUtil.testConnection()) {
            System.out.println("Conexión a la base de datos exitosa");
        } else {
            System.err.println("No se pudo conectar a la base de datos");
        }


        System.out.println("Creando instancia de PlatoDAO...");
        PlatoDAO platoDAO = new PlatoDAO();
        System.out.println("Llamando a getAllPlatos()...");
        List<Plato> platos = platoDAO.getAllPlatos();

        System.out.println("Número de platos recuperados: " + (platos != null ? platos.size() : "null"));
        if (platos != null && !platos.isEmpty()) {
            for (Plato plato : platos) {
                System.out.println("Plato: " + plato.getNombre_plato() + ", Precio: " + plato.getPrecio());
            }
        } else {
            System.out.println("No se recuperaron platos de la base de datos.");
        }


        System.out.println("Estableciendo atributo 'platos' en la request...");
        request.setAttribute("platos", platos);


        System.out.println("Redirigiendo a menu.jsp...");
        request.getRequestDispatcher("menu.jsp").forward(request, response);

        System.out.println("MenuServlet: doGet completado");
    }
}