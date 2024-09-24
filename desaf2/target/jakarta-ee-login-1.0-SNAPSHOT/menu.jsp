<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Menu" %>

<html>
<head>
    <title>Menú</title>
</head>
<body>
<h1>Menú de Platos</h1>
<table border="1">
    <thead>
    <tr>
        <th>Nombre del Plato</th>
        <th>Descripción</th>
        <th>Precio</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Menu> menu = (List<Menu>) request.getAttribute("menu");
        if (menu != null && !menu.isEmpty()) {
            for (Menu plato : menu) {
    %>
    <tr>
        <td><%= plato.getNombrePlato() %></td>
        <td><%= plato.getDescripcion() %></td>
        <td><%= plato.getPrecio() %></td>
        <td><!-- Aquí puedes agregar botones de acción --></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="4">No hay platos disponibles.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
