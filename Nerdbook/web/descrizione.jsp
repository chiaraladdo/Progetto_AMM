<%-- 
    Document   : descrizione
    Created on : 16-mag-2017, 12.14.53
    Author     : Chiara
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!--Pagina di descrizione del Social network-->
<html>
    
    <head>
        
        <title>Nerdbook: You shall pass</title>
        
        <meta charset = "UTF-8">
        <meta name = "viewport" content = "width=device-width, initial-scale=1.0">
        <meta name = "author" content = "Zuzi">
        <meta name = "description" content = "Descrizione di Nerdbook">
        <meta name = "keywords" content = "cerca amici nerd social network nerdbook facebook descrizione iscrizione gratis">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>

    <body>
        
        <!--Titolo della pagina e barra di navigazione tra le pagine del sito-->
        <c:set var="title" value="Descrizione" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <!-- Info -->
        <div id = "divbody">       
            
            <div id="Sommario">
                
                <h1>Sommario</h1>
                <ol class="elementiSommario">
                    
                    <li>
                        <a href = "#infoNerdbook">Come funziona Nerdbook</a>
                        
                        <!--Lista ordinata interna con le sottosezioni-->
                        <ol>
                            <li><a href = "#rivolto">A chi è rivolto?</a></li>
                            <li><a href = "#comeIscriversi">Come iscriversi</a></li>
                        </ol>                  
                    </li>
                    <li><a href = "#gratis">È gratis?</a></li>
                    
                </ol>
                
            </div>
            
            <div id="info">
                
                <h2 id="infoNerdbook">Come funziona Nerdbook</h2>
                
                <div id="info1">
                   
                    <h3 id="rivolto">A chi è rivolto?</h3>
                    <p>Nerdbook è il nuovo social network dedicato ai nerd di tutto il mondo.</p>
                </div>
                
                <div id="info2">
                    <h3 id="comeIscriversi">Come iscriversi</h3>
                <p>Vai su login.</p>
                </div>
                
                
                <h2 id="gratis">È gratis?</h2>
                
                <div id="info3">
                    <p>Nerdbook è gratis e lo sarà sempre.</p>
                </div>
                
                <div id="info4">
                    <p>Grazie per aver usato Nerdbook.</p>
                    <p>Speriamo di rivederti presto.</p>
                </div>
                
            </div>
        </div>
    
    </body> 
    
</html>
