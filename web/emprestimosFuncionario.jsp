<%-- 
    Document   : emprestimoFuncionario
    Created on : 24/05/2016, 15:46:38
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
        <h1>Biblioteca</h1>
        
        <h3> Empréstimos Realizados </h3>
        
        <table>
         <thead>
            <tr>
               <th style = "width: 100px;">ID</th>
               <th style = "width: 100px;">Titulo</th>
               <th style = "width: 100px;">Data do Empréstimo</th>
               <th style = "width: 100px;">Limite para Devolução</th>
               <th style = "width: 100px;">Empréstimo</th>
            </tr>
         </thead>
         <tbody>
            <%--                                  
               // load ItemDAO
               // search for all Items
               //while(itemsResult.hasNext()){
               //   item = itemResult.getNext();
            --%>
            <tr>
                <td><%-- //item.getId(); --%></td>
                <td><%-- //item.getTitulo(); --%></td>
                <td><%-- //emprestimo.getDataEmprestimo(); --%></td>
                <td><%-- //emprestimo.getDataLimite(); --%></td>
                <td>
                   <a href="FrontController?action=DevolverItemAction&item=<%-- //reserva.getId() --%>">
                      Empréstimo
                   </a>
                </td>
            </tr>
            <%--                               
                } 
            --%> 
             
         </tbody>
    </table>
            
    <br />
    
    <form method="post" action="FrontController?action=RedirectAction&page=menuFuncionario.jsp">
        <input type=submit value="Voltar">
    </form>
    
    </body>
</html>
