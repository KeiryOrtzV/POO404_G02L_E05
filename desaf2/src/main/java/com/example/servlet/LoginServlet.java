package com.example.servlet;

import com.example.dao.UsuarioDAO;
import com.example.model.Usuario;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String nombreUsuario = request.getParameter("nombreUsuario");
        String contraseña = request.getParameter("contraseña");

        System.out.println("Intento de login para: " + nombreUsuario);
        System.out.println("Contraseña recibida: " + (contraseña != null ? "Sí" : "No"));

        if (nombreUsuario == null || nombreUsuario.trim().isEmpty() ||
                contraseña == null || contraseña.trim().isEmpty()) {
            System.out.println("Error: Datos de login incompletos");
            request.setAttribute("error", "Por favor, complete todos los campos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        Usuario usuario = usuarioDAO.autenticar(nombreUsuario, contraseña);
        if (usuario != null) {
            System.out.println("Login exitoso para: " + nombreUsuario);
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("menu");
        } else {
            System.out.println("Login fallido para: " + nombreUsuario);
            request.setAttribute("error", "Nombre de usuario o contraseña incorrectos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}