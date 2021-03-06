<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Biblioteca</title>
    </head>
    <body>
        <h1>Biblioteca</h1>
        
        <h3> Empréstimos Realizados </h3>
        
        <table>
         <thead>
            <tr>
               <th style = "width: 100px;">ID</th>
               <th style = "width: 100px;">Data do Empréstimo</th>
               <th style = "width: 100px;">Limite para Devolução</th>
               <th style = "width: 100px;">Renovar</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach items="${emprestimos}" var="emprestimo">
                <tr>
                    
                    <td>${emprestimo.idemprestimo}</td>
                    <td><fmt:formatDate value="${emprestimo.dataEmprestimo.time}" type="date" dateStyle="short"/></td>
                    <td><fmt:formatDate value="${emprestimo.dataDevolucao.time}" type="date" dateStyle="short"/></td>
                    <td>
                       <a href="FrontController?action=RenovarEmprestimoAction&amp;emprestimo=${emprestimo.idemprestimo}">
                          Renovar
                       </a>
                    </td>
                </tr>
            </c:forEach>
             
         </tbody>
    </table>
            
    <br />
    
    <form method="post" action="FrontController?action=RedirectAction&amp;page=menuUsuario.jsp">
        <input type=submit value="Voltar">
    </form>
    
    </body>
</html>
