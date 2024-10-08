<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <div class="row">&nbsp;</div>
    <div class="panel panel-primary">
        <div class="panel-heading">Resultado</div>
        <div class="panel-body">
            <c:choose>
                <c:when test="${param.lenguaje == 'Java'}">
                    <p>El rey de los lenguaje orientados a objetos</p>
                </c:when>
                <c:when test="${param.lenguaje == 'C++'}">
                    <p>Ideal para aprender</p>
                </c:when>
                <c:when test="${param.lenguaje == 'Perl'}">
                    <p>Lenguaje de scripting muy potente</p>
                </c:when>
                <c:otherwise>
                    <p>No se seleccionó ninguno</p>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="row">
        <a class="btn btn-info" href="lenguaje.jsp">Regresar</a>
    </div>
</div>
</body>
</html>