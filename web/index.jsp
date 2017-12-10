<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="WEB-INF/${pageContext.request.contextPath}/templateIncludes/headinclude.jsp"/>
<body>
<jsp:include page="WEB-INF/${pageContext.request.contextPath}/templateIncludes/navinclude.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h1>Welcome</h1>
        </div>
        <div class="col-sm-12">
            <p>
                All other jsps shall reside in /WEB-INF/jsp
            </p>
            ${pageContext.request.contextPath}
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <h2>Sign in </h2>
        </div>
    </div>
    <c:choose>
        <c:when test="${pageContext.request.method eq 'GET'}">
            <div class="row">
                <div class="col-sm-12">
                    <form action="${pageContext.request.contextPath}/signin" method="post">
                        <div class="form-group">
                            <label for="name">
                                <p>Username:</p>
                                <input type="text" id="name" name="name">
                            </label>
                        </div>
                        <div class="form-group"><label for="password">
                            <p>Passwort</p>
                            <input type="text"></label></div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" value="amelden">
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    ${pageContext.request.requestURI}
                    ${pageContext.request.requestURL}
                    Don't have an account yet? click <a href="${pageContext.request.requestURI}signup">here</a> to sign up.
                </div>
            </div>
        </c:when>
        <c:otherwise>
            request is POST
        </c:otherwise>
    </c:choose>


</div>
</body>
</html>