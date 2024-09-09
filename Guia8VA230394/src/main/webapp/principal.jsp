<%@ page import="javax.servlet.http.HttpSession" %>
<%
  HttpSession session_actual = (HttpSession) request.getSession(false);
  String usuario = (session_actual != null) ? (String) session_actual.getAttribute("USER") : null;
  String nombres = (session_actual != null) ? (String) session_actual.getAttribute("NAME") : null;

  // Redirigir a la página de login si el usuario no está autenticado
  if (usuario == null) {
    response.sendRedirect("login.jsp");
    return; // Asegúrate de detener la ejecución aquí
  }
%>

<html lang="es">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Bienvenido <%=nombres%></title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/estilo.css">
  <script src="js/scripts.js" ></script>
</head>
<body class="container">
<h1 class="text-center">Bienvenido a POO404</h1>
<h2 class="text-center">
  Bienvenido: (<%=usuario%>) <%=nombres%>
</h2>
<form method="post" action="GeneraSession">
  <input type="hidden" value="salir" name="operacion">
  <input style="margin-left: 45%;" type="submit" value="Cerrar cessi&oacute;n"
         class="btn btn-success">
</form>
</body>
</html>