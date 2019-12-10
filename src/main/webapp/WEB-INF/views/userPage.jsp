<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
<h1>${result}</h1>

<form action="/test_project/update_form">
    <button type="submit" name="userId" value="${user.id}">Update</button>
</form>
<form action="/test_project/welcome">
    <button type="submit">Logout</button>
</form>
<form action="/test_project/delete" method="post">
    <button type="submit" name="userId" value="${user.id}">Delete</button>
</form>

</body>
</html>
