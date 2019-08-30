<%--
  Created by IntelliJ IDEA.
  User: rainbow
  Date: 2019-08-28
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
success
<form action="${pageContext.request.contextPath}/file" method="post" enctype="multipart/form-data">
    <input type="text" name="name"><br>
    <input type="file" name="uploadFile"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
