<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
${pageContext.request.requestURL}
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h1>Welcome</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <h2>Sign in </h2>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <form action="${pageContext.request.contextPath}/signin" method="post">
                <div class="form-group">
                    <label for="name">
                        <p>Username:</p>
                        <input type="text" id="name" name="name">
                    </label>
                </div>
                <div class="form-group">
                    <label for="password">
                        <p>Passwort</p>
                        <input type="password" id="password" name="password"></label></div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="anmelden">
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            Don't have an account yet? click <a href="${pageContext.request.requestURI}signup">here</a> to sign up.
        </div>
    </div>
</div>
</body>
</html>