<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF${pageContext.request.contextPath}/templateIncludes/headinclude.jsp" />
<body>
<jsp:include page="/WEB-INF${pageContext.request.contextPath}/templateIncludes/navinclude.jsp" />



<div class="container">
    <div class="row">
        <div class="col-sm-12">
            credentials of the signup form:
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            ${username}
            ${password}
            ${password2}
        </div>
    </div>

</div>
</body>
</html>
