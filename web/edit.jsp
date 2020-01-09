<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 雷耀宏
  Date: 2020/1/6
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑学生信息页面</title>
</head>
<body>
<div align="center">
    <h4>修改学生信息</h4>
    <form action="" method="post">
        <table>
            <tr>
                <td>学号</td>
                <td><input type="text" name="id" value="${stu.id}" readonly></td><!---->
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" value="${stu.name}"></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" value="${stu.age}"></td>
            </tr>
            <tr>
                <td>电话</td>
                <td><input type="text" name="tel" value="${stu.tel}"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <c:if test = "${stu.sex == '0'}">
                        <input type="radio" name="sex" value="男">checked
                        <input type="radio" name="sex" value="女">女
                    </c:if>
                    <c:if test = "${stu.sex == '0'}">
                        <input type="radio" name="sex" value="男">男
                        <input type="radio" name="sex" value="女">checked
                    </c:if>
                    <input type="radio" name="sex" value="男">男
                    <input type="radio" name="sex" value="女">女
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="保存">
                    <input type="button" value="取消" onclick="javascript:location.href = 'GetAllServlet'">
                </td>
            </tr>
        </table>
    </form>

</div>

</body>
</html>
