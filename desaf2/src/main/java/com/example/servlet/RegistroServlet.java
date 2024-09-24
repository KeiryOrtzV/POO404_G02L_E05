package com.example.servlet;

import com.example.dao.UsuarioDAO;
import com.example.model.Usuario;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String nombreUsuario = request.getParameter("nombreUsuario");
        String contraseña = request.getParameter("contraseña");
        String rol = request.getParameter("rol");

        System.out.println("Parámetros recibidos:");
        System.out.println("nombreUsuario: " + (nombreUsuario != null ? nombreUsuario : "null"));
        System.out.println("contraseña: " + (contraseña != null ? "******" : "null"));
        System.out.println("rol: " + (rol != null ? rol : "null"));

        if (nombreUsuario == null || nombreUsuario.trim().isEmpty() ||
                contraseña == null || contraseña.trim().isEmpty() ||
                rol == null || rol.trim().isEmpty()) {
            System.out.println("Error: Datos de registro incompletos");
            request.setAttribute("error", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }

        try {
            if (usuarioDAO.registrarUsuario(nombreUsuario, contraseña, rol)) {
                System.out.println("Registro exitoso para: " + nombreUsuario);
                response.sendRedirect("login.jsp?registro=exitoso");
            } else {
                System.out.println("Registro fallido para: " + nombreUsuario);
                request.setAttribute("error", "No se pudo registrar el usuario. Posiblemente ya existe.");
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("Excepción durante el registro de " + nombreUsuario + ": " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "Error interno del servidor al registrar el usuario.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}