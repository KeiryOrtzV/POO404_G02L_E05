<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login - Restaurante Exquisito</title>
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


    .form-control {
      border: none;
      border-bottom: 2px solid #c82333;
      border-radius: 0;
      padding: 12px 0;
      font-size: 16px;
      color: #333;
      background-color: transparent;
    }

    .form-control::placeholder {
      color: #999;
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
  <h2>Restaurante The Temper Trap</h2>
  <% if(request.getParameter("registro") != null && request.getParameter("registro").equals("exitoso")) { %>
  <div class="alert alert-success" role="alert">
    Registro exitoso. Por favor, inicia sesión.
  </div>
  <% } %>
  <% if(request.getAttribute("error") != null) { %>
  <div class="alert alert-danger" role="alert">
    <%= request.getAttribute("error") %>
  </div>
  <% } %>
  <form action="login" method="post">
    <div class="mb-3">
      <input type="text" class="form-control" name="nombreUsuario" required placeholder="Nombre de usuario">
    </div>
    <div class="mb-3">
      <input type="password" class="form-control" name="contraseña" required placeholder="Contraseña">
    </div>
    <div class="d-grid">
      <button type="submit" class="btn btn-primary">Iniciar sesión</button>
    </div>
  </form>
  <p class="text-center mt-3">¿No tienes una cuenta? <a href="registro.jsp">Regístrate aquí</a></p>
</div>
</body>
</html>