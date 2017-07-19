<%-- 
    Document   : sidebar
    Created on : 16-mag-2017, 17.24.41
    Author     : Chiara
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!--SideBar-->
<div id = "sidebar">

    <form>
        <input type="search" name="searchBar" id="searchBar" placeholder="Cerca..."/>
    </form>

    <!--Lista Utenti-->
    <div id="Persone">

        <h2>Persone</h2>

        <c:forEach var="persona" items="${listaUtenti}">
            <ul>
                <li class = "persona">
                    <img alt="fotoProfilo" src="${persona.urlFotoProfilo}">
                    <a href = "bacheca.html?utente=${persona.id}">
                        ${persona.nome} ${persona.cognome}</a>
                </li>
            </ul>
        </c:forEach>

    </div>

    <!--Lista Gruppi-->
    <div id="Gruppi">

        <h2>Gruppi</h2>

        <c:forEach var="gruppo" items="${listaGruppi}">
            <ul>
                <li class = "gruppo">
                    <img alt="fotoGruppo" src="${gruppo.urlFotoGruppo}">
                    <a href = "bacheca.html?gruppo=${gruppo.id}">
                        ${gruppo.nome}</a>
                </li>
            </ul>
        </c:forEach>

    </div>

</div>
