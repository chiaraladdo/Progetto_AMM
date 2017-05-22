/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;


import amm.nerdbook.model.Gruppo;
import amm.nerdbook.model.GruppoFactory;
import amm.nerdbook.model.Utente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import amm.nerdbook.model.UtenteFactory;
import java.util.List;


/**
 *
 * @author Chiara
 */

@WebServlet(name = "Login", urlPatterns = {"/login.html"})
public class Login extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");

        //Apertura della sessione
        HttpSession session = request.getSession();
        
        //Se è impostato il parametro GET logout, distrugge la sessione
        if(request.getParameter("logout")!= null){
            
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        //Se l'utente già loggato
        //
        if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)){

            request.getRequestDispatcher("descrizione.jsp").forward(request, response);
            return;
       
        } 
        
        //Se l'utente non è loggato 
        else{
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            if (username != null && password != null){
                
                //id dell'utente loggato
                int loggedUserID = UtenteFactory.getInstance().getIdByUserAndPassword(username, password);
                
                
                //se l'utente è valido -> loggedIn e indirizzo in bacheca
                if(loggedUserID != -1){
                    
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserID", loggedUserID);
                    
                    //inizializzo gli utenti della sidebar
                    List<Utente> listaUtenti = UtenteFactory.getInstance().getListaUtenti();
                    session.setAttribute("listaUtenti", listaUtenti);
                    
                    //inizializzo i gruppidella sidebar
                    List<Gruppo> listaGruppi = GruppoFactory.getInstance().getListaGruppo();
                    session.setAttribute("listaGruppi", listaGruppi); 
                    
                    //inizializzo utente navbar
                    Utente utenteAttivo = UtenteFactory.getInstance().getUtenteById(loggedUserID);
                    session.setAttribute("utenteAttivo", utenteAttivo);
                    
                    
                    //Se il profilo dell'utente non è completo vai in profilo
                    if(UtenteFactory.getInstance().profiloCompleto(loggedUserID) == false){
                        request.getRequestDispatcher("profilo.html").forward(request, response);
                        return;
                    }
                    
                    //altrimenti vai in bacheca
                    request.getRequestDispatcher("bacheca.html").forward(request, response);
                    return;
                }
                
                //altrimenti se l'utente non e' valido
                else { 
                    
                    //ritorno al form del login informandolo che i dati non sono validi
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }
                
                
            }
        }
        
        /*
          Se non si verifica nessuno degli altri casi, 
          tentativo di accesso diretto alla servlet Login -> reindirizzo verso 
          il form di login.
        */
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
