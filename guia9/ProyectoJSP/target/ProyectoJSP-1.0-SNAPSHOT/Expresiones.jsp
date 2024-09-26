<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.util.*" %>
<%!
    String titulo = "Mi primer ejemplo con JSP";
    String cadena = "Primer ejemplo";
%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPEhtml>
<html>
<head>
    <title><%=titulo%>
    </title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%
    //Obteniendo la fecha actual
    Date fechaActual = new Date();
//Formateando la fecha
    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
%>
<div class="container">
    <div class="card" style="width: 18rem;">
        <h5 class="card-header"><%=cadena%>
        </h5>
        <ul class="list-group list-group-flush">
            <li class="list-group-item"><%="La fecha actual es: " +
                    formatoFecha.format(fechaActual)%>
            </li>
            <li class="list-group-item"><%="La hora actual es: " +
                    formatoHora.format(fechaActual)%>
            </li>
            <li class="list-group-item"><%=" El tamaño de la cadena ‘" + cadena +
                    "’ es:" + cadena.length()%>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
