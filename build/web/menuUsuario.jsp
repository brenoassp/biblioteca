<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Biblioteca</title>
    </head>
    <body>
        <h1>Biblioteca</h1>
        
        <form method="post" action="FrontController?action=RedirectAction&page=acervo.jsp">
            <input type=submit value="Buscar o Acervo">
        </form>
        
        <br />
        
        <form method="post" action="FrontController?action=RedirectAction&page=reservas.jsp">
            <input type=submit value="Consultar Reservas">
        </form>
        
        <br />
        
        <form method="post" action="FrontController?action=RedirectAction&page=emprestimos.jsp">
            <input type=submit value="Renovar Empréstimo">
        </form>
        
        <br />
        
        <form method="post" action="FrontController?action=LogoutAction">
            <input type=submit value="Sair">
        </form>
        
    </body>
</html>
