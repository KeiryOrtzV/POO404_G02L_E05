package com.example.servlet;

import com.example.dao.PlatoDAO;
import com.example.dao.PedidoDAO;
import com.example.model.Plato;
import com.example.model.Pedido;
import com.example.model.DetallePedido;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/procesarPedido")
public class ProcesarPedidoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] platosSeleccionados = request.getParameterValues("platos");

        if (platosSeleccionados != null && platosSeleccionados.length > 0) {
            PlatoDAO platoDAO = new PlatoDAO();
            PedidoDAO pedidoDAO = new PedidoDAO();

            Pedido nuevoPedido = new Pedido();
            nuevoPedido.setFechaPedido(new Date());
            nuevoPedido.setEstado("PENDIENTE");
            nuevoPedido.setFormaPago("PENDIENTE");
            nuevoPedido.setComentarios("");

            List<DetallePedido> detalles = new ArrayList<>();
            double total = 0;

            for (String idPlato : platosSeleccionados) {
                try {
                    int platoId = Integer.parseInt(idPlato);
                    System.out.println("Procesando plato con ID: " + platoId);

                    Plato plato = platoDAO.getPlatoById(platoId);  // Corregido a getPlatoById
                    if (plato != null) {
                        DetallePedido detalle = new DetallePedido();
                        detalle.setPlato(plato);
                        detalle.setCantidad(1); // Por defecto 1, puedes ajustar esto si permites cantidades
                        detalle.setSubtotal(plato.getPrecio());
                        detalles.add(detalle);
                        total += plato.getPrecio();
                    } else {
                        System.err.println("No se encontró el plato con ID: " + platoId);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("ID de plato inválido: " + idPlato);
                }
            }

            nuevoPedido.setDetalles(detalles);
            nuevoPedido.setTotal(total);

            int idPedido = pedidoDAO.insertarPedido(nuevoPedido);

            if (idPedido != -1) {
                // Redirigir a la página de pago con el ID del pedido
                response.sendRedirect("pago?idPedido=" + idPedido);
            } else {
                // Si hubo un error al insertar el pedido, volver al menú
                request.setAttribute("error", "No se pudo procesar el pedido. Por favor, intente nuevamente.");
                request.getRequestDispatcher("menu").forward(request, response);
            }
        } else {
            // Si no se seleccionaron platos, volver al menú
            response.sendRedirect("menu");
        }
    }
}
