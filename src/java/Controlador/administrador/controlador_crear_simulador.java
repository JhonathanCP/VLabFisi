/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.administrador;

import com.mycompany.dao.AdministratorDao;
import com.mycompany.dao.CourseDao;
import com.mycompany.dao.Dao;
import com.mycompany.dao.SimulatorDao;
import com.mycompany.dao.StudentDao;
import com.mycompany.dao.UsuarioDao;
import com.mycompany.models.Administrator;
import com.mycompany.models.Course;
import com.mycompany.models.Simulator;
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
 * @author centt
 */
@WebServlet(name = "controlador_crear_simulador", urlPatterns = {"/controlador_crear_simulador"})
public class controlador_crear_simulador extends HttpServlet{
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
            out.println("<title>Servlet controlador_crear_simulador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlador_crear_simulador at " + request.getContextPath() + "</h1>");
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
        rd = request.getRequestDispatcher("/vista/administrador/crear_simulador.jsp");
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
        //RequestDispatcher rd;
        //String name = request.getParameter("nombre");
//        Boolean active = (Boolean.parseBoolean(request.getParameter("active")));
//        String html = request.getParameter("html");
//        String description = request.getParameter("description");
//        Integer courseId = (Integer.parseInt(request.getParameter("course")));
        //SimulatorDao simulatorDao = new SimulatorDao();        
        //Simulator simulator = new Simulator();     
        //simulator.setActive(active);
        //simulator.setCourseName(name);
        //simulator.setDescription(description);
        //simulator.setHtml(html);
       // simulator.setIdCourse(courseId);
        //simulatorDao.save(simulator);
        RequestDispatcher rd;
        String nombre = request.getParameter("nombre");
        Dao simulatorDao = new SimulatorDao();
        Simulator simulator = new Simulator();
        simulator.setName(nombre);
        simulatorDao.save(simulator);
        //Dao coursesDao = new CourseDao();
        //List<Course> lista = coursesDao.getAll();
        //request.setAttribute("lista_cursos", lista);
        //rd = request.getRequestDispatcher("/vista/administrador/lista_cursos.jsp");
        //rd.forward(request, response);
        List<Simulator> lista = simulatorDao.getAll();
        request.setAttribute("lista_simuladores", lista);
        rd = request.getRequestDispatcher("/vista/administrador/lista_simuladores.jsp");
        rd.forward(request, response);

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
