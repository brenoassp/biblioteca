package action;

import dao.EmprestimoDAO;
import dao.ItemDAO;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Emprestimo;
import model.Item;

/**
 *
 * @author anubis
 */
public class EmprestarAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //empresta item
        String matricula = request.getParameter("matricula");
        if(!matricula.equals("") && matricula != null){
            int iditem = Integer.parseInt(request.getParameter("iditem"));
            int idEmprestimo = EmprestimoDAO.getInstance().getAll().size() + 1;
            Calendar dataEmprestimo = Calendar.getInstance();
            Calendar dataDevolucao = Calendar.getInstance();
            dataDevolucao.add(Calendar.DAY_OF_MONTH, 15);
            Emprestimo emprestimo = new Emprestimo(idEmprestimo, matricula, iditem, 
                    dataEmprestimo, dataDevolucao, null);

            EmprestimoDAO daoEmprestimo = EmprestimoDAO.getInstance();
            daoEmprestimo.insert(emprestimo);
            apagaReserva(matricula, iditem);

            ItemDAO daoItem = ItemDAO.getInstance();
            Item item = daoItem.get(iditem);
            item.getEstado().emprestar(item);
            daoItem.update(item);
            
        }
        //redireciona pra busca de acervo do funcionario
        new BuscaAcervoFuncionarioAction().execute(request, response);    
    }
    
    public void apagaReserva(String matricula, int iditem){
        
    }
    
}
