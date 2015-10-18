<%-- 
    Document   : InsertUser
    Created on : 16/10/2015, 20:18:03
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
        <h1 align=center>Cadastrar Usuário</h1>
        <table align="center">
                    <form action="UsuarioServlet?action=add" method="post">
                            <tr>
                                <td>Nome do usuário: </td><td><input type="text" name="nome" required="true"/></td>           
                            </tr>
                            <tr>
                                <td>Telefone: </td><td><input type="number" name="telefone" required="true"/></td>           
                            </tr>
                            <tr>    
                                <td><input type="submit" value="Salvar" /></td>
                            </tr>
                    </form>

        </table>
        <p align="center"><a href="<%=request.getContextPath()%>/index.html" >Voltar</a></p>

    </body>

</html>
