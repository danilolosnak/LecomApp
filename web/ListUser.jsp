<%-- 
    Document   : ListUser
    Created on : 16/10/2015, 21:25:04
    Author     : DaniloPC
--%>

<%@page import="org.hibernate.Session"%>
<%@page import="HibernateUtil.HibernateSessionFactory"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelos.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuários</title>
    </head>
    <body>
        <h1 align="center">Listar Usuários</h1>
            <%
            SessionFactory sf3 = HibernateSessionFactory.getSessionFactory();
         
            Session session3 = sf3.openSession();    
            List<Usuario> usersList = session3.createCriteria(Usuario.class).list(); 
            if(usersList != null){
            %>
            
            <form action="Listar.jsp" method="post">
                <table align="center" border="1">
                    <tr>
                            <td>Nome</td>
                            <td>Telefone</td>
                            <td>Opção</td>
                    </tr>
                <%    for (Usuario user : usersList)  {
                 %> 
                     
                    <tr>
                        <td><%=user.getNome()%></td>
                        <td><%=user.getTelefone()%></td>
                        <td><a href="EditUser.jsp?id=<%=user.getId()%>&nome=<%=user.getNome()%>&telefone=<%=user.getTelefone()%>">Editar</a>
                            <a href="RemoveUser?action=remove&id=<%=user.getId()%>">Remover</a></td>
                    </tr>
                <% } %>    
                </table>
            </form>
          <% }  session3.close();%>    
          <p align="center"><a href="<%=request.getContextPath()%>/index.html" >Voltar</a></p>
    </body>
</html>
