<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>TỜ Khai Y Tế</h1>
<p style="color: green">${flagThongBao}</p>
<form:form modelAttribute="medical"  action="/addMedical" method="post">
    <table>
        <tr>
            <td><form:label path="hoTen"> Họ Tên: </form:label></td>
            <td><form:input path="hoTen"/></td>
        </tr>
        <tr>
            <td><form:label path="ngaySinh"> Ngày Sinh: </form:label>
                <form:input path="ngaySinh" type="date"/>
            </td>
            <td><form:label path="gioiTinh"> Giới Tính: </form:label>
                <form:radiobutton path="gioiTinh" value="1"/>Nam
                <form:radiobutton path="gioiTinh" value="0"/>Nữ
            </td>

            <td>
                <form:label path="quocTich"> Quốc Tịch: </form:label>
                <form:select path="quocTich" items="${listQuocTich}" />
            </td>
        </tr>
        <tr>
            <td><form:label path="cmnd"> Số hộ chiếu hoặc Cmnd: </form:label></td>
            <td><form:input path="cmnd"/></td>
        </tr>
<%--        <tr>--%>
<%--            <td><form:label path="thongTinDiLai"> Thông Tin Đi Lại: </form:label></td>--%>
<%--            <td><form:radiobuttons path="thongTinDiLai" items="${thongTinDiLai}" /></td>--%>
<%--        </tr>--%>
        <tr>
            <td><form:label path="soHieuPhuongTien"> Số Hiệu Phương Tiện: </form:label></td>
            <td><form:input path="soHieuPhuongTien" /></td>
        </tr>
        <tr>
            <td><form:label path="soGhe"> Số Ghế : </form:label></td>
            <td><form:input path="soGhe" /></td>
        </tr>
        <tr>
            <td><form:label path="ngayKhoiHanh"> Ngày Khởi Hành: </form:label></td>
            <td><form:input path="ngayKhoiHanh" type="date"/></td>
        </tr>
        <tr>
            <td><form:label path="ngayKetThuc"> Ngày Kết Thúc: </form:label></td>
            <td><form:input path="ngayKetThuc" type="date"/></td>
        </tr>
        <tr>
            <td><form:label path="thongTin14Ngay"> Trong 14 Ngày Có Đi Đâu </form:label></td>
            <td><form:input path="thongTin14Ngay"/></td>
        </tr>

        <tr>
            <td><form:label path="tinhThanh"> Tỉnh Thành: </form:label>
                <form:select path="tinhThanh" items="${tinhThanh}" />
            </td>
            <td><form:label path="quanHuyen"> Quận Huyện: </form:label>
                <form:select path="quanHuyen" items="${quanHuyen}" />
            </td>
            <td><form:label path="phuongXa"> Phường Xã: </form:label>
                <form:select path="phuongXa" items="${phuongXa}" />
            </td>
        </tr>

        <tr>
            <td><form:label path="diaChiNoiO">Địa Chỉ Nơi Ở: </form:label></td>
            <td><form:input path="diaChiNoiO"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="dienThoai">Điện Thoại: </form:label>
                <form:input path="dienThoai"/>
            </td>
            <td>
                <form:label path="email">Email: </form:label>
                <form:input path="email"/>
            </td>

        </tr>
        <tr>
            <td><form:label path="trieuChung"> Triệu Chứng: </form:label></td>
            <td>
                <table style=" width: 100%;">
                    <tr>
                        <c:forEach items="${trieuChung}" var="trieuChung">

                            <th style="font-size: 10px">
                                <p>${trieuChung}</p>
                                <form:checkbox path="trieuChung" value="Có"/>
                            </th>
                        </c:forEach>

                    </tr>
                </table>

            </td>
        </tr>
    </table>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>
