<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: UnjlAms
  Date: 2017/8/10
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.0.js"></script>
</head>
<body>
success SpringMVC

<br>

username :${requestScope.per.username} <br>
images:${requestScope.per.image.originalFilename}

<br>

<a href="${pageContext.request.contextPath}/TestController/download?filename=${requestScope.per.image.originalFilename}">
    ${requestScope.per.image.originalFilename}
</a>





<%--name:${requestScope.stu.name} <br>--%>
<%--birth:${requestScope.stu.birth}--%>





<script type="text/javascript" >
    $(function () {
    })
</script>


</body>
</html>
