package sv.edu.udb.util;
/**
 *
 * @author Rafael Torres
 */
import java.sql.*;
public class Conexion {
    private Connection conexion = null;
    private Statement s = null;
    private ResultSet rs = null;

    // Constructor
    public Conexion() throws SQLException {
        try {
            // Obtener el driver para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Se obtiene una conexión con la base de datos sin contraseña
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/guia4", "root", "");
            // Permite ejecutar sentencias SQL sin parámetros
            s = conexion.createStatement();

            System.out.println("Conexión Exitosa");

        } catch (ClassNotFoundException e1) {
            // Error si no puede leer el driver de MySQL
            System.out.println("ERROR: No encuentro el driver de la BD: " + e1.getMessage());
        } catch (SQLException e2) {
            // Error SQL
            System.out.println("ERROR: Fallo en la conexión SQL: " + e2.getMessage());
        }
    }

    // Método que permite obtener los valores del ResultSet
    public ResultSet getRs() {
        return rs;
    }

    // Método que permite fijar la tabla resultado de la consulta SQL realizada
    public void setRs(String sql) {
        try {
            this.rs = s.executeQuery(sql);
        } catch (SQLException e2) {
            // Error SQL: login/passwd o sentencia SQL errónea
            System.out.println("ERROR: Fallo en SQL: " + e2.getMessage());
        }
    }

    // Método que recibe una consulta SQL que sea un update, insert o delete
    public void setQuery(String sql) throws SQLException {
        this.s.executeUpdate(sql);
    }

    // Método que cierra la conexión
    public void cerrarConexion() throws SQLException {
        conexion.close();
    }
}
