package com.example.servlet;

import com.example.dao.PedidoDAO;
import com.example.model.Pedido;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pago")
public class PagoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idPedidoStr = request.getParameter("idPedido");
        if (idPedidoStr != null && !idPedidoStr.isEmpty()) {
            try {
                int idPedido = Integer.parseInt(idPedidoStr);
                PedidoDAO pedidoDAO = new PedidoDAO();
                Pedido pedido = pedidoDAO.getPedidoPorId(idPedido);
                if (pedido != null) {
                    request.setAttribute("pedido", pedido);
                    request.getRequestDispatcher("pago.jsp").forward(request, response);
                } else {
                    response.sendRedirect("menu");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("menu");
            }
        } else {
            response.sendRedirect("menu");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idPedidoStr = request.getParameter("idPedido");
        String formaPago = request.getParameter("formaPago");
        String comentarios = request.getParameter("comentarios");

        if (idPedidoStr != null && !idPedidoStr.isEmpty()) {
            try {
                int idPedido = Integer.parseInt(idPedidoStr);
                PedidoDAO pedidoDAO = new PedidoDAO();
                Pedido pedido = pedidoDAO.getPedidoPorId(idPedido);

                if (pedido != null) {
                    pedido.setEstado("COMPLETADO");
                    pedido.setFormaPago(formaPago);
                    pedido.setComentarios(comentarios);

                    if (pedidoDAO.actualizarPedido(pedido)) {
                        response.sendRedirect("historialCompras");
                    } else {
                        request.setAttribute("error", "No se pudo actualizar el pedido");
                        doGet(request, response);
                    }
                } else {
                    response.sendRedirect("menu");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("menu");
            }
        } else {
            response.sendRedirect("menu");
        }
    }
}