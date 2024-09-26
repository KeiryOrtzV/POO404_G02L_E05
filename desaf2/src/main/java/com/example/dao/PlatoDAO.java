package com.example.dao;

import com.example.model.Plato;
import com.example.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlatoDAO {

    // Método para obtener todos los platos
    public List<Plato> getAllPlatos() {
        List<Plato> platos = new ArrayList<>();
        String sql = "SELECT * FROM menu";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                platos.add(new Plato(
                        rs.getInt("id_plato"),
                        rs.getString("nombre_plato"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getBoolean("disponibilidad")
                ));
            }
            System.out.println("Platos recuperados: " + platos.size());
        } catch (SQLException e) {
            System.err.println("Error al recuperar platos: " + e.getMessage());
            e.printStackTrace();
        }
        return platos;
    }

    // Método para obtener un plato por su ID
    public Plato getPlatoById(int id) {
        Plato plato = null;
        String sql = "SELECT * FROM menu WHERE id_plato = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);  // Asignamos el ID del plato a la consulta

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    plato = new Plato(
                            rs.getInt("id_plato"),
                            rs.getString("nombre_plato"),
                            rs.getString("descripcion"),
                            rs.getDouble("precio"),
                            rs.getBoolean("disponibilidad")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el plato por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return plato;
    }
}
