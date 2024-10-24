<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 1/11/2023
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link href="css/tabla1.css" rel="stylesheet" type="text/css" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title><fmt:message key="paginaver"/></title>
</head>
<body>
<div class="container ">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4 ">
            <h1><fmt:message key="mensajepara"/> <c:out value="${param.nombre}"/> </h1>
            <table class="table table-hover table-bordered">
                <tr>
                    <th><fmt:message key="remitente"/></th>
                    <th><fmt:message key="mensaje"/></th>
                </tr>
                <c:forEach var="m" items="${mensajes}">
                    <tr>
                        <td><c:out value="${m.getRemite()}"/></td>
                        <td><c:out value="${m.getTexto()}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <c:if test="${empty mensajes}">
                <fmt:message key="nohaymensaje"/>
            </c:if>
            <br/>
            <a href="inicio.jsp" class="btn btn-info"><fmt:message key="inicio" /></a>
        </div>
    </div>
</div>
</body>
</html>
