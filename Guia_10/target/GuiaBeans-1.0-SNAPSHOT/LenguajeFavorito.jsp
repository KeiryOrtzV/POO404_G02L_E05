
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <div class="row">
    &nbsp;
  </div>
  <div class="panel panel-primary">
    <div class="panel-heading">Uso de JavaBean</div>
    <div class="panel-body">
      <h1>P&aacute;gina de prueba del uso de beans</h1>
      <p>Se env&iacute;a el formulario al servicio cuyo fichero es
        <mark>beans.jsp</mark></p>
    </div>
  </div>
  <div class="row col-md-12" >
    <form role="form" action="Beans.jsp" method="POST">
      <div class="col-md-10">
        <div class="form-group">
          <label for="nombre">Por favor, introduce tu nombre:</label>
          <div class="input-group">
            <input type="text" class="form-control" name="nombre" id="nombre"
                   placeholder="Ingresa tu nombre">
            <span class="input-group-addon"></span>
          </div>
        </div>
        <div class="form-group">
          <%--@declare id="lenguaje"--%><label for="lenguaje">¿Cuál es tu lenguaje de programación favorito? </label>
          <div class="input-group">
            <select name="lenguaje" class="form-control">
              <option value="Java">Java
              <option value="C++">C++
              <option value="Perl">Perl
            </select>
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
