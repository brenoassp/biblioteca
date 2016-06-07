package action;

import dao.EmprestimoDAO;
import dao.ItemDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Emprestimo;
import model.Item;
import model.Multa;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author anubis
 */
public class DevolverEmprestimoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Emprestimo emprestimo = getEmprestimo(Integer.parseInt(request.getParameter("emprestimo")));
        
        //INICIO TESTE///
        System.out.println(emprestimo.getIdemprestimo());
        System.out.println(emprestimo.getIditem());
        System.out.println(emprestimo.getMatriculaUsuario());
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	System.out.println(sdf.format(emprestimo.getDataEmprestimo().getTime())); 
        System.out.println(sdf.format(emprestimo.getDataDevolucao().getTime()));
        ///FIM TESTE///
        
        String matricula = emprestimo.getMatriculaUsuario();
        
        Calendar dataLimite = emprestimo.getDataDevolucao();
        Calendar dataAtual = Calendar.getInstance();
        if(dataLimite.compareTo(dataAtual) < 0){
            //calcula multa
//            DateTime limite = new DateTime(new Date(dataLimite.getTimeInMillis()).getYear(), ;;
//                                            new Date(dataLimite.getTimeInMillis()).getMonth(),
//                                            new Date(dataLimite.getTimeInMillis()).getDay(), 
//                                            0, 0);
//            DateTime atual = new DateTime(new Date(dataAtual.getTimeInMillis()).getYear(), 
//                                            new Date(dataAtual.getTimeInMillis()).getMonth(),
//                                            new Date(dataAtual.getTimeInMillis()).getDay(), 
//                                            0, 0);
//            int days = Days.daysBetween(atual, limite).getDays();
//            System.out.println("dias entre"+new Date(dataLimite.getTimeInMillis()).getDay());
//            System.out.println("dias entre"+new Date(dataLimite.getTimeInMillis()).getDay());
//            double valor = 
//            Multa multa = new Multa(emprestimo.getIdemprestimo(),
//                                emprestimo.getMatriculaUsuario(),
//                                valor);
            
           
           //multa.setIdemprestimo(emprestimo.getIdemprestimo());
           //multa.setMatriculaUsuario(emprestimo.getMatriculaUsuario());
           //multa.
        }
        else{
            
            emprestimo.setDataEntrega(dataAtual);
            EmprestimoDAO.getInstance().update(emprestimo);
            Item item = ItemDAO.getInstance().get(emprestimo.getIditem());
            item.getEstado().devolver(item);
            ItemDAO.getInstance().update(item);
            System.out.println(sdf.format(emprestimo.getDataEntrega().getTime()));
        }
        
        request.setAttribute("matricula", matricula);
        new BuscaEmprestimosFuncionarioAction().execute(request, response);
        
    }
    
    private Emprestimo getEmprestimo(int idemprestimo) {
        EmprestimoDAO dao = EmprestimoDAO.getInstance();
        return dao.get(idemprestimo);
    }
    
}
