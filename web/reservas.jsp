<%-- 
    Document   : reservas
    Created on : May 24, 2016, 9:50:04 AM
    Author     : anubis
--%>

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
        
        <h3> Reservas Solicitadas </h3>
        
        <table>
            <thead>
                <tr>
                   <th style = "width: 100px;">ID</th>
                   <th style = "width: 100px;">Posição</th>
                   <th style = "width: 100px;">Cancelar</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${reservas}" var="reserva">
                    <tr>
                        <td>${reserva.iditem}</td>
                        <td>${reserva.posicao}</td>
                        <td>
                           <a href="FrontController?action=CancelarReservaAction&amp;item=${reserva.iditem}">
                              Cancelar
                           </a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
    </table>
         
        <br />
        
        <h3> Reservas Atendidas </h3>
        
        <table>
            <thead>
                <tr>
                   <th style = "width: 100px;">ID</th>
                       <th style = "width: 100px;">Posição</th>
                       <th style = "width: 100px;">Cancelar</th>
                </tr>
            </thead>
            <tbody>
                
                <c:forEach items="${reservasAtendidas}" var="reservaAtendida">
                    <tr>
                        <td>${reservaAtendida.iditem}</td>
                        <td>${reservaAtendida.posicao}</td>
                        <td>
                           <a href="FrontController?action=CancelarReservaAction&amp;item=${reservaAtendida.iditem}">
                              Cancelar
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
