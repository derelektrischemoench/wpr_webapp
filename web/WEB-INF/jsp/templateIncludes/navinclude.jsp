<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-light bg-light navbar-expand">
    <div class="navbar-expand" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto flex-row">
            <li class="nav-item active">
                <a href="/jsp" class="nav-link">Home</a>
            </li>
            <li class="nav-item active">
                <a href="/jsp/createChapter" class="nav-link">Create new chapter</a>
            </li>
            <li class="nav-item"><a href="/jsp/registeredUsers" class="nav-link">show serialized users</a></li>
            <c:if test="${cookie.containsKey('Username')}">
                <li class="nav-item">
                    <a href="logout" class="nav-link">logout</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>


<!--Wenn alles funktioniert, wie die anforderungen sind, dann ist es die zwei, wenn darüber hinaus dinge gemacht werden, ist die eins drin -->
<!-- Es muss alles verwendet werden was in den requirements steht -->