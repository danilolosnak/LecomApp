/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibernateUtil.HibernateSessionFactory;
import Modelos.ClienteServico;
import Modelos.Usuario;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author DaniloPC
 */
@WebServlet(name = "RemoveUser", urlPatterns = {"/RemoveUser"})
public class RemoveUser extends HttpServlet {

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
        
        String action = request.getParameter("action");
        
        SessionFactory sf = HibernateSessionFactory.getSessionFactory();
        Session session = sf.openSession();
        
        if (action != null && "remove".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            
            session.beginTransaction();            
            Usuario u = (Usuario) session.get(Usuario.class, id);          
            session.delete(u);             
            session.getTransaction().commit();
            
            List<Usuario> users = session.createCriteria(Usuario.class).list(); 
            request.getSession().setAttribute("usersList", users); 
           
            List<ClienteServico> cs = session.createCriteria(ClienteServico.class).list();            
            
            
            if (cs.size() > 0){
                for (ClienteServico c:cs) {
                    if ((c.getUsuarioId().equals(u.getId())) ){
                        cs.remove(c);
                    }
                }
            }    
          
            request.getSession().setAttribute("clienteServicoList", cs);
            session.close();

        }
        
        
        RequestDispatcher disp = request.getRequestDispatcher("ListUser.jsp");

	disp.forward(request, response);
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
