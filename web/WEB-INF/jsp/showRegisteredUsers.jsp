<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF${pageContext.request.contextPath}/templateIncludes/headinclude.jsp" />
<body>
<jsp:include page="/WEB-INF${pageContext.request.contextPath}/templateIncludes/navinclude.jsp" />

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h1>Registered Users:</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            ${userName} <br>
            ${userPass}
        </div>
    </div>
</div>

<!--<c:forEach items="${deserializedUsers}" var="user">
    <tr>
        <td>Employee ID: <c:out value="${user.username}"/></td>
        <td>Employee Pass: <c:out value="${user.password}"/></td>
    </tr>
</c:forEach>-->

</div>
</body>
</html>
