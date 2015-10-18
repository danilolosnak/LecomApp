/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import HibernateUtil.HibernateSessionFactory;
import Modelos.ClienteServico;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CS", urlPatterns = {"/CS"})
public class CS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
              
        Long cliente = Long.parseLong(request.getParameter("cliente"));
        Long servico = Long.parseLong(request.getParameter("servico"));                
        Date di = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("di"));         
        Date df = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("df"));
                
        SessionFactory sf = HibernateSessionFactory.getSessionFactory();         
        Session session = sf.openSession();         

        ClienteServico clienteServico = new ClienteServico ();
        clienteServico.setUsuarioId(cliente);
        clienteServico.setServicoId(servico);
        clienteServico.setDi(di);
        clienteServico.setDf(df);
        
        session.beginTransaction();
        session.merge(clienteServico);
        session.getTransaction().commit();
        List<ClienteServico> cs = session.createCriteria(ClienteServico.class).list();            
        request.getSession().setAttribute("clienteServicoList", cs);
        session.close();
        
        RequestDispatcher disp = request.getRequestDispatcher("index.html");		
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CS.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CS.class.getName()).log(Level.SEVERE, null, ex);
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
