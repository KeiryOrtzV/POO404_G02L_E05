package com.tempertrapp.servlet;

import com.tempertrapp.dao.UsuarioDAO;
import com.tempertrapp.model.Usuario;

import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Lógica para autenticar al usuario
        Usuario usuario = usuarioDAO.authenticateUser(email, password);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("menuCliente.jsp");
        } else {
            request.setAttribute("error", "Credenciales inválidas. Intenta nuevamente.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
