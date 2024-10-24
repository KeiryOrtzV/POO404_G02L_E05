<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 1/11/2023
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link href="css/tabla1.css" rel="stylesheet" type="text/css" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title><fmt:message key="label.paginaver"/></title>
</head>
<body>
<div class="container ">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4 ">
            <form action="Controlador?operacion=ver" method="post">
                <div class="form-group">
                    <label for="nombre"><fmt:message key="introducirnombre" /></label>
                    <input class="form-control" type="text" name="nombre" id="nombre">
                </div>
                <input class="btn btn-success" type="submit">
            </form>
        </div>
    </div>
</div>
</body>
</html>

