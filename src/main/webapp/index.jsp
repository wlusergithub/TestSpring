<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script type="text/javascript" src="js/jquery-3.2.0.js"></script>

    <script type="text/javascript">
        $(function () {

            $("#SpringMVCJson").click(function () {
                var url = this.href;
                var args = {};
                $.post(url,args,function (data) {
                    alert(data.name+"----"+data.sex);
                    $("#div1").html(data.name+"-------"+data.sex);
                });

                return false;
            })
        })
    </script>

</head>
<body>
<h2>Hello Worlds!</h2>







<%--<div id="div1"></div>--%>
<%--<a href="${pageContext.request.contextPath}/TestController/testJson" id="SpringMVCJson">获取数据</a>--%>



<%--<form action="${pageContext.request.contextPath}/TestController/testRegister" method="post" enctype="multipart/form-data">--%>
    <%--file : <input type="file" name="image" /> <br>--%>
    <%--desc : <input type="text" name="username" /> <br>--%>
    <%--<input type="submit" value="提交" />--%>
<%--</form>--%>

<%--<a href="${pageContext.request.contextPath}/TestController/test">aaa</a>--%>

<%--<a href="${pageContext.request.contextPath}/TestController/test?i=0">test</a>--%>


<%--<a href="${pageContext.request.contextPath}/TestController/testResponse?i=10">test response</a>--%>

<%--<form action="${pageContext.request.contextPath}/TestController/testFileUpload" method="post" enctype="multipart/form-data">--%>
    <%--&lt;%&ndash;multiple 可同时上传多个文件&ndash;%&gt;--%>
    <%--file : <input type="file" name="file" /> <br>--%>
    <%--desc : <input type="text" name="desc" /> <br>--%>
    <%--<input type="submit" value="提交" />--%>
<%--</form>--%>





<%--<form action="${pageContext.request.contextPath}/TestController/formatter" method="post">--%>
    <%--<input type="text" name="name" value="li">--%>
    <%--&lt;%&ndash;<form:errors path="name"></form:errors>&ndash;%&gt;--%>
    <%--<br>--%>
    <%--<input type="text" name="birth" value="1996/7/7"> <br>--%>
    <%--<input type="submit" value="提交">--%>
<%--</form>--%>





<%--<a href="${pageContext.request.contextPath}/TestController/i18n?locale=en_US">英文</a>--%>
<%--<a href="${pageContext.request.contextPath}/TestController/i18n?locale=zh_CN">中文</a>--%>


<%--<form:form  modelAttribute="user" method="POST" action="/test"  >--%>
    <%--ID:<form:input path="id"/><br>--%>
    <%--Name:<form:input path="name"/><br>--%>
    <%--<input type="submit" value="submit">--%>
<%--</form:form>--%>

<%--<a href="${pageContext.request.contextPath}/test">aa</a>--%>



<%--<form:form action="${pageContext.request.contextPath}/demo/testForm" method="POST" modelAttribute="<command>" >--%>
    <%--<form:input path="username"></form:input> <br>--%>
    <%--<form:password path="password"></form:password> <br>--%>
    <%--<form:textarea path="textera"></form:textarea> <br>--%>
    <%--<form:radiobutton path="radio"></form:radiobutton>--%>
    <%--<input type="submit" value="提交">--%>
<%--</form:form>--%>

<%--<a href="${pageContext.request.contextPath}/demo/testForm">test form</a>--%>



<%--<a href="${pageContext.request.contextPath}/demo/testRedirect">test redirect</a>--%>

<%--<a href="${pageContext.request.contextPath}/demo/testView">test View</a>--%>



<%--<form action="${pageContext.request.contextPath}/demo/testModelAttri" method="post">--%>
    <%--<input type="hidden" name="id" value="1" /> <br>--%>
    <%--<input type="text" name="username" value="admin"><br>--%>
    <%--&lt;%&ndash;<input type="password" name="password" value="123"><br>&ndash;%&gt;--%>
    <%--<input type="submit" value="提交">--%>
<%--</form>--%>



<%--<a href="${pageContext.request.contextPath}/demo/testModelAndView">model</a>--%>

<%--<a href="${pageContext.request.contextPath}/demo/testMap">test map</a>--%>

<%--<a href="${pageContext.request.contextPath}/demo/testSessionAttr">test session</a>--%>

<%--<form action="${pageContext.request.contextPath}/demo/testPojo" method="post">--%>
    <%--username : <input type="text" name="username" /><br>--%>
    <%--password : <input type="password" name="password" /><br>--%>
    <%--city : <input type="text" name="address.city">--%>
    <%--provice : <input type="text" name="address.provice">--%>
    <%--<input type="submit" value="提交">--%>
<%--</form>--%>





<%--<a href="${pageContext.request.contextPath}/demo/welcome">hello world</a> <br>--%>

<%--<a href="${pageContext.request.contextPath}/demo/testCookie">cookis</a>--%>

<%--<a href="${pageContext.request.contextPath}/demo/testHeader">请求头</a>--%>

<%--<a href="${pageContext.request.contextPath}/demo/testParam?username=wuhan&password=123">requestParam</a>--%>


<%--<a href="${pageContext.request.contextPath}/demo/test/00211">PathVariable</a>--%>

<%--<br><br>--%>
<%--<form action="${pageContext.request.contextPath}/demo/test/" method="post">--%>
    <%--<input type="submit" value="POST"/>--%>
<%--</form>--%>

<%--<form action="${pageContext.request.contextPath}/demo/test/13" method="post">--%>
    <%--<input type="hidden" name="_method" value="DELETE">--%>
    <%--<input type="submit" value="DELETE"/>--%>
<%--</form>--%>

<%--<form action="${pageContext.request.contextPath}/demo/test/1222" method="post">--%>
    <%--<input type="hidden" name="_method" value="PUT">--%>
    <%--<input type="submit" value="PUT"/>--%>
<%--</form>--%>

</body>
</html>
