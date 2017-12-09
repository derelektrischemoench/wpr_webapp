<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="WEB-INF/templateIncludes/headinclude.jsp"/>
<body>
<jsp:include page="WEB-INF/templateIncludes/navinclude.jsp"/>



<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h1>Welcome</h1>
        </div>
        <div class="col-sm-12">
            <p>
                All other jsps shall reside in /WEB-INF/jsp
            </p>
            <c:out value="${pageContext.request.method}" />
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <c:url value = "/calculateServlet"/>
        </div>
    </div>
</div>
</body>
</html>