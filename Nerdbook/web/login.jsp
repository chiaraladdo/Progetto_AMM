<%-- 
    Document   : login
    Created on : 16-mag-2017, 12.15.04
    Author     : Chiara
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!-- Pagina di login Nerdbook: ci si può registrare e accedere-->
<html>
    
    <head>
        
        <title>Benvenuto su Nerdbook</title>
        
        <meta charset = "UTF-8">
        <meta name = "viewport" content = "width=device-width, initial-scale=1.0">
        <meta name = "author" content = "Zuzi">
        <meta name = "description" content = "Registrazione e login Nerdbook">
        <meta name = "keywords" content = "nerdbook login iscrizione registrazione social network nerd facebook cerca amici videogames">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen"> 
    </head>
    
    <body>
        
       <!--Titolo della pagina e barra di navigazione tra le pagine del sito-->
        <c:set var="title" value="Login" scope="request"/>
        <jsp:include page="header.jsp"/>

        
        <!--Form per acquisire dati per il login-->
        <div id = "divBody">  

            <c:if test = "${loggedIn == true}">
                <div id = "furbettino">
                    <p>Sei già autenticato furbettino...</p>
                    <h1>Nessuno può hackerare Zuzi</h1>
                </div>
            </c:if>

            <c:if test = "${loggedIn == false || loggedIn == null}">
                <h1>Nerdbook - Login</h1>

                <div id="formLogin">

                    <c:if test="${invalidData == true}">
                        <div id="invalidDataWarning">
                            <p>I dati inseriti non sono corretti</p>
                        </div>
                    </c:if>

                    <form action="login.html" method="post">

                        <div>
                            <label for="username">Username</label>
                            <input type="text" name="username" id="username"/>
                        </div>

                        <div>
                            <label for="pswd">Password</label>
                            <input type="password" name="password" id="password"/>
                        </div>

                        <button type="submit">Accedi</button> 

                    </form>

                </div>
            </c:if>
        </div>
        
        
    </body>
    
</html>
