<%-- 
    Document   : sidebar
    Created on : 16-mag-2017, 17.24.41
    Author     : Chiara
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <body>
        
        <div id="divBody">
        
            <!--SideBar-->
            <div id = "sidebar">
                
                <form>
                    <input type="search" name="searchBar" id="searchBar" placeholder="Cerca..."/>
                </form>
                
                <!--Lista Utenti-->
                <div id="Persone">
                    
                    <h2>Persone</h2>
                    
                    <c:forEach var="persona" items="${utente}">
                        <ul>
                            <li class = "persona">
                                <img alt="fotoProfilo" src="${persona.urlFotoProfilo}">
                                <a href = "file:///Users/Chiara/NetBeansProjects/Progetto_AMM/Nerdbook/web/M2/bacheca.html?utente= ${persona.id}">
                                    "${persona.nome} ${persona.cognome}"</a>
                            </li>
                        </ul>
                    </c:forEach>
                    
                </div>
                
                <!--Lista Gruppi-->
                <div id="Gruppi">
                    
                    <h2>Gruppi</h2>
                    
                    <c:forEach var="gruppo" items="${gruppo}">
                        <ul>
                            <li class = "gruppo">
                                <img alt="fotoGruppo" src="${gruppo.urlFotoGruppo}">
                                <a href = "file:///Users/Chiara/NetBeansProjects/Progetto_AMM/Nerdbook/web/M2/bacheca.html?gruppo= ${gruppo.id}">
                                    "${gruppo.nome}"</a>
                            </li>
                        </ul>
                    </c:forEach>

                </div>
                
            </div>
         </div>
        
    </body>
</html>
