<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ include file="conexion.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Generando sesion</h1>
<%
    HttpSession session_actual = request.getSession(true);
    String operacion = request.getParameter("operacion");
    out.println(operacion);
    if (operacion.equals("salir")) {
        session_actual.setAttribute("USER", null);
        session_actual.setAttribute("NAME", null);
        response.sendRedirect("login.html");
    } else if (operacion.equals("logueo")) {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        try {
            st = conexion.prepareStatement("select count(usuario),nombre_persona from persona where usuario= ? and contrasenia=SHA2(?,256) ");
            st.setString(1, usuario);
            st.setString(2, password);
            rs = st.executeQuery();
            rs.next();
            if (rs.getInt(1) == 1) { //solo una coincidencia es permitida
                session_actual.setAttribute("USER", usuario);
                session_actual.setAttribute("NAME", rs.getString(2));
                response.sendRedirect("principal.jsp");
            } else {
                response.sendRedirect("login.html");
            }
            rs.close();
            conexion.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    } else if (operacion.equals("insertar")) {
        String nombre=request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo=request.getParameter("sexo");
        String fecha=request.getParameter("fecha");
        int idocupacion = Integer.parseInt(request.getParameter("ocupacion"));
        String usuario=request.getParameter("usuario");
        String password=request.getParameter("password");
        st = conexion.prepareStatement("INSERT INTO persona(nombre_persona, edad_persona, sexo_persona, id_ocupacion, fecha_nac, usuario, contrasenia) VALUES (?,? , ?, ? ,?, ?, SHA2(?,256))" );
        st.setString(1,nombre);
        st.setInt(2, edad);
        st.setString(3, sexo);
        st.setInt(4,idocupacion);
        st.setString(5, fecha);
        st.setString(6, usuario);
        st.setString(7, password);
        st.executeUpdate();
        response.sendRedirect("principal.jsp?exito=si");
    }else if (operacion.equals("modificar")) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre=request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo=request.getParameter("sexo");
        String fecha=request.getParameter("fecha");
        int idocupacion = Integer.parseInt(request.getParameter("ocupacion"));
        String usuario=request.getParameter("usuario");
        String password=request.getParameter("password");
        st = conexion.prepareStatement("UPDATE persona SET nombre_persona=?,edad_persona=?,sexo_persona=?,id_ocupacion=?,fecha_nac=?,usuario =? WHERE id_persona=?");
        st.setString(1,nombre);
        st.setInt(2, edad);
        st.setString(3, sexo);
        st.setInt(4,idocupacion);
        st.setString(5, fecha);
        st.setString(6, usuario);
        st.setInt(7, id);
        st.executeUpdate();
        response.sendRedirect("principal.jsp?exito=si");
    }else if (operacion.equals("eliminar")) {
        int id = Integer.parseInt(request.getParameter("id"));
        st = conexion.prepareStatement("DELETE FROM persona WHERE id_persona=?");
        st.setInt(1, id);
        st.executeUpdate();
        response.sendRedirect("principal.jsp?exito=si");
    }
%>
</body>
</html>
