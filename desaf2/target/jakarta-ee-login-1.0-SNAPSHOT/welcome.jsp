<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.model.Usuario" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bienvenido - Restaurante The Temper Trap</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Cinzel:wght@400;700&family=Lora:ital,wght@0,400;0,700;1,400;1,700&display=swap');

        body {
            font-family: 'Lora', serif;
            background-color: #f5f5f5;
            color: #333;
        }

        .container {
            max-width: 400px;
            margin: 100px auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            padding: 40px;
        }

        h2 {
            font-family: 'Cinzel', serif;
            font-size: 32px;
            font-weight: 700;
            color: #c82333;
            text-align: center;
            margin-bottom: 30px;
        }

        .alert {
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 4px;
        }

        .alert-success {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }

        .alert-danger {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }

        .text-center a {
            color: #c82333;
            text-decoration: none;
        }

        .text-center a:hover {
            color: #a61c29;
        }
    </style>
</head>
<body>
<div class="container">
    <%
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            response.sendRedirect("login.jsp");
        } else {
    %>
    <h2>¡Bienvenido a The Temper Trap, <%= usuario.getNombreUsuario() %>!</h2>
    <p>Estamos encantados de tenerte aquí. Tu rol es: <strong><%= usuario.getRol() %></strong>.</p>
    <p>En The Temper Trap, entendemos tus preocupaciones sobre los costos de las aplicaciones de delivery. Por eso, hemos creado un sistema web de pedidos que te permite realizar tus pedidos de manera directa, sin los costos excesivos.</p>
    <p>Explora nuestro menú visible y realiza tus pedidos de forma fácil y rápida. Nuestro equipo está aquí para asegurarse de que tu experiencia sea excelente.</p>
    <a href="logout" class="btn-primary">Cerrar sesión</a>
    <% } %>
</div>
</body>
</html>
