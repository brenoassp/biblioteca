<%@page import="dao.PessoaDAO"%>
<%@page import="model.Pessoa"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="model.Usuario"%>
<%@page import="model.Usuario"%>
<%@page import="dao.AlunoDAO"%>
<%@page import="model.Aluno"%>
<%@page import="model.AlunoGraduacao"%>
<%@page import="java.util.List"%>
<%@page import="dao.AlunoGraduacaoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Biblioteca</title>
    </head>
    <body>
        <h1>Biblioteca</h1>
     
        <form method="post" action="FrontController?action=BuscaAcervoAction">
            <input type=submit value="Buscar o Acervo">
        </form>
        
        <br />
        
        <form method="post" action="FrontController?action=BuscaReservasAction">
            <input type=submit value="Consultar Reservas">
        </form>
        
        <br />
        
        <form method="post" action="FrontController?action=BuscaEmprestimosAction">
            <input type=submit value="Renovar Empréstimo">
        </form>
        
        <br />
        
        <form method="post" action="FrontController?action=LogoutAction">
            <input type=submit value="Sair">
        </form>
        
    </body>
</html>
