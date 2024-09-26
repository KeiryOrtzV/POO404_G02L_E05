package com.example.servlet;

import com.example.dao.PedidoDAO;
import com.example.model.Pedido;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/historialCompras")
public class ServletHistorialCompras extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> pedidos = pedidoDAO.getPedidosSimples();

        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("historialCompras.jsp").forward(request, response);
    }
}