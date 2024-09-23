package com.tempertrapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/conexion_base_datos_temper_trap?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // Cambia esto si es necesario
    private static final String PASSWORD = ""; // Cambia esto si es necesario

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Cargar el controlador de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return connection; // Devuelve la conexión o null si hubo un error
    }
}
