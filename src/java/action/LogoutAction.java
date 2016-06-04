package action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anubis
 */
public class LogoutAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        excluiSessao();
        response.sendRedirect("index.html");
    }
    
    public static void excluiSessao(){
        return;
    }
}
