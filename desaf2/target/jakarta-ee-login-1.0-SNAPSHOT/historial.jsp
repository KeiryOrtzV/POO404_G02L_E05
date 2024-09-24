<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Historial de Compras</title>
</head>
<body>
<h1>Historial de Compras</h1>
<table border="1">
    <tr>
        <th>Estado</th>
        <th>Comentario del Empleado</th>
    </tr>
    <c:forEach var="pedido" items="${historial}">
        <tr>
            <td>${pedido.estado}</td>
            <td>${pedido.comentariosEmpleado}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
