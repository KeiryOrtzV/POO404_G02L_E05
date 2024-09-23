package com.tempertrapp.dao;

import com.tempertrapp.model.Cliente;
import com.tempertrapp.model.Empleado;
import com.tempertrapp.model.Usuario;
import com.tempertrapp.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public Usuario authenticateUser(String email, String password) {
        Usuario usuario = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM usuarios WHERE email = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, password); // Aquí deberías usar hashing para comparar contraseñas
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String rol = resultSet.getString("rol");

                    if ("cliente".equals(rol)) {
                        usuario = new Cliente(resultSet.getInt("id_cliente"), resultSet.getString("nombre"), email, password, resultSet.getString("telefono"), resultSet.getString("direccion"));
                    } else if ("empleado".equals(rol)) {
                        usuario = new Empleado(resultSet.getInt("id_cliente"), resultSet.getString("nombre"), email, password, rol);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja la excepción adecuadamente
        }

        return usuario; // Devuelve null si no se encuentra el usuario
    }
}
