<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="/sandwich"  method="post">
    <input type="checkbox" id="vehicle1" name="vehicle" value="Lettuce">
    <label for="vehicle1"> Lettuce</label><br>
    <input type="checkbox" id="vehicle2" name="vehicle" value="Tomato">
    <label for="vehicle2"> Tomato</label><br>
    <input type="checkbox" id="vehicle3" name="vehicle" value="Mustard">
    <label for="vehicle3"> Mustard</label><br><br>
    <input type="checkbox" id="vehicle4" name="vehicle" value="Sprouts">
    <label for="vehicle4"> Sprouts</label><br><br>
    <input type="submit" value="Submit">
</form>

<h1>Bạn Đã Chọn</h1>
<c:forEach items="${sanwich}" var="i">
    <p>${i}</p>
</c:forEach>
</body>
</html>