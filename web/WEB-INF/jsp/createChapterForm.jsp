<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF${pageContext.request.contextPath}/templateIncludes/headinclude.jsp"/>
<body>
<jsp:include page="/WEB-INF${pageContext.request.contextPath}/templateIncludes/navinclude.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h1>Use this to create new chapters</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <form action="${pageContext.request.contextPath}/createChapter" method="post" id="chapterform">
                <div class="form-group">
                    <label for="name">
                        <p>Name of the chapter:</p>
                        <input type="text" id="name" name="name">
                    </label>
                </div>
                <textarea name="chapterform" cols="30" rows="10" form="chapterform">

                </textarea>
                <br>
                <input type="submit" value="Create new chapter"/>
            </form>

        </div>
    </div>
</div>
</body>
</html>