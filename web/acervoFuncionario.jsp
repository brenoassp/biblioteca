<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Biblioteca</title>
    </head>
    <body>
        <h1>Biblioteca</h1>
        
        <h3> Acervo </h3>
        
        <table>
         <thead>
            <tr>
               <th style = "width: 100px;">ID</th>
               <th style = "width: 100px;">Título</th>
               <th style = "width: 100px;">Matricula</th>
            </tr>
         </thead>
         <tbody>
           
            <c:forEach items="${items}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td><c:out value="${item.titulo}" /></td>
                    <td>
                        <form method="post" action="FrontController?action=EmprestarAction">
                            Matricula: <input type=text NAME="matricula" />
                            <input TYPE=submit VALUE="Emprestar" />
                        </form>
                    </td>
                </tr>
            </c:forEach>

         </tbody>
             
    </table>
    
    <br />
    
    <form method="post" action="FrontController?action=RedirectAction&amp;page=menuFuncionario.jsp">
        <input type=submit value="Voltar">
    </form>
    </body>
</html>

