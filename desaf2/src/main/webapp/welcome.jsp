<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenido</title>
</head>
<body>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("login.jsp");
    } else {
%>
<h2>Bienvenido, <%= usuario.getNombreUsuario() %>!</h2>
<p>Tu rol es: <%= usuario.getRol() %></p>
<a href="logout">Cerrar sesión</a>
<% } %>
</body>
</html>