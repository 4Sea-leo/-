<%--
  Created by IntelliJ IDEA.
  User: 雷耀宏
  Date: 2020/1/5
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增学生页面</title>
</head>
<body>
<script>
    function chkName() {
        //验证用户名是否填写
        var name = document.getElementById("name").value;

        if (name == ""){
            document.getElementById("massage").innerHTML="用户名必须填写";
            return false;
        }else {
            return true;
        }
    }
    function chkAge(input_age) {
        var age = input_age.value();//得到用户填写的值
        //判断用户填写的值是否是数字
        if (isNaN(age)) {
            document.getElementById("meg_age").innerHTML = "学生年龄必须是数字";
        }  //is not a number？是数字返回false
    }
</script>
<div align="center">
    <h4>学生新增</h4>
    <form action="addstu" method="post" onsubmit="return chkName()">
        <table align="center">
            <tr>
                <td><span style="color: red">*</span>学生姓名</td>
                <td>
                    <input type="text" name="name" id="name">
                </td>
                <td width="120px">
                    <span style="color: red" id="massage"></span>
                </td>
            </tr>
            <tr>
                <td>学生年龄</td>
                <td>
                    <input type="text" name="age" onblur="chkAge(this)">
                </td>
                <td width="120px">
                    <span style="color: red" ID="meg_age"></span>
                </td>
            </tr>
            <tr>
                <td>联系方式</td><td><input type="text" name="tel"></td>
                <td width="120px">
                    <span></span>
                </td>
            </tr>
            <tr>
                <td>学生性别</td>
                    <td colspan="2">
                        <input type="radio" name="sex" value="男" checked> 男
                        <input type="radio" name="sex" value="女"> 女
                    </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <input type="submit">
                    <input type="reset">
                </td>
            </tr>
        </table>
    </form>

        <select>
            <!--<select> 下拉框标签-->
            <option value="01">山东省</option>
        </select>

    <div style="color:red;">${msg}</div>
    </div>
</body>
</html>
