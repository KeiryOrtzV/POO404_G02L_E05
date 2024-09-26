<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.Pedido" %>
<%@ page import="com.example.model.DetallePedido" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Detalle del Pedido - Restaurante Exquisito</title>
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Cinzel:wght@400;700&family=Lora:ital,wght@0,400;0,700;1,400;1,700&display=swap');

    body {
      font-family: 'Lora', serif;
      background-color: #f5f5f5;
      color: #333;
    }

    .container {
      max-width: 800px;
      margin: 50px auto;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
      padding: 40px;
    }

    h1 {
      font-family: 'Cinzel', serif;
      font-size: 32px;
      font-weight: 700;
      color: #c82333;
      text-align: center;
      margin-bottom: 30px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 20px;
    }

    table th, table td {
      padding: 12px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    table th {
      background-color: #c82333;
      color: #fff;
    }

    .btn-primary {
      background-color: #c82333;
      border-color: #c82333;
      font-family: 'Cinzel', serif;
      font-size: 18px;
      font-weight: 700;
      padding: 12px 24px;
      border-radius: 4px;
      transition: background-color 0.3s ease;
    }

    .btn-primary:hover {
      background-color: #a61c29;
      border-color: #a61c29;
    }

    .plato-descripcion {
      font-style: italic;
      color: #666;
    }

    .estado-pedido {
      font-weight: bold;
      color: #c82333;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Detalle del Pedido</h1>

  <%
    Pedido pedido = (Pedido)request.getAttribute("pedido");
    if (pedido != null) {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
  %>
  <h2>Pedido #<%= pedido.getId() %></h2>
  <p>Fecha: <%= sdf.format(pedido.getFechaPedido()) %></p>
  <p>Estado: <span class="estado-pedido"><%= pedido.getEstado() %></span></p>
  <p>Forma de Pago: <%= pedido.getFormaPago() %></p>
  <p>Comentarios del cliente: <%= pedido.getComentarios() != null && !pedido.getComentarios().isEmpty() ? pedido.getComentarios() : "Sin comentarios" %></p>

  <table>
    <tr>
      <th>Plato</th>
      <th>Descripción</th>
      <th>Cantidad</th>
      <th>Precio Unitario</th>
      <th>Subtotal</th>
    </tr>
    <% for(DetallePedido detalle : pedido.getDetalles()) { %>
    <tr>
      <td><%= detalle.getPlato().getNombre_plato() %></td>
      <td class="plato-descripcion"><%= detalle.getPlato().getDescripcion() %></td>
      <td><%= detalle.getCantidad() %></td>
      <td>$<%= String.format("%.2f", detalle.getPlato().getPrecio()) %></td>
      <td>$<%= String.format("%.2f", detalle.getSubtotal()) %></td>
    </tr>
    <% } %>
    <tr>
      <th colspan="4">Total</th>
      <td>$<%= String.format("%.2f", pedido.getTotal()) %></td>
    </tr>
  </table>

  <% if (!"COMPLETADO".equals(pedido.getEstado())) { %>
  <form action="pago" method="post">
    <input type="hidden" name="idPedido" value="<%= pedido.getId() %>">
    <select name="formaPago">
      <option value="EFECTIVO" <%= "EFECTIVO".equals(pedido.getFormaPago()) ? "selected" : "" %>>Efectivo</option>
      <option value="TARJETA" <%= "TARJETA".equals(pedido.getFormaPago()) ? "selected" : "" %>>Tarjeta</option>
    </select>
    <textarea name="comentarios" placeholder="Comentarios adicionales"><%= pedido.getComentarios() != null ? pedido.getComentarios() : "" %></textarea>
    <input type="submit" class="btn btn-primary" value="Finalizar Pedido">
  </form>
  <% } else { %>
  <p>Este pedido ya ha sido completado.</p>
  <% } %>

  <% } else { %>
  <p>No se encontró el pedido especificado.</p>
  <% } %>
</div>
</body>
</html>