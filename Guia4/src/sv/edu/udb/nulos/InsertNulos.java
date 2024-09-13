package sv.edu.udb.nulos;

import java.sql.ResultSet;
import java.sql.SQLException;
import sv.edu.udb.util.Conexion;

public class InsertNulos {
    public static void main(String[] args) throws SQLException {
        // Conectar a la base de datos
        Conexion con = new Conexion();

        // Insertar valores nulos o vacíos en la tabla Empleados
        String sql1 = "insert into empleados values(7,'','Torres',null)";
        con.setQuery(sql1);

        // Corregir la consulta para que utilice el nombre correcto de la columna
        String sql = "select Nombre from empleados";
        ResultSet rs;

        con.setRs(sql);
        rs = con.getRs();

        // Verificar que el ResultSet no sea nulo antes de iterar
        if (rs != null) {
            String nombre;
            while (rs.next()) {
                nombre = rs.getString(1); // Obtener el nombre de la primera columna

                // Imprimir el estado del nombre
                if (nombre == null) {
                    System.out.println("Nombre 'Null': " + nombre);
                } else if (nombre.equals("")) {
                    System.out.println("Nombre Vacio: " + nombre);
                } else {
                    System.out.println("Nombre Con Datos: " + nombre);
                }
            }
        } else {
            System.out.println("No se obtuvo ningún resultado.");
        }

        // Cerrar la conexión
        con.cerrarConexion();
    }
}

