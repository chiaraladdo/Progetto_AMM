/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.model.Gruppo;
import amm.nerdbook.model.GruppoFactory;
import amm.nerdbook.model.Post;
import amm.nerdbook.model.PostFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amm.nerdbook.model.UtenteFactory;
import amm.nerdbook.model.Utente;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chiara
 */
@WebServlet(name = "Bacheca", urlPatterns = {"/bacheca.html"})
public class Bacheca extends HttpServlet {
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
            
            if(request.getParameter("gruppo") == null){
                //visualizzare una bacheca di uno specifico utente
                String user = request.getParameter("utente");

                //acquisisco utente
                int userID;

                if(user!= null){
                    userID = Integer.parseInt(user);

                } 

                else{
                    Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
                    userID = loggedUserID;
                }

                //Acquisisco l'utente loggato
                Utente utente = UtenteFactory.getInstance().getUtenteById(userID);

                //se esiste davvero
                if(utente != null){

                    //inizializzo la variabile utente per la jsp
                    request.setAttribute("utente", utente);

                    //inizializzo i post dell'utente nella sua bacheca
                    List<Post> post = PostFactory.getInstance().getPostList(utente);
                    request.setAttribute("posts", post);

                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                }

                //altrimenti errore
                else{
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            }
            
            else{

                String group = request.getParameter("gruppo");

                //acquisisco gruppo
                int groupID = 0;

                if(group!= null){
                    groupID = Integer.parseInt(group);

                }

                Gruppo gruppo = GruppoFactory.getInstance().getGruppoById(groupID);

                //se esiste davvero
                if(gruppo != null){

                    //inizializzo la variabile gruppo per la jsp
                    request.setAttribute("gruppo", gruppo);

                    //inizializzo i post dell'utente nella sua bacheca
                    List<Post> post = PostFactory.getInstance().getPostList(gruppo);
                    request.setAttribute("posts", post);

                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                }

                //altrimenti errore
                else{
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            }
            
        }
        
        //se non c'è un utente messaggio di errore
        else{
            
            //messaggio di errore
            request.setAttribute("invalidData", true);
            request.getRequestDispatcher("bacheca.jsp").forward(request, response);
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

