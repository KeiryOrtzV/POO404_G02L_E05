<%@ page import="www.udb.edu.sv.beans.PersonaBean" %>
<jsp:useBean id="personalist" class="www.udb.edu.sv.beans.PersonaBean"
             scope="request"/>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main
    </title>
    <link rel="stylesheet" href="css/bootstrap1.min.css">
    <link rel="stylesheet" href="css/estilo.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fontawesome/4.7.0/css/font-awesome.min.css">
    <script src="js/bootstrap.min.js"></script>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
    <div class="container">
        <a class="navbar-brand" href="#">Guia Bean</a>
        <button class="navbar-toggler border-0" type="button" data-toggle="collapse" datatarget="#exCollapsingNavbar">
            &#9776;
        </button>
    </div>
</nav>
<body>
<br>
<br>
<br>
<div class="container">
    <h1 class="text-center">Gestion personas</h1>
    <div style="padding: 0;" >
        <form role="form" action="controller.jsp" method="POST">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="nombre">Ingrese el nombre de la persona:</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="nombrePersona"
                               id="nombre"
                               placeholder="Ingresa el nombre" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edad">Ingrese la edad de la persona:</label>
                    <div class="input-group">
                        <input type="number" class="form-control" id="edad"
                               name="edadPersona"
                               placeholder="Ingresa la edad" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edad">Ingrese el telefono de la persona:</label>
                    <div class="input-group">
                        <input type="tel" class="form-control" id="telefono"
                               name="telefonoPersona"
                               placeholder="Ingresa el telefono" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="sexo">Ingrese el sexo de la persona:</label>
                    <div class="input-group">
                        <select name="sexoPersona" id="sexo" class="form-control" required>
                            <option value="Masculino">Maculino</option>
                            <option value="Femenino">Femenino</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="ocupacion">Ingrese la ocupacion de la persona:</label>
                    <div class="input-group">
                        <select name="idOcupacion" id="ocupacion" class="form-control"
                                required>
                            <option value="1">Doctor</option>
                            <option value="2">Emprendedor</option>
                            <option value="3">profesor</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="fecha">Ingrese la fecha de nacimiento de la persona:</label>
                    <div class="input-group">
                        <input type="date" class="form-control" id="fecha" name="fechaNac"
                               placeholder="Ingresa la fecha" required>
                    </div>
                </div>
                <div style="margin-left: 30%;">
                    <input type="submit" class="btn btn-success col-md-6 ">
                </div>
            </div>
        </form>
    </div>
    <br>
    <div>
        <div class="">
            <table class="table table-striped table-hover table-dark">
                <thead class="table-dark table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Telefono</th>
                    <th>Sexo</th>
                    <th>Ocupacion</th>
                    <th>Fecha nacimiento</th>
                </tr>
                </thead>
                <tbody>
                <% for (PersonaBean persona: personalist.getListaPersonas() ) {%>
                <tr>
                    <td><%= persona.getIdPersona() %></td>
                    <td><%= persona.getNombrePersona() %></td>
                    <td><%= persona.getEdadPersona() %></td>
                    <td><%= persona.getTelefonoPersona() %></td>
                    <td><%= persona.getSexoPersona() %></td>
                    <td><%= persona.getOcupacion().getOcupacion() %></td>
                    <td><%= persona.getFechaNac() %></td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<footer id="sticky-footer" class="flex-shrink-0 py-4 bg-dark text-white-50">
    <div class="container text-center ">
        <small style="color: white;">Copyright &copy; BEAN</small>
    </div>
</footer>
<script>
</script>
</html>