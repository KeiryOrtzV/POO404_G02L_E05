<%--
  Created by IntelliJ IDEA.
  User: MINEDUCYT
  Date: 23/9/2024
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession session_actual= request.getSession(false);
    String usuario =(String) session_actual.getAttribute("USER");
    String nombres =(String) session_actual.getAttribute("NAME");
    if (usuario==null){
        response.sendRedirect("login.jsp");
    }
%>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Bienvenido <%=nombres%></title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/estilo.css">
    <script src="js/bootstrap.min.js" ></script>
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