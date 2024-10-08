<%@ include file="conexion.jsp" %>
<jsp:useBean id="persona" class="www.udb.edu.sv.beans.PersonaBean" scope="request"/>
<jsp:useBean id="ocupacion" class="www.udb.edu.sv.beans.OcupacionBean" scope="request"/>
<%@ page import="www.udb.edu.sv.beans.OcupacionBean" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<jsp:setProperty name="persona" property="*"/>
<jsp:setProperty name="ocupacion" property="idOcupacion" value="<%=persona.getIdOcupacion() %>"/>
<jsp:setProperty name="ocupacion" property="ocupacion" value="<%=persona.getNombreOcupacion() %>"/>

<%
    String mensaje = "";
    try {
        // Validar y truncar datos si es necesario
        String nombrePersona = persona.getNombrePersona();
        if (nombrePersona.length() > 100) nombrePersona = nombrePersona.substring(0, 100);

        String telefonoPersona = persona.getTelefonoPersona();
        if (telefonoPersona.length() > 9) telefonoPersona = telefonoPersona.substring(0, 9);

        String sexoPersona = persona.getSexoPersona();
        if (sexoPersona.length() > 50) sexoPersona = sexoPersona.substring(0, 50);

        // Convertir la fecha a formato SQL
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse(persona.getFechaNac());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        st = conexion.prepareStatement("INSERT INTO persona(nombre_persona, edad_persona, telefono_persona, sexo_persona, id_ocupacion, fecha_nac) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        st.setString(1, nombrePersona);
        st.setInt(2, persona.getEdadPersona());
        st.setString(3, telefonoPersona);
        st.setString(4, sexoPersona);
        st.setInt(5, ocupacion.getIdOcupacion());
        st.setDate(6, sqlDate);

        int filasAfectadas = st.executeUpdate();

        if (filasAfectadas > 0) {
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idPersona = generatedKeys.getInt(1);
                mensaje = "Inserción exitosa. ID de la persona: " + idPersona;
            } else {
                mensaje = "Inserción exitosa, pero no se pudo obtener el ID generado.";
            }
        } else {
            mensaje = "No se pudo insertar el registro";
        }

    } catch(SQLException e) {
        mensaje = "Error SQL: " + e.getMessage();
        e.printStackTrace();
    } catch(Exception e) {
        mensaje = "Error: " + e.getMessage();
        e.printStackTrace();
    } finally {
        // Cerrar recursos
        if (st != null) try { st.close(); } catch(SQLException e) { }
        if (conexion != null) try { conexion.close(); } catch(SQLException e) { }
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main</title>
    <link rel="stylesheet" href="css/bootstrap1.min.css">
    <link rel="stylesheet" href="css/estilo.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="js/jquery-3.2.1.slim.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
    <div class="container">
        <a class="navbar-brand" href="#">Guia Bean</a>
        <button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
            &#9776;
        </button>
    </div>
</nav>
<br><br><br>
<div class="container">
    <% if (!mensaje.isEmpty()) { %>
    <div class="alert <%= mensaje.startsWith("Error") ? "alert-danger" : "alert-success" %>" role="alert">
        <%= mensaje %>
    </div>
    <% } %>
    <ul class="list-group">
        <li class="list-group-item active" aria-current="true">Datos cargados al bean</li>
        <li class="list-group-item"><strong><jsp:getProperty name="persona" property="nombrePersona"/></strong></li>
        <li class="list-group-item"><strong><jsp:getProperty name="persona" property="edadPersona"/></strong></li>
        <li class="list-group-item"><strong><jsp:getProperty name="persona" property="telefonoPersona"/></strong></li>
        <li class="list-group-item"><strong><jsp:getProperty name="persona" property="sexoPersona"/></strong></li>
        <li class="list-group-item"><strong><jsp:getProperty name="persona" property="fechaNac"/></strong></li>
        <li class="list-group-item"><strong><jsp:getProperty name="ocupacion" property="ocupacion"/></strong></li>
    </ul>
</div>
</body>
<footer id="sticky-footer" class="flex-shrink-0 py-4 bg-dark text-white-50" style="position: absolute; bottom: 0; width: 100%;">
    <div class="container text-center">
        <small style="color: white;">Copyright &copy; BEAN</small>
    </div>
</footer>
</html>