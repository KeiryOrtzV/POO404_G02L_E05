<%@ include file="conexion.jsp" %>
<div class="">
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Nombres</th>
            <th>Edad</th>
            <th>Sexo</th>
            <th>Ocupacion</th>
            <th>Fecha de nacimiento</th>
            <th>Usuario</th>
            <th>Eliminar</th>
            <th>Modificar</th>
        </tr>
        </thead>
        <tbody>
        <%
            st = conexion.prepareStatement("SELECT p.id_persona,p.nombre_persona,p.edad_persona,p.sexo_persona,p.id_ocupacion,p.fecha_n ac, p.usuario, o.ocupacion FROM persona p INNER JOIN ocupaciones o on p.id_ocupacion= o.id_ocupacion");rs = st.executeQuery();
            while (rs.next()) {
        %>
        <tr>
            <td><%=rs.getString("id_persona")%>
            </td>
            <td><%=rs.getString("nombre_persona")%>
            </td>
            <td><%=rs.getString("edad_persona")%>
            </td>
            <td><%=rs.getString("sexo_persona")%>
            </td>
            <td><%=rs.getString("ocupacion")%>
            </td>
            <td><%=rs.getString("fecha_nac")%>
            </td>
            <td><%=rs.getString("usuario")%>
            </td>
            <td><button class="btn btn-danger"
                        onclick="alerta('<%=rs.getString("id_persona")%>')">Eliminar</button></td>
            <td><button class="btn btn-info"
                        onclick="modificar('<%=rs.getString("id_persona")%>','<%=rs.getString("nombre_persona")%>','<%=rs.getString("edad_persona")%>','<%=rs.getString("sexo_persona")%>','<%=
rs.getString("id_ocupacion")%>','<%=rs.getString("fecha_nac")%>','<%=rs.getString("usuario")%>')" >Modificar</button></td>
        </tr>
        <%
            }
            conexion.close();
        %>
        </tbody>
    </table>
</div>
<script>
    function alerta(id)
    {
        var mensaje;
        var opcion = confirm("Esta seguro de eliminar este registro");
        if (opcion == true) {
            location.href ="controller.jsp?operacion=eliminar&id="+id;
        }
    }
    function modificar(id, nombre,edad,sexo,ocupacion,fecha,usuario)
    {
        document.getElementById("idpersona").value=id;
        document.getElementById("nombre").value=nombre;
        document.getElementById("edad").value=edad;
        document.getElementById("sexo").value=sexo;
        document.getElementById("ocupacion").value=ocupacion;
        document.getElementById("fecha").value=fecha;
        document.getElementById("usuario").value=usuario;
        document.getElementById("operacion").value="modificar";
        hijo = document.getElementById("passhidden");
        padre = hijo.parentNode;
        padre.removeChild(hijo); }
</script>