package sv.edu.udb.datos;

import javax.swing.DefaultComboBoxModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OcupacionesDatos {
    private Connection connection;

    public OcupacionesDatos() {
        try {
            // Configura la conexión a la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_datos", "usuario", "contraseña");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener el modelo de ocupaciones para el ComboBox
    public DefaultComboBoxModel selectOcupaciones() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String query = "SELECT nombre FROM ocupaciones";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                model.addElement(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    // Método para obtener el ID de una ocupación
    public int getIdOcupacion(String ocupacion) {
        int id = -1;
        String query = "SELECT id FROM ocupaciones WHERE nombre = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ocupacion);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
