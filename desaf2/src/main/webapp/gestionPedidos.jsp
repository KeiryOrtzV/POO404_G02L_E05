<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.Pedido" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestión de Pedidos - The Temper Trap</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 1200px;
            margin: auto;
            overflow: auto;
            padding: 0 20px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            text-align: left;
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        form {
            display: inline-block;
        }
        select, input[type="text"], input[type="submit"] {
            padding: 8px;
            margin: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .btn-secondary {
            background-color: #6c757d;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            text-decoration: none; /* Sin subrayado en el enlace */
            display: inline-block; /* Para mantener el formato de botón */
            margin-top: 20px; /* Espacio superior */
            border-radius: 4px; /* Bordes redondeados */
        }
        .btn-secondary:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Gestión de Pedidos</h1>

    <table>
        <tr>
            <th>ID Pedido</th>
            <th>Fecha</th>
            <th>Estado</th>
            <th>Forma de Pago</th>
            <th>Total</th>
            <th>Comentarios Cliente</th>
            <th>Comentarios Empleado</th>
            <th>Acciones</th>
        </tr>
        <%
            List<Pedido> pedidos = (List<Pedido>)request.getAttribute("pedidos");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            for (Pedido pedido : pedidos) {
        %>
        <tr>
            <td><%= pedido.getId() %></td>
            <td><%= sdf.format(pedido.getFechaPedido()) %></td>
            <td><%= pedido.getEstado() %></td>
            <td><%= pedido.getFormaPago() %></td>
            <td>$<%= String.format("%.2f", pedido.getTotal()) %></td>
            <td><%= pedido.getComentarios() != null ? pedido.getComentarios() : "" %></td>
            <td><%= pedido.getComentariosEmpleado() != null ? pedido.getComentariosEmpleado() : "" %></td>
            <td>
                <form action="gestionPedidos" method="post">
                    <input type="hidden" name="idPedido" value="<%= pedido.getId() %>">
                    <select name="nuevoEstado">
                        <option value="Aceptado">Aceptado</option>
                        <option value="En proceso de elaborar">En proceso de elaborar</option>
                        <option value="Entregado al repartidor">Entregado al repartidor</option>
                        <option value="Entregado al cliente">Entregado al cliente</option>
                    </select>
                    <input type="text" name="comentariosEmpleado" placeholder="Comentarios">
                    <input type="text" name="nombreEmpleado" placeholder="Nombre del empleado">
                    <input type="submit" value="Actualizar">
                </form>
            </td>
        </tr>
        <% } %>
    </table>

    <!-- Botón para volver al menú principal -->
    <a href="menu" class="btn-secondary">Volver al Menú Principal</a>
</div>
</body>
</html>
