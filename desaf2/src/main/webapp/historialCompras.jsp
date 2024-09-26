<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.Pedido" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Historial de Compras - Restaurante Exquisito</title>
    <style>
        /* ... estilos existentes ... */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #c82333;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Historial de Compras</h1>

    <%
        List<Pedido> pedidos = (List<Pedido>)request.getAttribute("pedidos");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        if (pedidos != null && !pedidos.isEmpty()) {
    %>
    <table>
        <tr>
            <th>ID Pedido</th>
            <th>Fecha</th>
            <th>Estado</th>
            <th>Forma de Pago</th>
            <th>Comentarios</th>
            <th>Total</th>
        </tr>
        <% for (Pedido pedido : pedidos) { %>
        <tr>
            <td><%= pedido.getId() %></td>
            <td><%= sdf.format(pedido.getFechaPedido()) %></td>
            <td><%= pedido.getEstado() %></td>
            <td><%= pedido.getFormaPago() %></td>
            <td><%= pedido.getComentarios() != null ? pedido.getComentarios() : "" %></td>
            <td>$<%= String.format("%.2f", pedido.getTotal()) %></td>
        </tr>
        <% } %>
    </table>
    <%
    } else {
    %>
    <p>No hay pedidos en el historial.</p>
    <%
        }
    %>
</div>
</body>
</html>