    <html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Etiquetas JSTL</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <div class="row">
                <h3>Pagina de prueba del uso de choose, when y otherwise</h3>
            </div>
            <form role="form" name="lenguaje" action="ProcesarC2.jsp" method="POST">
                <div class="form-group">
                    <label for="lenguaje">¿Cuál es tu lenguaje de programación favorito?</label>
                    <select name="lenguaje" id="lenguaje" class="form-control">
                        <option value="">--Seleccionar un Lenguaje
                        <option value="Java">Java
                        <option value="C++">C++
                        <option value="Perl">Perl
                    </select>
                </div>
                <input type="submit" class="btn btn-info" value="Enviar">
            </form>
        </div>
    </div>
</div>
</body>
</html>