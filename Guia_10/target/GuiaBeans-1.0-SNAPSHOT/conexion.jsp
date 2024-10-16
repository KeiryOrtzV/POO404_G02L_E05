
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Connection conexion =null;
    //private Statement s =null;
    ResultSet rs=null;
    PreparedStatement st =null;
    Class.forName("com.mysql.jdbc.Driver");
// Se obtiene una conexión con la base de datos.
    conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/personabdd","root", "");
    String valor;
%>
