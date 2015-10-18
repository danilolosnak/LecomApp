<%-- 
    Document   : ListClienteServico
    Created on : 18/10/2015, 06:52:36
    Author     : DaniloPC
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Modelos.Servicoo"%>
<%@page import="Modelos.Usuario"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="HibernateUtil.HibernateSessionFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.ClienteServico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Clientes e Serviços</title>
    </head>
    <body>
        <h1 align="center">Listar Cliente e Serviços</h1>
        <%  
            
            SessionFactory sf2 = HibernateSessionFactory.getSessionFactory();
         
            Session session2 = sf2.openSession();
                                         
            %>
            
            <form action="ListClienteServico.jsp" method="post">
                <table align="center" border="1">
                    <tr>
                            <td>Nome do Cliente</td>
                            <td>Serviço</td>
                            <td>Dias restantes</td>
                    </tr>
                <%    
                    
                    List <ClienteServico> cs = (ArrayList<ClienteServico>)request.getSession().getAttribute("clienteServicoList");
                    if (cs != null) {
                        for (ClienteServico t : cs)  { 
                            Usuario user = new Usuario(); 
                            Servicoo sv = new Servicoo();
                            user = (Usuario)session2.load(Usuario.class, t.getUsuarioId());
                            sv = (Servicoo)session2.load(Servicoo.class, t.getServicoId());
                            System.out.println(sv.getId());
                            Date d1 = t.getDi();
                            Date d2 = t.getDf();
                            long diff = d2.getTime() - d1.getTime();
                            long diffDays = diff / (24 * 60 * 60 * 1000);

                 %>                            

                 <tr>
                     <td><%=user.getNome()%></td>
                     <td><%=sv.getNome()%> </td>
                     <td><%=diffDays%></td>
                 </tr>
                             
                <% } } 
                 %> 
                </table>
            </form>  
                
        <p align="center"><a href="<%=request.getContextPath()%>/index.html" >Voltar</a></p>
    </body>
</html>
