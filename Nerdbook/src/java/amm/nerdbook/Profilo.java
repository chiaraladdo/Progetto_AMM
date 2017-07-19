/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import amm.nerdbook.model.UtenteFactory;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chiara
 */
@WebServlet(name = "Profilo", urlPatterns = {"/profilo.html"})
public class Profilo extends HttpServlet {

/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
         
        HttpSession session = request.getSession(false);

        //se la sessione esiste ed esiste anche l'attributo loggedIn impostato a true
        if(session != null && 
           session.getAttribute("loggedIn") != null &&
           session.getAttribute("loggedIn").equals(true)){
            
            //controllo se è impostato il parametro get "user" che mi consente
            //di visualizzare un profilo di uno specifico utente
            String user = request.getParameter("user");
            
            int userID;
           

            if(user != null){
                userID = Integer.parseInt(user);
            
            } 
            
            else{
                Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
                userID = loggedUserID;
            }
            
            Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
            
            //Se il profilo dell'utente viene completato stampa un messaggio
            if(UtenteFactory.getInstance().profiloCompleto(loggedUserID) == true){
                request.setAttribute("completeData", true);
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
            }
            
            
            
        }
        
        else{
            
            //messaggio di errore
            request.setAttribute("invalidData", true);
            request.getRequestDispatcher("profilo.jsp").forward(request, response);
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
