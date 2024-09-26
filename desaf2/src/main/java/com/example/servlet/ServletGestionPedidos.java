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

@WebServlet("/gestionPedidos")
public class ServletGestionPedidos extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> pedidos = pedidoDAO.getTodosPedidos();

        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("gestionPedidos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        String nuevoEstado = request.getParameter("nuevoEstado");
        String comentariosEmpleado = request.getParameter("comentariosEmpleado");
        String nombreEmpleado = request.getParameter("nombreEmpleado");

        PedidoDAO pedidoDAO = new PedidoDAO();
        boolean actualizado = pedidoDAO.actualizarEstadoPedido(idPedido, nuevoEstado, comentariosEmpleado, nombreEmpleado);

        if (actualizado) {
            response.sendRedirect(request.getContextPath() + "/gestionPedidos");
        } else {
            response.getWriter().println("Error al actualizar el pedido");
        }
    }
}