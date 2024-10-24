package servlets;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import javabeans.MensajeBean;
import modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
@WebServlet(name = "Controlador", value = "/Controlador")
public class Controlador extends HttpServlet {
    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String op=request.getParameter("operacion");
            int result=0;
            if(op.equals("envio")){
                response.sendRedirect("envio.jsp");
            }else if(op.equals("grabar")){
                MensajeBean men= (MensajeBean) request.getAttribute("mensaje");
                Operaciones oper= new Operaciones();
                if (oper.grabaMensaje(men)){
                    request.setAttribute("result","ok");
                }
                RequestDispatcher rd=request.getRequestDispatcher("/inicio.jsp");
                rd.forward(request, response);
            }
            else if(op.equals("muestra")){
                response.sendRedirect("mostrar.jsp");
            }
            else if(op.equals("ver")){
                Operaciones oper=new Operaciones();
                ArrayList mensajes=oper.obtenerMensajes(request.getParameter("nombre"));
                request.setAttribute("mensajes", mensajes);
                RequestDispatcher rd=request.getRequestDispatcher("/ver.jsp");
                rd.forward(request, response);
            }
        }
        finally {
            out.close();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        processRequest(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        processRequest(request,response);
    }
}

