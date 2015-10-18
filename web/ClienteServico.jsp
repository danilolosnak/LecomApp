<%-- 
    Document   : ClienteServico
    Created on : 17/10/2015, 16:38:30
    Author     : DaniloPC
--%>

<%@page import="Modelos.Servicoo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Cliente contrata serviço</h1>
            <%  
            List <Usuario> usersList = (ArrayList<Usuario>)request.getSession().getAttribute("usersList");
            List <Servicoo> servicoList = (ArrayList<Servicoo>)request.getSession().getAttribute("servicoList");
            if(usersList != null && servicoList!= null){
            %>
            
            <form action="CS" method="post">
                <table  align="center">
                    <tr>
                            <td>Cliente</td>
                            <td>Serviço</td>
                            <td>Data inicio</td>
                            <td>Data fim</td>
                    </tr>
                 
                 <tr>
                     <td> 
                    <select name="cliente">
                     <%    for (Usuario user : usersList)  {
                 %>   
                        <option value ="<%=user.getId()%>"><%=user.getNome()%></option>    
                    <% } %>     
                    </select> 
                     </td>
                     <td> 
                    <select name="servico">
                     <%    for (Servicoo service : servicoList)  {
                 %>   
                        <option value ="<%=service.getId()%>"><%=service.getNome()%></option>    
                        
                    <% } %>     
                    </select> 
                     </td>
                     <td><input type="date" name="di" required="true"></td>
                     <td><input type="date" name="df" required="true"></td>
                 </tr>                                       
                </table>
                    <br><br><p align="center"><input type="submit" value="Salvar" /></p>    
            </form>
          <% } %>    
          <p align="center"><a href="<%=request.getContextPath()%>/index.html" >Voltar</a></p>
    </body>
</html>
