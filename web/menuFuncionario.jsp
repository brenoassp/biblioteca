<%-- 
    Document   : menuFuncionario
    Created on : 24/05/2016, 15:40:42
    Author     : breno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Biblioteca</title>
    </head>
    <body>
        <h1>Biblioteca - Acesso Funcionário</h1>
        
        <form method="post" action="FrontController?action=RedirectAction&page=emprestimosFuncionario.jsp">
            <input type=submit value="Buscar Empréstimos do Aluno">
        </form>
        
        
        <br />
        
        <form method="post" action="FrontController?action=LogoutAction">
            <input type=submit value="Sair">
        </form>
        
    </body>
</html>
