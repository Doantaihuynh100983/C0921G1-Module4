<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 1/11/2022
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/updateKhachHang">
    <fieldset>
        <legend>Customer Information</legend>
        <table>
            <tr>
                <td>Id</td>
                <td>
                    <input type="text" name="id" value="${khachHang.id}">

                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" value="${khachHang.name}">
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <input type="text" name="email" value="${khachHang.email}">
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>
                    <input type="text" name="address" value="${khachHang.adress}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button  type="submit" value="Update">Update</button>
                </td>
            </tr>
        </table>
    </fieldset>

</form>
</body>
</html>
