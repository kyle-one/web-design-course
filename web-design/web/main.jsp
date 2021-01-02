<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/12/28
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/GetStaffByINPDServlet">
    <input type="text" name="did">
    <input type="text" name="dname">
    <input type="text" name="id">
    <input type="text" name="name">
    <input type="submit">提交
</form>
</body>
</html>
