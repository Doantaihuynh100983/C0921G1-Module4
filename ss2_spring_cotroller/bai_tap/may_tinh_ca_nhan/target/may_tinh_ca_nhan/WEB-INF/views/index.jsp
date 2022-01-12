<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>The World Clock</title>
    <style type="text/css">
        select {
            width: 200px;
            height: 20px;
        }
    </style>
</head>
<body>

<form action="" method="post">
    <label for="number1">First name:</label><br>
    <input type="text" id="number1" name="number1" value="0"><br>
    <label for="number2">Last name:</label><br>
    <input type="text" id="number2" name="number2" value="0"><br><br>
    <input type="submit" value="Addition" name="calculation">
    <input type="submit" value="Subtraction" name="calculation">
    <input type="submit" value="Multipcation" name="calculation">
    <input type="submit" value="Division" name="calculation">
</form>

                <h1>${result}</h1>
                <h1>${message}</h1>
</body>
</html>