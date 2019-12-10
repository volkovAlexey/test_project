<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Form</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<form action="/test_project/update" method="post">
    <input type="hidden" name="userId" value="${user.id}">
    <p><input type="text" name="userName" value="${user.userName}" required>
        <span class="error"> ${requestScope.error.userName}</span></p>

    <p><input type="password" name="password" value="${user.password}" required></p>
    <p><input type="email" name="email" value="${user.email}" required>
        <span class="error"> ${requestScope.error.email}</span></p>

    <p><select id="country_id" name="country_id">
        <option disabled selected>Select Country</option>
        <c:forEach var="item" items="${list}">
            <option value="${item.id}">${item.name}</option>
        </c:forEach>
    </select></p>

    <p>
        <select id="regions_id" name="regionId">
            <option disabled selected>Select Region</option>
        </select>
    </p>

    <p>
        <input type="text" name="cityName" placeholder="City" required>
    </p>
    <input type="submit" value="sign in">
</form>

</body>
</html>

<script>
    $(document).ready(function () {
        $("#country_id").on("change", function () {
            var country_id = $("#country_id").val();//id of country select box of index.jsp page;
            $.ajax({
                url: "/test_project/regions",//your jsp page name
                data: {country_id: country_id},//sending request to state.jsp page.
                dataType: "json",
                method: "GET",//HTTP method.
                success: function (data) {
                    let region_id = $("#regions_id");
                    region_id.empty();
                    for (let i = 0; i < data.length; i++) {
                        region_id.append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
                    }
                }
            });
        });
    });
</script>