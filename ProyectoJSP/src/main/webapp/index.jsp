<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/estilo.css">
    <script src="js/bootstrap.min.js" ></script>
</head>
<body class="container" >
<div id="login">
    <h1 class="text-center text-white pt-5">Universidad Don Bosco</h1>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form id="login-form" class="form" action="controller.jsp" method="post">
                        <h3 class="text-center text-info">Login</h3>
                        <div class="form-group">
                            <label for="username" class="text-info">Usuario:</label><br>
                            <input type="text" name="usuario" id="username" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info">Password:</label><br>
                            <input type="password" name="password" id="password" class="formcontrol">
                        </div>
                        <div class="form-group">
                            <input type="submit" name="operacion" class="btn btn-info btn-md"
                                   value="logueo">
                            <input type="hidden" name="operacion" value="logueo">
                        </div>
                        <br>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>