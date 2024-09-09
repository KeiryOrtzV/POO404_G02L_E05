<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Suma de dos numeros</title>
</head>
<body>
<form name="sumaForm" action="sumaServlet" method="POST">
    <table>
        <tr>
            <td>Primer numero :</td>
            <td><input type="text" name="num_1"/></td>
        </tr>
        <tr>
            <td>Segundo numero :</td>
            <td><input type="text" name="num_2"/></td>
        </tr>
        <th><input type="submit" value="calcular" name="calculate"/></th>
        <th><input type="reset" value="reiniciar" name="reset"/></th>
    </table>
    <h2>${respuesta}</h2>
</form>
</body>
</html>