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
    <div class="col-sm-4 col-sm-offset-4">
      <div class="row">
        <h3>Datos personales</h3>
      </div>
      <form role="form" name="persona" action="ProcesarC.jsp" method="POST">
        <div class="form-group">
          <label for="nombre">Ingrese su nombre:</label>
          <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre">
        </div>
        <div class="form-group">
          <label for="apellido1">Ingrese su primer apellido:</label>
          <input type="text" class="form-control" id="apellido1" name="apellido1" placeholder="Primer
apellido">
        </div>
        <div class="form-group">
          <label for="apellido2">Ingrese su segundo apellido:</label>
          <input type="text" class="form-control" id="apellido2" name="apellido2" placeholder="Segundo
apellido">
        </div>
        <input type="submit" class="btn btn-info" value="Enviar">
        c:out value="1+2+3"
        c:out value="${1+2+3}"
      </form>
    </div>
  </div>
</div>
</body>
</html>