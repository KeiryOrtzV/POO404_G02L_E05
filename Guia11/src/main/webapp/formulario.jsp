<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Formulario</title>
    <link rel="stylesheet" href="css/bootstrap1.min.css">
</head>
<body>
<div class="container">
    <h1 class="text-center">${param.cabecera}</h1>
    <form action="controller.jsp" method="POST">
        <input type="hidden" name="id" value="${not empty param.id}">
        <input type="hidden" value="${param.operacion}" name="operacion" id="operacion">
        <div class="form-group">
            <label for="nombre">Ingrese el nombre de la persona:</label>
            <div class="input-group">
                <input type="text" class="form-control" value="${param.nombre}"
                       name="nombre" id="nombre"
                       placeholder="Ingresa el nombre" required/>
            </div>
        </div>
        <div class="form-group">
            <label for="edad">Ingrese la edad de la persona:</label>
            <div class="input-group">
                <input type="number" class="form-control" id="edad" value="${param.edad}"
                       name="edad"
                       placeholder="Ingresa la edad" required/>
            </div>
        </div>
        <div class="form-group">
            <label for="telefono">Ingrese el telefono de la persona:</label>
            <div class="input-group">
                <input type="tel" class="form-control" id="telefono" value="${param.telefono}"
                       name="telefono"
                       placeholder="Ingresa el telefono" required/>
            </div>
        </div>
        <div class="form-group">
            <label for="sexo">Ingrese el sexo de la persona:</label>
            <div class="input-group">
                <select name="sexo" id="sexo" class="form-control" required>
                    <option value="Masculino">Maculino</option>
                    <option value="Femenino">Femenino</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="ocupacion">Ingrese la ocupacion de la persona:</label>
            <div class="input-group">
                <select name="idocupacion" id="ocupacion" class="form-control" required>
                    <option value="1">Doctor</option>
                    <option value="2">Emprendedor</option>
                    <option value="3">Profesor</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="fecha">Ingrese la fecha de nacimiento de la persona:</label>
            <div class="input-group">
                <input type="date" class="form-control" id="fecha" value="${param.fecha}"
                       name="fecha"
                       placeholder="Ingresa la fecha" required/>
            </div>
        </div>
        <div style="margin-left: 30%;">
            <input type="submit" class="btn btn-success col-md-6 " value="Enviar"/>
        </div>
    </form>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Formulario</title>
    <link rel="stylesheet" href="css/bootstrap1.min.css">
</head>
<body>
<div class="container">
    <h1 class="text-center">${param.cabecera}</h1>
    <form action="controller.jsp" method="POST">
        <input type="hidden" name="id" value="${not empty param.id}">
        <input type="hidden" value="${param.operacion}" name="operacion" id="operacion">
        <div class="form-group">
            <label for="nombre">Ingrese el nombre de la persona:</label>
            <div class="input-group">
                <input type="text" class="form-control" value="${param.nombre}"
                       name="nombre" id="nombre"
                       placeholder="Ingresa el nombre" required/>
            </div>
        </div>
        <div class="form-group">
            <label for="edad">Ingrese la edad de la persona:</label>
            <div class="input-group">
                <input type="number" class="form-control" id="edad" value="${param.edad}"
                       name="edad"
                       placeholder="Ingresa la edad" required/>
            </div>
        </div>
        <div class="form-group">
            <label for="telefono">Ingrese el telefono de la persona:</label>
            <div class="input-group">
                <input type="tel" class="form-control" id="telefono" value="${param.telefono}"
                       name="telefono"
                       placeholder="Ingresa el telefono" required/>
            </div>
        </div>
        <div class="form-group">
            <label for="sexo">Ingrese el sexo de la persona:</label>
            <div class="input-group">
                <select name="sexo" id="sexo" class="form-control" required>
                    <option value="Masculino">Maculino</option>
                    <option value="Femenino">Femenino</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="ocupacion">Ingrese la ocupacion de la persona:</label>
            <div class="input-group">
                <select name="idocupacion" id="ocupacion" class="form-control" required>
                    <option value="1">Doctor</option>
                    <option value="2">Emprendedor</option>
                    <option value="3">Profesor</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="fecha">Ingrese la fecha de nacimiento de la persona:</label>
            <div class="input-group">
                <input type="date" class="form-control" id="fecha" value="${param.fecha}"
                       name="fecha"
                       placeholder="Ingresa la fecha" required/>
            </div>
        </div>
        <div style="margin-left: 30%;">
            <input type="submit" class="btn btn-success col-md-6 " value="Enviar"/>
        </div>
    </form>
</div>
</body>
</html>