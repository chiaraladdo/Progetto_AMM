<%-- 
    Document   : profilo
    Created on : 16-mag-2017, 12.15.16
    Author     : Chiara
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!--Pagina con il profilo utente-->
<html>
    <head>
        
        <title>Nerdbook: You shall pass</title>
        
        <meta charset = "UTF-8">
        <meta name = "viewport" content = "width=device-width, initial-scale=1.0">
        <meta name = "author" content = "Zuzi">
        <meta name = "description" content = "Descrizione di Nerdbook">
        <meta name = "keywords" content = "profilo utente nerd social network nerdbook facebook">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        
        <!--Titolo della pagina e barra di navigazione tra le pagine del sito-->
        <c:set var="title" value="Profilo" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <div id = "divBody">
            
            
            <c:if test="${invalidData == true}">
                <div id="invalidDataWarning">
                    <p>Accesso negato</p>
                </div>
            </c:if>
            
            <c:if test="${completeData == true}">
                <div id="completeData">
                    <h1>Abbiamo inserito i dati (invece non è vero, lol)</h1>
                </div>
            </c:if>
            
            <!--Se c'è un utente autenticato-->
            <c:if test="${loggedIn}">
                <!--Sidebar-->
                <jsp:include page="sidebar.jsp"/>

                <div id="formProfilo" >

                    <div id="dimFotoProfilo" class="dimFoto">
                       <img alt="fotoProfiloAttivo" src="${utenteAttivo.urlFotoProfilo}"> 
                    </div>


                    <form class="Profilo" action="profilo.html" method="post">

                        <div>
                            <label for="nomeUtente">Nome</label>
                            <input type="text" name="nomeUtente" id="nomeUtente" value="${utenteAttivo.nome}"/>
                        </div>

                        <div>
                            <label for="cognomeUtente">Cognome</label>
                            <input type="text" name="cognomeUtente" id="cognomeUtente" value="${utenteAttivo.cognome}"/>
                        </div>

                        <div>
                            <label for="urlProfilo">URL Immagine del Profilo</label>
                            <input type="url" name="urlProfilo" id="urlProfilo" value="${utenteAttivo.urlFotoProfilo}">    
                        </div>

                        <div>
                            <label for="presentazione">Frase Presentazione</label>
                            <textarea rows="4" cols="20" name="presentazione" id="presentazione"
                                      value="${utenteAttivo.frase}" ></textarea>
                        </div>

                        <div>
                            <label for="dataNascita">Data di nascita</label>
                            <input type="date" name="dataNascita" id="dataNascita" value="${utenteAttivo.data}"/>
                        </div>

                        <div>
                            <label for="pswd">Password</label>
                            <input type="password" name="pswd" id="pswd" value="${utenteAttivo.password}"/>
                        </div>

                        <div>
                            <label for="confermaPswd">Conferma Password</label>
                            <input type="password" name="confermaPswd" id="confermaPswd"  value="${utenteAttivo.password}"/>
                        </div>

                        <button type="submit">Aggiorna</button> 

                    </form>                 
                </div>
            </c:if>
        
        </div>
        
    </body>
</html>
