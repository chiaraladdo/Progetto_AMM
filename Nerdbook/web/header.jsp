<%-- 
    Document   : header
    Created on : 15-mag-2017, 16.39.49
    Author     : Chiara
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    
    <div id="title">
        Nerdbook - ${title}
    </div>
    
    <nav>
        <ul>
            <li<c:if test="${page=='descrizione'}"> class="active"</c:if>><a href="descrizione.html">Descrizione</a></li>
            
            <c:if test="${page=='bacheca'}"> class="active"
                <li><a href="Bacheca">Bacheca Personale</a></li>
            </c:if>
            
            <c:if test="${page=='login'}"> class="active"
                <li><a href="login.html">Login</a></li>
            </c:if>
            
            <c:if test="${page=='profilo'}"> class="active"
                <li><a href="profilo.html">Profilo</a></li>
            </c:if>
        </ul>
    </nav>

</header>

