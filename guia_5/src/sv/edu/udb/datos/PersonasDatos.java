package sv.edu.udb.datos;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import sv.edu.udb.util.Conexion;
import sv.edu.udb.beans.PersonaBeans;
public class PersonasDatos {
    //Se utiliza un prepareStatement, por lo que podemos
//utilizar parametros (signos de ?)
//los cuales posteriormente será sustituidos por el parametro respectivo
    private final String SQL_INSERT
            = "INSERT INTO persona(id_persona,nombre_persona,edad_persona,telefono_persona,sexo_persona,id_ocupacion,fecha_nac)VALUES(?,?,?,?,?,?,?)";
    private final String SQL_UPDATE
            = "UPDATE persona SET nombre_persona=?, edad_persona=?,telefono_persona=?, sexo_persona=?, id_ocupacion=?, fecha_nac=? WHEREid_persona=?";
    private final String SQL_DELETE
            = "DELETE FROM persona WHERE id_persona = ?";
    private final String SQL_SELECT
            = "SELECT p.id_persona,p.nombre_persona , p.edad_persona,p.telefono_persona ," +
            "p.sexo_persona, o.ocupacion, p.fecha_nac " +
            "FROM persona p INNER JOIN ocupaciones o ON p.id_ocupacion =o.id_ocupacion ";
    public int insert(PersonaBeans personaBeans) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;//no se utiliza en este ejercicio
        int rows = 0; //registros afectados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;//contador de columnas
            stmt.setInt(index++, personaBeans.getIdPersona());
            stmt.setString(index++, personaBeans.getNombrePersona());
            stmt.setInt(index++, personaBeans.getEdadPersona());
            stmt.setString(index++, personaBeans.getTelefonoPersona());
            stmt.setString(index++, personaBeans.getSexoPersona());
            stmt.setInt(index++, personaBeans.getIdOcupacion());
            stmt.setString(index, personaBeans.getFechaNacimiento());
            System.out.println("Ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();//no. registros afectados
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    public int update(PersonaBeans personaBeans) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, personaBeans.getNombrePersona());
            stmt.setInt(index++, personaBeans.getEdadPersona());
            stmt.setString(index++, personaBeans.getTelefonoPersona());
            stmt.setString(index++, personaBeans.getSexoPersona());
            stmt.setInt(index++, personaBeans.getIdOcupacion());
            stmt.setString(index++, personaBeans.getFechaNacimiento());
            stmt.setInt(index, personaBeans.getIdPersona());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    public int delete(int idPersona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, idPersona);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    /**
     * Metodo que regresa el contenido de la tabla de persona
     */
    public DefaultTableModel selectPersona(){
        DefaultTableModel dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
//Formando encabezado
            for (int i = 1; i <= numberOfColumns; i++) {
                dtm.addColumn(meta.getColumnLabel(i));
            }
//Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return dtm;
    }
}
