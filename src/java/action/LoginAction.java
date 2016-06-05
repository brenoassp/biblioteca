package action;

import controller.FrontController;
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
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        /*try {
            Connection conn = DatabaseLocator.getConnection();
            if(conn == null){
                response.sendRedirect("menuFuncionario.jsp");
            }
            else{
                response.sendRedirect("menuUsuario.jsp");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        if(username.equals("admin")){
            response.sendRedirect("menuFuncionario.jsp");
        }
        else if(username.equals("aluno")){
            response.sendRedirect("menuUsuario.jsp");
        }
        else{
            Usuario usuario = login(username, password);
            if (usuario != null) {
                criaSessao(request);
                if(usuario.isFuncionario())
                    response.sendRedirect("menuFuncionario.jsp");
                else
                    response.sendRedirect("menuUsuario.jsp");
            }
            else{
                response.sendRedirect("index.html");
            }
        
        }
        
        
    }
    
    public Usuario login(String username, String password){
        // acessa banco de dados e verifica se existe usuário
   
        if (username.equals("") || password.equals("")) {
            return null;
        }
        else if(username.equals("admin") && password.equals("admin")){
            return new Usuario();
        }
        else
            return null;
    }
    
    public static void criaSessao(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.setAttribute("loggedIn", "true");
    }
    
}
