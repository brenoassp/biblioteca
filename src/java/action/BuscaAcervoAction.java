/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.ItemDAO;
import java.io.IOException;
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
public class BuscaAcervoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchTerm = request.getParameter("search");
        List<Item> items;
        ItemDAO dao = ItemDAO.getInstance();
        if(searchTerm == null)
            items = dao.getAll();
        else
            items = dao.search(searchTerm);  
        request.setAttribute("items", items);
        try {
            request.getRequestDispatcher("/acervo.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(BuscaAcervoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
