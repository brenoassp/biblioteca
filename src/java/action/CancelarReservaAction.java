/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.ReservaDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Reserva;
import model.Usuario;

/**
 *
 * @author anubis
 */
public class CancelarReservaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String matricula = (getUsuario(request)).getMatricula();
        int iditem = Integer.parseInt(request.getParameter("item"));
        
        Reserva reserva = ReservaDAO.getInstance().get(iditem, matricula);
        ReservaDAO.getInstance().delete(reserva);

        new BuscaReservasAction().execute(request, response);
    }
    
    private Usuario getUsuario(HttpServletRequest request){
        try{
            String matricula = (String) request.getSession(false).getAttribute("loggedIn");
            UsuarioDAO dao = UsuarioDAO.getInstance();
            return dao.get(matricula);
        }
        catch(NullPointerException ex){
            return null;
        } 
    }
}
