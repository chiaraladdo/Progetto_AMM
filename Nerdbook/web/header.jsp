<%-- 
    Document   : header
    Created on : 15-mag-2017, 16.39.49
    Author     : Chiara
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header>
    
    <div id="title">
        Nerdbook
    </div>
    
    <nav>
        <ul>
            <li<c:if test="${page == 'descrizione'}"> class="active"</c:if>><a href="descrizione.jsp">Descrizione</a></li>
            <li<c:if test="${page == 'login'}"> class="active"></c:if>><a href="login.jsp">Login</a></li>
            
            
            <c:if test="${loggedIn}">
                
                <li<c:if test="${page == 'bacheca'}"> class="active"</c:if>><a href="bacheca.html?user=${loggedUserID}">Bacheca</a></li>
                <li<c:if test="${page == 'profilo'}"> class="active"</c:if>><a href="profilo.jsp">Profilo</a></li>
                <li>

                    <div id = "utenteBarra">
                        <img id="fotoProfiloBarra" alt="fotoProfiloAttivo" src="${utenteAttivo.urlFotoProfilo}">
                        <a class="profiloAttivoBarra" href="profilo.jsp"> ${utenteAttivo.nome}</a>
                        <a class="profiloAttivoBarra" href="login.html?logout=1"> Logout </a>
                    </div>
                </li> 
            </c:if>
            
        </ul>
    </nav>

</header>

