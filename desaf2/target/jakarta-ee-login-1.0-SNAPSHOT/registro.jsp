<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Registro de Usuario</title>
</head>
<body>
<h2>Registro de Usuario</h2>
<% if(request.getAttribute("error") != null) { %>
<p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>
<form action="registro" method="post">
  <input type="text" name="nombreUsuario" required placeholder="Nombre de usuario">
  <input type="password" name="contraseña" required placeholder="Contraseña">
  <select name="rol" required>
    <option value="">Seleccione un rol</option>
    <option value="cliente">Cliente</option>
    <option value="empleado">Empleado</option>
  </select>
  <button type="submit">Registrar</button>
</form>
<p>¿Ya tienes una cuenta? <a href="login.jsp">Inicia sesión aquí</a></p>
</body>
</html>