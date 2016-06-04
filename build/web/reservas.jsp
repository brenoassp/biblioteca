<%-- 
    Document   : reservas
    Created on : May 24, 2016, 9:50:04 AM
    Author     : anubis
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
        
        <h3> Reservas Solicitadas </h3>
        
        <table>
         <thead>
            <tr>
               <th style = "width: 100px;">ID</th>
               <th style = "width: 100px;">Data da Reserva</th>
               <th style = "width: 100px;">ISBN</th>
               <th style = "width: 100px;">Data Limite</th>
               <th style = "width: 100px;">Cancelar</th>
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
                <td><%-- //item.getISBN(); --%></td>
                <td><%-- //item.getISBN(); --%></td>
                <td>
                   <a href="FrontController?action=CancelarReservaAction&item=<%-- //reserva.getId() --%>">
                      Cancelar
                   </a>
                </td>
            </tr>
            <%--                               
                } 
            --%> 
             
         </tbody>
    </table>
         
        <br />
        
        <h3> Reservas Atendidas </h3>
        
        <table>
         <thead>
            <tr>
               <th style = "width: 100px;">ID</th>
               <th style = "width: 100px;">Data da Reserva</th>
               <th style = "width: 100px;">ISBN</th>
               <th style = "width: 100px;">Posição</th>
               <th style = "width: 100px;">Cancelar</th>
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
                <td><%-- //item.getISBN(); --%></td>
                <td><%-- //resva.getPosicao(); --%></td>
                <td>
                   <a href="FrontController?action=CancelarReserva&item=<%-- //reserva.getId() --%>">
                      Cancelar
                   </a>
                </td>
            </tr>
            <%                               
               // } 
            %> 
             
         </tbody>
             
    </table>
            
    <br />
          
    <form method="post" action="FrontController?action=RedirectAction&page=menuUsuario.jsp">
        <input type=submit value="Voltar">
    </form>
            
    </body>
</html>
