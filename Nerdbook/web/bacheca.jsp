<%-- 
    Document   : bacheca
    Created on : 16-mag-2017, 12.14.41
    Author     : Chiara
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    
    <head>
        
        <title>Nerdbook</title>
        
        <meta charset = "UTF-8">
        
        <meta name = "viewport" content = "width=device-width, initial-scale=1.0">
        <meta name = "author" content = "Zuzi">
        <meta name = "description" content = "Bacheca con post degli utenti di nerdbook">
        <meta name = "keywords" content = "cerca amici nerd social network facebook bacheca post nerdbook videogames">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        
    </head>

    <body>
        
        <!--Titolo della pagina e barra di navigazione tra le pagine del sito-->
        <c:set var="title" value="Bacheca" scope="request"/>
        <jsp:include page="header.jsp"/>

        <!--Contenuti della pagina-->
        <div id="divBody">
            
            <!--Sidebar-->
            <jsp:include page="sidebar.jsp"/>
            
            <!--ProfiloAttivo-->
            <div id="profiloAttivo">
               <img class="fotoProfilo" alt="fotoProfiloAttivo" src="${utente.urlFotoProfilo}">
               <p class="nomeUtente">"${utente.nome}" "${utente.cognome}":</p>
               <p class="content">"${utente.frase}"</p>
            </div>
            
            <!--Nuovo Post-->
            <div id="nuovoPost">
                <form action="servlet.java" method="post">
                      
                    <p>Crea un post</p>
                    <textarea name="textPost" id="textPost"></textarea>
                    
                    <div id="tipoPost">
                        
                        <div>
                            <label for="noneType">None</label>
                            <input type="radio" name="tipoPost" value="noneType" id="noneType">
                        </div>
                        
                        <div>
                            <label for="urlType">Url</label>
                            <input type="radio" name="tipoPost" value="urlType" id="urlType">
                        </div>
                        
                        <div>
                            <label for="imgType">Foto</label>
                            <input type="radio" name="tipoPost" value="imgType" id="imgType">
                        </div>
                        
                        
                    </div>
                    
                    <div id="contenutoAllegato"> 
                        <div>
                            <label for="urlPost">Url</label>
                            <input type="url" name="urlPost" id="urlPost">
                        </div>
                    </div>
                    
                    <button type="submit">Crea Post</button>
                    
                </form>
            </div>
            
            <!--lista dei post-->
            <div id="posts">
                
                <c:forEach var="post" items="${post}">
                    
                    <div class="post">
                        <img class="fotoProfilo" alt="fotoProfilo" src="${post.utente.urlFotoProfilo}">
                        <p class="nomeUtente">"${post.utente.nome} ${post.utente.cognome}"</p>

                        <div class="content">
                            <p>${post.contenuto}</p>
                            <c:if test="${post.tipoPost == 'IMAGE'}">
                                <img alt="Foto Post" src="${post.contenutoTipo}">
                            </c:if>

                            <c:if test="${post.tipoPost == 'URL'}">
                                <img alt="Foto Post" src="${post.contenutoTipo}">
                            </c:if>
                        </div>
                    </div>
                        
                </c:forEach>
                
            </div>
            
        </div>
        
    </body>
</html>
