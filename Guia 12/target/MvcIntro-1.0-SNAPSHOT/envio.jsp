<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 1/11/2023
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="css/tabla1.css" rel="stylesheet" type="text/css" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title><fmt:message key="enviarmensaje"/></title>
</head>
<jsp:useBean id="mensaje" scope="request" class="javabeans.MensajeBean" />
<jsp:setProperty name="mensaje" property="*" />
<c:if test="${not empty param.texto}">
    <jsp:forward page="Controlador?operacion=grabar"/>
</c:if>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <div class="row">
                <h1><fmt:message key="generacion"/></h1>
            </div>
            <form method="post">
                <p class="center-block"><fmt:message key="datosmensaje" /></p>
                <div class="form-group">
                    <fmt:message key="destinatario"/>
                    <input class="form-control" type="text" name="destino" >
                </div>
                <div class="form-group">
                    <fmt:message key="remitente"/>
                    <input type="text" class="form-control" name="remite">
                </div>
                <div class="form-group">
                    <fmt:message key="texto"/>
                    <textarea name="texto" class="form-control" id="texto"></textarea>
                </div>
                <hr><br/>
                <input type="submit" class="btn btn-info" name="submit" value="<fmt:message
key="enviar"/>">
                <input type="reset" class="btn btn-info" value="<fmt:message key="limpiar"/>">
            </form>
        </div>
    </div>
</div>
</body>
</html>
