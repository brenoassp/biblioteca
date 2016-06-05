package action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anubis
 */
public class LogoutAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        excluiSessao(request);
        response.sendRedirect("index.html");
    }
    
    public static void excluiSessao(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.setAttribute("loggedIn", 0);
    }
}
