package action;

import dao.EmprestimoDAO;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Emprestimo;

/**
 *
 * @author anubis
 */
public class DevolverEmprestimoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Emprestimo emprestimo = getEmprestimo(Integer.parseInt(request.getParameter("emprestimo")));
        String matricula = emprestimo.getMatriculaUsuario();
        
        Calendar dataLimite = emprestimo.getDataDevolucao();
        Calendar dataAtual = Calendar.getInstance();
        
        if(dataLimite.compareTo(dataAtual) > 0){
            //calcula multa
        }
        else{
            emprestimo.setDataEntrega(dataAtual);
            EmprestimoDAO.getInstance().update(emprestimo);
        }
        
        request.setAttribute("matricula", matricula);
        new BuscaEmprestimosFuncionarioAction().execute(request, response);
        
    }
    
    private Emprestimo getEmprestimo(int idemprestimo) {
        EmprestimoDAO dao = EmprestimoDAO.getInstance();
        return dao.get(idemprestimo);
    }
    
}
