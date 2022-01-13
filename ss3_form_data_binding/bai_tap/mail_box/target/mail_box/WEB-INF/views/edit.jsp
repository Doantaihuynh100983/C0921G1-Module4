<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 1/13/2022
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit New MailBox</h1>
<form:form modelAttribute="mailBox"  action="/editMailBox" method="post">
    <table>
        <tr>
            <td><form:label path="id"> ID: </form:label></td>
            <td><form:input path="id"/></td>
        </tr>

        <tr>
            <td><form:label path="laguages"> Languages: </form:label></td>
            <td><form:select path="laguages" items="${languages}"/></td>
        </tr>
        <tr>
            <td><form:label path="pageSize"> Page Size: </form:label></td>
            <td><form:select path="pageSize" items="${pageSizeList}"/></td>
        </tr>
        <tr>
            <td><form:label path="spamfilter"> Spam Filter: </form:label></td>
            <td><form:checkbox path="spamfilter"/>Enale spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature"> Signature: </form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
