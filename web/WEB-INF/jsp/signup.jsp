<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF${pageContext.request.contextPath}/templateIncludes/headinclude.jsp" />
<body>
<jsp:include page="/WEB-INF${pageContext.request.contextPath}/templateIncludes/navinclude.jsp" />



<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h1>Signup</h1>
            <p>Please enter your credentials below</p>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <form action="${pageContext.request.contextPath}/signup" method="post">
                <div class="form-group">
                    <label for="name">
                        <p>Username:</p>
                        <input type="text" id="name" name="name">
                    </label>
                </div>
                <div class="form-group"><label for="password">
                    <p>Passwort</p>
                    <input type="password" id="password" name="password"></label></div>
                <div class="form-group"><label for="password2">
                    <p>Passwort, wiederholen</p>
                    <input type="password" id="password2" name="password2"></label></div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="amelden">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>