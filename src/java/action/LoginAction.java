package action;

import controller.FrontController;
import dao.FuncionarioDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;
import persistencia.DatabaseLocator;

/**
 *
 * @author anubis
 */
public class LoginAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        

        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");
        
        UsuarioDAO dao = UsuarioDAO.getInstance();
        Usuario user = dao.get(matricula);
        
        if(user != null && senha.equals(user.getSenha())){
            criaSessao(request, matricula);
            if(isFuncionario(user))
                response.sendRedirect("menuFuncionario.jsp");
            else
                response.sendRedirect("menuUsuario.jsp");
        }
        else{
            response.sendRedirect("index.html");
        }
        
    }
    
    private void criaSessao(HttpServletRequest request, String matricula){
        HttpSession session = request.getSession(true);
        session.setAttribute("loggedIn", matricula);
    }
    
    private boolean isFuncionario(Usuario user){
        FuncionarioDAO dao = FuncionarioDAO.getInstance();
        if(dao.get(user.getMatricula()) != null)
            return true;
        else return false;
    }
    
}
