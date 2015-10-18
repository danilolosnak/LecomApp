<%-- 
    Document   : EditUser
    Created on : 17/10/2015, 00:34:06
    Author     : DaniloPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align=center>Editar Usuário</h1>
        <table align="center">
                    <form action="EditUser?action=edit" method="post">
                            <tr>
                                <td>Nome do usuário: </td><td><input type="text" name="nome" value="<%=request.getParameter("nome")%>" required="true"/></td>           
                            </tr>
                            <tr>
                                <td>Telefone: </td><td><input type="number" name="telefone" value="<%=request.getParameter("telefone")%>" required="true"/></td>           
                            </tr>
                            <tr>    
                                <td><input type="submit" value="Salvar" /></td>
                            </tr>
                            <input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>
                    </form>

        </table>
        <p align="center"><a href="<%=request.getContextPath()%>/ListUser.jsp" >Voltar</a></p>

    </body>
</html>
