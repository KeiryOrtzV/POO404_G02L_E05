<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<body>
<h2>Login</h2>
<% if(request.getAttribute("error") != null) { %>
<p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>
<form action="login" method="post">
  <label for="nombreUsuario">Nombre de usuario:</label>
  <input type="text" id="nombreUsuario" name="nombreUsuario" required><br><br>
  <label for="contraseña">Contraseña:</label>
  <input type="password" id="contraseña" name="contraseña" required><br><br>
  <input type="submit" value="Iniciar sesión">
</form>
</body>
</html>
