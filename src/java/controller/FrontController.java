package controller;

import action.Action;
import action.LoginAction;
import action.LogoutAction;
import action.RedirectAction;
import action.ReservarAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import factory.ActionFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anubis
 */
public class FrontController extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String action = request.getParameter("action");
        Action actionObject = null;
        if(action == null || action.equals("")){
            response.sendRedirect("index.html");
        }
        actionObject = ActionFactory.getAction(action);
        /*else if(action.equals("Login")){
            actionObject = new LoginAction();  
        }
        else if(action.equals("Logout")){
            actionObject = new LogoutAction();  
        }
        else if(action.equals("Redirect")){
            String page = request.getParameter("page");
            actionObject = new RedirectAction(page);  
        }
        else if(action.equals("Reservar")){
            actionObject = new ReservarAction();
        }
        else if(action.equals("CancelarReserva")){
            actionObject = new ReservarAction();
        }
        else if(action.equals("RenovarEmprestimo")){
            actionObject = new ReservarAction();
        }
        else if(action.equals("DevolverItem")){
            actionObject = new ReservarAction();
        }*/
           
        if(actionObject!=null){
            actionObject.execute(request, response);
        }
        else{
            System.out.println("Action Object NULL!");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
