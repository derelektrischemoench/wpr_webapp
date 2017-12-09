<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 16/11/17
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../templateIncludes/headinclude.jsp"/>
<body>
<jsp:include page="../templateIncludes/navinclude.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            ${message}<br>
                <h1>EXCEPTION!!!</h1>
            ${exceptionMessage}
        </div>
    </div>
</div>

</body>
</html>
