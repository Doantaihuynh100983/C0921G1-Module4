<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<body>
<head>
    <title>Page Title</title>
</head>

<c:forEach items="${mailboxList}" var="mailboxList">

    <p>${mailboxList.languages}</p>
    <p>${mailboxList.size}</p>
    <p>${mailboxList.fillter}</p>
    <p>${mailboxList.signature}</p>
</c:forEach>



</body>

</html>
