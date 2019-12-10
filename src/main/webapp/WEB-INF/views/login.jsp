<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/test_project/authorization" method="post">
    <p>
        <input type="text" name="userName" placeholder="login" required>
    </p>
    <p>
        <input type="password" name="password" placeholder="password" required>
    </p>
    <p><span class="error"> ${requestScope.error.userName}</span></p>
    <input type="submit" value="sign in">
</form>
<form action="/test_project/registration_form">
    <input type="submit" value="sign up">
</form>
</body>
</html>
