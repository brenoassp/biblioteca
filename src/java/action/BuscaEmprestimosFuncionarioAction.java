/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.EmprestimoDAO;
import java.io.IOException;
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
public class BuscaEmprestimosFuncionarioAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String matricula = request.getParameter("matricula");
        if(matricula != null){
            System.out.println("matricula: "+matricula);
            EmprestimoDAO dao = EmprestimoDAO.getInstance();
            List<Emprestimo> emprestimos = dao.getEmprestimosPendentesUsuario(matricula);
            request.setAttribute("emprestimos", emprestimos);
        }
        try {
            request.getRequestDispatcher("/emprestimosFuncionario.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(BuscaAcervoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
