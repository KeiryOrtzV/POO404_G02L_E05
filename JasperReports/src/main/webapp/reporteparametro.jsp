<%--
 Created by IntelliJ IDEA.
 User: Rafael
 Date: 30/4/2022
 Time: 04:16
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reporte con parametros</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-
EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrapicons@1.8.1/font/bootstrap-icons.css">
</head>
<body>
<h1 class="text-center">Mi Primer Reporte con iReport</h1>
<h2>Generar Reporte Parametro</h2>
<form action="JaspertReportParameter" method="POST">
    <select name="ocupacion" class="form-control">
        <option value="Doctor">Doctor</option>
        <option value="Emprendedor">Emprendedor</option>
        <option value="Profesor">Profesor</option>
    </select>
    <input type="submit" value="Enviar" class="btn btn-success">
</form>
</body>
</html>