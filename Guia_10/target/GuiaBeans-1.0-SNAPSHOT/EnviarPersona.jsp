
<!DOCTYPE html>
<html>
<head>
  <title>Personas</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <div class="row">
    <h3>Personas</h3>
  </div>
  <div class="row">
    <form role="form" name="persona" action="Persona.jsp" method="POST">
      <div class="col-md-10">
        <div class="form-group">
          <label for="nombre">Ingrese su nombre:</label>
          <div class="input-group">
            <input type="text" class="form-control" name="nombre" id="nombre"
                   placeholder="Nombre">
            <span class="input-group-addon"></span>
          </div>
        </div>
        <div class="form-group">
          <label for="edad">Ingrese su edad:</label>
          <div class="input-group">
            <input type="text" class="form-control" id="edad" name="edad"
                   placeholder="Edad">
            <span class="input-group-addon"></span>
          </div>
        </div>
        <input type="submit" class="btn btn-info" value="Enviar">
      </div>
    </form>
  </div>
</div>
</body>
</html>
