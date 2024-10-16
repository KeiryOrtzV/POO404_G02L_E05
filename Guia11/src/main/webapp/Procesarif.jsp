<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Etiquetas JSTL</title>
</head>
<body>
<c:if test="${empty param.nombre}">
    <c:redirect url="Datosif.jsp">
        <c:param name="error" value="Nombre obligatorio"/>
    </c:redirect>
</c:if>
<c:if test="${empty param.apellido1}">
    <c:redirect url="Datosif.jsp">
        <c:param name="error" value="Primer apellido obligatorio"/>
    </c:redirect>
</c:if>
<c:if test="${empty param.apellido2}">
    <c:redirect url="Datosif.jsp">
        <c:param name="error" value="Segundo apellido obligatorio"/>
    </c:redirect>
</c:if>
<div class="container">
    <div class="row">
        &nbsp;
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading">Datos recibidos</div>
        <div class="panel-body">
            <p>Nombre: <strong><c:out value="${param.nombre}" /></strong></p>
            <p>Primer apellido: <strong><c:out value="${param.apellido1}" /></strong></p>
            <p>Segundo apellido: <strong><c:out value="${param.apellido2}" /></strong></p>
        </div>
    </div>
</div>
</body>
</html>