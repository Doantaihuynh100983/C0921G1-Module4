<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<form method="post" action="/currency">
    <label for="usd">USD:</label>
    <input type="text" id="usd" name="usd"><br><br>
    <input type="submit" value="Submit">
</form>

<h1>RESULT : ${result}</h1>
</body>
</html>