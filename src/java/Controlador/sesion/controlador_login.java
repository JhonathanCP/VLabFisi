/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.sesion;

import com.mycompany.dao.CourseDao;
import com.mycompany.dao.Dao;
import com.mycompany.dao.UsuarioDao;
import com.mycompany.models.Course;
import com.mycompany.models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author centti
 */
@WebServlet(name = "controlador_login", urlPatterns = {"/controlador_login"})
public class controlador_login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controlador_login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlador_login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/vista/sesion/login.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        UsuarioDao usuarioDao = new UsuarioDao();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Usuario user_logeado = usuarioDao.login(email, password);
        if (user_logeado.getTipo_cuenta() == null) {
            rd = request.getRequestDispatcher("/vista/sesion/login.jsp");
            rd.forward(request, response);
        } else {
            HttpSession session = request.getSession(true);
            request.getSession().setAttribute("usuario_registrado", user_logeado);
            if (user_logeado.getTipo_cuenta().equals("administrativo")) {
                List<Usuario> lista = usuarioDao.getAll();
                request.setAttribute("lista_usuarios", lista);
                rd = request.getRequestDispatcher("/vista/administrador/lista_usuarios.jsp");
                rd.forward(request, response);
            } else if (user_logeado.getTipo_cuenta().equals("alumno")) {
                CourseDao courseDao = new CourseDao();
                Usuario user = (Usuario)request.getSession().getAttribute("usuario_registrado");
                List<Course> lista_cursos = courseDao.getAll();
                request.setAttribute("lista_cursos", lista_cursos);
                rd = request.getRequestDispatcher("/vista/empleado/lista_cursos.jsp");
                rd.forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
