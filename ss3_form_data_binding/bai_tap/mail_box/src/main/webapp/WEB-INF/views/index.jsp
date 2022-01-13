<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h2>Hello World!</h2>
<h1 style="color: red">${flag}</h1>
<h1 style="color: red">${flagEdit}</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Languages</th>
        <th>Page Size</th>
        <th>Spam Fitter</th>
        <th>Signature</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${mailBoxList}" var="mailBoxList">
    <tr>
        <td>${mailBoxList.id}</td>
        <td>${mailBoxList.laguages}</td>
        <td>${mailBoxList.pageSize}</td>
        <td>${mailBoxList.spamfilter}</td>
        <td>${mailBoxList.signature}</td>
        <td>
           <button><a href="/vieweditMailbox/${mailBoxList.id}">Edit</a></button>
        </td>
    </tr>
    </c:forEach>

</table>
<button><a href="/viewAdd">Add new Mail Box</a></button>
</body>
</html>
