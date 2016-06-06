package action;

import dao.ReservaDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Reserva;

/**
 *
 * @author anubis
 */
public class BuscaReservasAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String matricula = (String) request.getSession(false).getAttribute("loggedIn");
        ReservaDAO dao = ReservaDAO.getInstance();
        List<Reserva> reservas = dao.getReservasUsuario(matricula);
        request.setAttribute("reservas", reservas);
        try {
            request.getRequestDispatcher("/reservas.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(BuscaAcervoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
