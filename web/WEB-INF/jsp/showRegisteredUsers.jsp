<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF${pageContext.request.contextPath}/templateIncludes/headinclude.jsp"/>
<body>
<jsp:include page="/WEB-INF${pageContext.request.contextPath}/templateIncludes/navinclude.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h1>Registered Users:</h1>
        </div>
    </div>

    <div class="row">
        <table>
            <c:forEach items="${deserializedUsers}" var="user">
                <tr>
                    <td>UserName: <c:out value="${user.username}"/></td>
                    <td>UserPassword: <c:out value="${user.password}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>


</div>
</body>
</html>
