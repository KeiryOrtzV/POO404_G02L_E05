<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Plato" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Menú - Restaurante Exquisito</title>
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
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #c82333;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #c82333;
            color: white;
            font-weight: bold;
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
    </style>
</head>
<body>
<div class="container">
    <h1>Nuestro Menú</h1>

    <%
        List<Plato> platos = (List<Plato>) request.getAttribute("platos");
        if (platos == null || platos.isEmpty()) {
    %>
    <p>No se encontraron platos en el menú. Por favor, verifica la conexión con la base de datos y el servlet.</p>
    <%
    } else {
    %>
    <p>Número de platos encontrados: <%= platos.size() %></p>
    <form action="orden" method="post">
        <table>
            <tr>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Precio</th>
                <th>Seleccionar</th>
            </tr>
            <%
                for (Plato plato : platos) {
            %>
            <tr>
                <td><%= plato.getNombre_plato() %></td>
                <td><%= plato.getDescripcion() %></td>
                <td>$<%= String.format("%.2f", plato.getPrecio()) %></td>
                <td>
                    <input type="checkbox" name="platos" value="<%= plato.getId_plato() %>">
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <input type="submit" class="btn btn-primary" value="Hacer pedido">
    </form>
    <%
        }
    %>
</div>
</body>
</html>
