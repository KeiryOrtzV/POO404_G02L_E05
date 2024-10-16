
<jsp:useBean id="lenguajeBean" scope="page" class="www.udb.edu.sv.beans.LenguajeBean"/>
<jsp:setProperty name="lenguajeBean" property="*"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Resultado de prueba del uso de beans</title>
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
    <div class="panel-heading">Resultado</div>
    <div class="panel-body">
      <p>Hola: <mark><jsp:getProperty name="lenguajeBean"
                                      property="nombre"/></mark>.</p>
      <p>Tu lenguaje favorito es: <mark><jsp:getProperty name="lenguajeBean"
                                                         property="lenguaje"/></mark></p>
      <p>Mis comentarios acerca del lenguaje son: </p>
      <p class="bg-info"><jsp:getProperty name="lenguajeBean" property="comentarios"/>
      </p>
    </div>
  </div>
</div>
</body>
</html>
