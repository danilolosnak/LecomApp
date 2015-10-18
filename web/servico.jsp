<%-- 
    Document   : servico
    Created on : 17/10/2015, 01:31:27
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
        <h1 align=center>Cadastrar Servico</h1>
        <table align="center">
                    <form action="Servico?action=add" method="post">
                            <tr>
                                <td>Nome do serviço: </td><td><input type="text" name="nome" required="true"/></td>           
                            </tr>
                            <tr>    
                                <td><input type="submit" value="Salvar" /></td>
                            </tr>
                    </form>

        </table>
        <p align="center"><a href="<%=request.getContextPath()%>/index.html" >Voltar</a></p>

    </body>
</html>
