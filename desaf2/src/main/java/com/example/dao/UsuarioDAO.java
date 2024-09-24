package com.example.dao;

import com.example.model.Usuario;
import com.example.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public Usuario autenticar(String nombreUsuario, String contraseña) {
        if (nombreUsuario == null || contraseña == null) {
            System.out.println("Error en UsuarioDAO: nombreUsuario o contraseña es null");
            return null;
        }

        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contraseña = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, contraseña);

            System.out.println("Ejecutando consulta SQL para autenticar: " + nombreUsuario);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario(
                            rs.getInt("id_usuario"),
                            rs.getString("nombre_usuario"),
                            rs.getString("contraseña"),
                            rs.getString("rol")
                    );
                    System.out.println("Usuario autenticado: " + usuario.getNombreUsuario());
                    return usuario;
                } else {
                    System.out.println("No se encontró el usuario en la base de datos: " + nombreUsuario);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la autenticación: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public boolean registrarUsuario(String nombreUsuario, String contraseña, String rol) {
        if (nombreUsuario == null || contraseña == null || rol == null) {
            System.out.println("Error: Uno o más parámetros son null");
            return false;
        }

        if (nombreUsuario.trim().isEmpty() || contraseña.trim().isEmpty() || rol.trim().isEmpty()) {
            System.out.println("Error: Uno o más parámetros están vacíos");
            return false;
        }

        String sql = "INSERT INTO usuarios (nombre_usuario, contraseña, rol) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, contraseña);
            pstmt.setString(3, rol);

            System.out.println("Intentando registrar usuario: " + nombreUsuario);
            System.out.println("Longitud de la contraseña: " + contraseña.length());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario registrado exitosamente: " + nombreUsuario);
                return true;
            } else {
                System.out.println("No se pudo registrar el usuario: " + nombreUsuario);
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}