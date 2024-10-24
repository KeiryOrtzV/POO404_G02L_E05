<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="generacion"/></title>
    <link href="css/tabla1.css" rel="stylesheet" type="text/css" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container ">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <br/><br/>
            <a href="Controlador?operacion=envio" class="btn btn-info"><fmt:message
                    key="enviar"/></a>
            <br/><br/>
            <a href="Controlador?operacion=muestra" class="btn btn-success"><fmt:message
                    key="leer"/></a>
            <c:if test="${not empty result}">
                <div class="alert alert-info">
                    <strong>Mensaje!</strong> <fmt:message key="exitoso"/>
                    <br>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
