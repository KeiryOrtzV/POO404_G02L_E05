<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ include file="conexion.jsp" %>
<%
    HttpSession session_actual = request.getSession(false);
    String usuario = (String) session_actual.getAttribute("USER");
    String nombres = (String) session_actual.getAttribute("NAME");
    if (usuario == null) {
        response.sendRedirect("login.html");
    }
%>
<html lang="es">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bienvenido <%=nombres%>
    </title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fontawesome/4.7.0/css/font-awesome.min.css">
    <script src="js/jquery-3.2.1.slim.min.js"></script>
    <script src="js/bootstrap1.min.js"></script>
</head>
<body>
<jsp:include page="menú.jsp"/>
<h1 class="text-center">Bienvenido a POO404</h1>
<h2 class="text-center">
    Bienvenido: (<%=usuario%>) <%=nombres%>
</h2>
<div class="container">
    <div style="padding: 0;">
        <form role="form" action="controller.jsp" method="POST">
            <div class="col-md-12" id="conten">
                <input type="hidden" name="id" id="idpersona">
                <input type="hidden" value="insertar" name="operacion" id="operacion">
                <div class="form-group">
                    <label for="nombre">Ingrese el nombre de la persona:</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="nombre" id="nombre"
                               placeholder="Ingresa el nombre" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edad">Ingrese la edad de la persona:</label>
                    <div class="input-group">
                        <input type="number" class="form-control" id="edad" name="edad"
                               placeholder="Ingresa la edad" required>
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
                        <select name="ocupacion" id="ocupacion" class="form-control" required>
                            <%
                                st = conexion.prepareStatement("SELECT * FROM ocupaciones");
                                rs = st.executeQuery();
                                while (rs.next()) {
                            %>
                            <option
                                    value="<%=rs.getString("id_ocupacion")%>"><%=rs.getString("ocupacion")%>
                            </option>
                            <%}%>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="fecha">Ingrese la fecha de nacimiento de la persona:</label>
                    <div class="input-group">
                        <input type="date" class="form-control" id="fecha" name="fecha"
                               placeholder="Ingresa la fecha" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="fecha">Ingrese el usuario de la persona:</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="usuario" name="usuario"
                               placeholder="Ingresa el usuario" required>
                    </div>
                </div>
                <div class="form-group" id="passhidden">
                    <label for="fecha">Ingrese el password de la persona:</label>
                    <div class="input-group">
                        <input type="password" class="form-control" id="password"
                               name="password"
                               placeholder="Ingresa el password" required>
                    </div>
                </div>
                <div style="margin-left: 30%;">
                    <input type="submit" class="btn btn-success col-md-6 " value="Guardar">
                </div>
            </div>
        </form>
        <%
            if(request.getParameter("exito") != null){
                out.println("<div class='alert alert-success' role='alert'>Operacion realizada con exito</div>");
            }
        %>
    </div>
    <!--notese el uso de jsp:include -->
    <jsp:include page="consulta.jsp"/>
</div>
</body>
</html>
