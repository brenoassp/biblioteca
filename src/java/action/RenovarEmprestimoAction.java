/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.EmprestimoDAO;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Emprestimo;

/**
 *
 * @author anubis
 */
public class RenovarEmprestimoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Emprestimo emprestimo = getEmprestimo(Integer.parseInt(request.getParameter("emprestimo")));
        
        Calendar dataEmprestimo = emprestimo.getDataEmprestimo();
        Calendar dataDevolucao = emprestimo.getDataDevolucao();
        
        if(mesmoDia(dataEmprestimo, dataDevolucao)){
            dataDevolucao.add(Calendar.DATE, 10);
            emprestimo.setDataDevolucao(dataDevolucao);
            EmprestimoDAO.getInstance().update(emprestimo);
        }
       
        new BuscaEmprestimosAction().execute(request, response);
    }

    private Emprestimo getEmprestimo(int idemprestimo) {
        EmprestimoDAO dao = EmprestimoDAO.getInstance();
        return dao.get(idemprestimo);
    }
    
    private boolean mesmoDia(Calendar cal1, Calendar cal2){
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }
    
}
