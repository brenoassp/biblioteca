/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.ItemDAO;
import dao.ReservaDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;
import model.Reserva;
import model.Usuario;

/**
 *
 * @author anubis
 */
public class ReservarAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario user = getUsuario(request);
        Item item = getItem(request);
        
        if(user != null){
            criaReserva(user, item);
            (new BuscaReservasAction()).execute(request, response);
        }
        else
            (new BuscaEmprestimosAction()).execute(request, response);
        
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
    
    private Item getItem(HttpServletRequest request){
        try{
            int iditem = Integer.parseInt(request.getParameter("item"));
            ItemDAO dao = ItemDAO.getInstance();
            return dao.get(iditem);
        }
        catch(NullPointerException ex){
            return null;
        }
    }
    
    private void criaReserva(Usuario user, Item item){
        List<Reserva> reservasDesteItem = ReservaDAO.getInstance().getReservasItem(item.getId()); 
        Reserva reserva = new Reserva(user.getMatricula(), item.getId(), reservasDesteItem.size()+1);
        item.addObserver(user);
        ReservaDAO dao = ReservaDAO.getInstance();
        dao.insert(reserva);
    }
    
}
