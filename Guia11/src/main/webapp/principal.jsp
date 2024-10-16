<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Principal</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">Lista personas</h1>
    <sql:query var="q1" dataSource="jdbc/mysql">
        SELECT * FROM persona p INNER JOIN ocupaciones o on p.id_ocupacion =
        o.id_ocupacion
    </sql:query>
    <a class="btn btn-info" href="controller.jsp?operacion=insertar">Insertar persona</a>
    <br>
    <br>
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Nombres</th>
            <th>Edad</th>
            <th>Sexo</th>
            <th>Ocupacion</th>
            <th>Telefono</th>
            <th>Fecha de nacimiento</th>
            <th>Eliminar</th>
            <th>Modificar</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="persona" items="${q1.rows}">
            <tr>
                <td>${persona.id_persona}</td>
                <td>${persona.nombre_persona}
                </td>
                <td>${persona.edad_persona}
                </td>
                <td>${persona.sexo_persona}
                </td>
                <td>${persona.ocupacion}
                </td>
                <td>${persona.telefono_persona}
                </td>
                <td>${persona.fecha_nac}
                </td>
                <td>
                    <button class="btn btn-danger"
                            onclick="alerta('${persona.id_persona}')">Eliminar</button>
                </td>
                <td>
                    <a class="btn bg-primary"
                       href="controllercontroller.jsp?operacion=modificar&id=${persona.id_persona}">Modificar</a>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${not empty param.mensaje}">
        <div class="alert alert-success">
            <strong>Correcto! </strong><c:out value="${param.mensaje}"/>
            <br>
        </div>
    </c:if>
    <script>
        function alerta(id)
        {
            var mensaje;
            var opcion = confirm("Esta seguro de eliminar este registro");
            if (opcion == true) {
                location.href ="controller.jsp?operacion=eliminar&id="+id;
            }
        }
    </script>
</div>
</body>
</html>