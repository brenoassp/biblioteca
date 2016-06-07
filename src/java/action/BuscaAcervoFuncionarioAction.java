package action;

import dao.ItemDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;

/**
 *
 * @author anubis
 */
public class BuscaAcervoFuncionarioAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchTerm = request.getParameter("search");
        List<Item> items = new ArrayList<>();
        ItemDAO dao = ItemDAO.getInstance();
        if(searchTerm == null)
            for(Item item : dao.getAll()){
                if(!item.getEstado().emprestar(item).equals("Impossivel")){
                    items.add(item);
                }
            }
//            items = dao.getAll();
        else
            items = dao.search(searchTerm);  
        request.setAttribute("items", items);
        try {
            request.getRequestDispatcher("/acervoFuncionario.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(BuscaAcervoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
