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
    <div class="row">
        <h3>Uso de c:forEach</h3>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading">&nbsp;</div>
        <div class="panel-body">
            <c:forEach begin="1" end="24" step="2" var="hour" varStatus="status">
                <p><c:out value="${hour}"/>
                    <c:if test="${status.first}">
                        <strong>Estoy en uno</strong>
                    </c:if>
                    <c:if test="${status.count == 5}">
                        <strong>Estoy en la iteración numero 5</strong>
                    </c:if>
                </p>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>