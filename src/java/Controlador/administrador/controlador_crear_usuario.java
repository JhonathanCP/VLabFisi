/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.administrador;

import com.mycompany.dao.AdministratorDao;
import com.mycompany.dao.Dao;
import com.mycompany.dao.StudentDao;

import com.mycompany.dao.UsuarioDao;
import com.mycompany.models.Administrator;
import com.mycompany.models.Student;

import com.mycompany.models.User;
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

/**
 *
 * @author centti
 */
@WebServlet(name = "controlador_crear_usuario", urlPatterns = {"/controlador_crear_usuario"})
public class controlador_crear_usuario extends HttpServlet {

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
            out.println("<title>Servlet controlador_crear_usuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlador_crear_usuario at " + request.getContextPath() + "</h1>");
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
        rd = request.getRequestDispatcher("/vista/administrador/crear_usuario.jsp");
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
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        Integer dni = (Integer.parseInt(request.getParameter("dni")));
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String tipo_cuenta = request.getParameter("tipo_cuenta");

        if (password.equals(password2)) {
            if (tipo_cuenta.equals(User.tipos_cuenta[0])) //cuenta tipo administrativo
            {
                Dao admindao = new AdministratorDao();

                Administrator admin = new Administrator();
                admin.setFirstname(nombre);
                admin.setLastname(apellido);
                admin.setDni(dni);
                admin.setEmail(email);
                admin.setDireccion(direccion);
                admin.setPassword(password);

                admindao.save(admin);
            } else if (tipo_cuenta.equals(User.tipos_cuenta[1])) //cuenta tipo empleado
            {
                Dao studentDao = new StudentDao();
                Student student = new Student();
                student.setDireccion(direccion);
                student.setDni(dni);
                student.setFirstname(nombre);
                student.setLastname(apellido);
                student.setEmail(email);
                student.setPassword(password);

                studentDao.save(student);
            }
            Dao usuarioDao = new UsuarioDao();
            List<Usuario> lista = usuarioDao.getAll();
            request.setAttribute("lista_usuarios", lista);
            rd = request.getRequestDispatcher("/vista/administrador/lista_usuarios.jsp");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("/vista/administrador/crear_usuario.jsp");
            rd.forward(request, response);
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