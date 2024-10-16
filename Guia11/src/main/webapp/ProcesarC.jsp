<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Datos JSTL</title>
</head>
<body>
<div class="container">
    <div class="row">
        &nbsp;
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading">Imprimiendo par&aacute;metros con JSTL</div>
        <div class="panel-body">
            <p>Nombre: <strong><c:out value="${param.nombre}" /></strong></p>
            <p>Primer apellido: <strong><c:out value="${param.apellido1}" /></strong></p>
            <p>Segundo apellido: <strong><c:out value="${param.apellido2}" /></strong></p>
        </div>
    </div>
</div>
</body>
</html>