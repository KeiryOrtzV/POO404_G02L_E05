<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="variableDePagina" scope="page">
    Esta información se guarda en la página
</c:set>
<c:set var="variableDeSesion" scope="session">
    Esta información se guarda en la sesión
</c:set>
<c:set var="variableDeAplicacion" scope="application">
    Esta información se guarda en la aplicación
</c:set>
<%-- graba la variable cuatro=4 en el ámbito page --%>
<c:set var="cuatro" value="El valor de esta varialbe es: ${2 + 2}" scope="application"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Etiquetas JSTL</title>
</head>
<body>
<div class="container">
    <div class="row">
        &nbsp;
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading">Uso de etiqueta c:set</div>
        <div class="panel-body">
            <p>${variableDePagina}</p>
            <p>${variableDeSesion}</p>
            <p>${variableDeAplicacion}</p>
            <p>${cuatro}</p>
        </div>
    </div>
    <a href="verambito.jsp">Ir a ver pagina ambito de aplicación</a>
</div>
</body>
</html>