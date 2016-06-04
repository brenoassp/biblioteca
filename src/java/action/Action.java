package action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anubis
 */
public interface Action {
    
    public void execute(HttpServletRequest request, HttpServletResponse response) 
            throws IOException;
    
}
