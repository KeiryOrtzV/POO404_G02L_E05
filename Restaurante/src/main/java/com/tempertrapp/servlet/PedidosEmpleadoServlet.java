package com.tempertrapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/pedidosEmpleado")
public class PedidosEmpleadoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aquí iría la lógica para obtener los pedidos de la base de datos
        request.getRequestDispatcher("pedidosEmpleado.jsp").forward(request, response);
    }
}