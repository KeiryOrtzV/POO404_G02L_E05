<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<body>
<h2>Login</h2>
<% if(request.getParameter("registro") != null && request.getParameter("registro").equals("exitoso")) { %>
<p style="color: green;">Registro exitoso. Por favor, inicia sesión.</p>
<% } %>
<% if(request.getAttribute("error") != null) { %>
<p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>
<form action="login" method="post">
  <input type="text" name="nombreUsuario" required placeholder="Nombre de usuario">
  <input type="password" name="contraseña" required placeholder="Contraseña">
  <button type="submit">Iniciar sesión</button>
</form>
<p>¿No tienes una cuenta? <a href="registro.jsp">Regístrate aquí</a></p>
</body>
</html>