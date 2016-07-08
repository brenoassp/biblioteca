package action;

import dao.EmprestimoDAO;
import dao.ItemDAO;
import dao.MultaDAO;
import dao.ReservaDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Emprestimo;
import model.Item;
import model.Multa;
import model.Reserva;
import model.Usuario;

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
        if(dataLimite.compareTo(dataAtual) < 0){
            //calcula multa
            long d1=dataAtual.getTimeInMillis();
            long d2=dataLimite.getTimeInMillis();

            long qtdDiasAtraso = Math.abs((d1-d2)/(1000*60*60*24));
            
            double valor = emprestimo.getMulta((int)qtdDiasAtraso);
            
            Multa multa = new Multa(emprestimo.getIdemprestimo(),
                                emprestimo.getMatriculaUsuario(),
                                valor);
            MultaDAO.getInstance().insert(multa);
        }
        emprestimo.setDataEntrega(dataAtual);
        EmprestimoDAO.getInstance().update(emprestimo);
        Item item = ItemDAO.getInstance().get(emprestimo.getIditem());
        atualizaPosicaoReservas(item.getId());
        List<Usuario> users = UsuarioDAO.getInstance().getAll();
        item.getEstado().devolver(item);
        ItemDAO.getInstance().update(item);
        
        request.setAttribute("matricula", matricula);
        new BuscaEmprestimosFuncionarioAction().execute(request, response);
        
    }
    
    private Emprestimo getEmprestimo(int idemprestimo) {
        EmprestimoDAO dao = EmprestimoDAO.getInstance();
        return dao.get(idemprestimo);
    }

    private void atualizaPosicaoReservas(int iditem) {
        List<Reserva> reservas = ReservaDAO.getInstance().getReservasItem(iditem);
        for(Reserva reserva: reservas){
            reserva.setPosicao(reserva.getPosicao()-1);
            ReservaDAO.getInstance().update(reserva);
        }
    }
    
}
