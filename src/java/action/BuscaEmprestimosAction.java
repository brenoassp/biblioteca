package action;

import dao.EmprestimoDAO;
import dao.ReservaDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Emprestimo;
import model.Reserva;

/**
 *
 * @author anubis
 */
public class BuscaEmprestimosAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String matricula = (String) request.getSession(false).getAttribute("loggedIn");
        EmprestimoDAO dao = EmprestimoDAO.getInstance();
        List<Emprestimo> emprestimos = dao.getEmprestimosPendentesUsuario(matricula);
        request.setAttribute("emprestimos", emprestimos);
        try {
            request.getRequestDispatcher("/emprestimos.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(BuscaAcervoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
