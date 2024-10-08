<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Controlador</title>
</head>
<body>
<c:if test="${param.operacion == 'eliminar'}">
    <sql:update var="insertar" dataSource="jdbc/mysql">
        DELETE FROM persona WHERE id_persona = ?
        <sql:param value="${param.id}"/>
    </sql:update>
    <c:redirect url="principal.jsp">
        <c:param name="mensaje" value="Persona eliminada con exito"/>
    </c:redirect>
</c:if>
<c:if test="${param.operacion == 'insertar'}">
    <c:redirect url="formulario.jsp">
        <c:param name="cabecera" value="Insertar persona"/>
        <c:param name="operacion" value="insertarinf"/>
    </c:redirect>
</c:if>
<c:if test="${param.operacion == 'insertarinf'}">
    <sql:update var="insertar" dataSource="jdbc/mysql">
        INSERT INTO persona(nombre_persona, edad_persona, telefono_persona, sexo_persona,
        id_ocupacion, fecha_nac) VALUES (?, ? , ?, ? ,?, ?)
        <sql:param value="${param.nombre}"/>
        <sql:param value="${param.edad}"/>
        <sql:param value="${param.telefono}"/>
        <sql:param value="${param.sexo}"/>
        <sql:param value="${param.idocupacion}"/>
        <sql:param value="${param.fecha}"/>
    </sql:update>
    <c:redirect url="principal.jsp">
        <c:param name="mensaje" value="Persona ingresada con exito"/>
    </c:redirect>
</c:if>
</body>
</html>