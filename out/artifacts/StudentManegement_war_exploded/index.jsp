<%--
  Created by IntelliJ IDEA.
  User: 雷耀宏
  Date: 2020/1/3
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户登陆</title>
    <link rel="stylesheet" href="bootstrap.min.css">

      <%--内部样式--%>
      <%--<style>
          /*设置背景图片*/
          body{

            background-image: url("bg.jpg");
            background-repeat: no-repeat;/*重复方式*/
            background-size:100% 100%;/*拉伸100%*/
            background-attachment: fixed;/*固定滚动*/
          }
      </style>--%>

  </head>
  <body>
  <div align="center">
    <h2 style="color: black">学生管理系统</h2>
    <form action="login" method="post">
      <h4 style="color: black">用户登录</h4>

      <table style="color: black;">
        <tr>
          <td>用户名：</td>
          <td><input type="text" name="username" class="input-sm"></td>
        </tr>
        <tr>
          <td>密码：</td>
          <td><input type="password" name="pwd" class="input-sm"></td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="submit" value="登陆" class="btn btn-primary">
            <a href="register.jsp">快速注册</a>
          </td>
        </tr>
      </table>

      <div>
        <div class="row form-group"><%--一行--%>
          <div class="col-md-5" align="right">
            <label>用户名:</label>
          </div>
          <div class="col-md-2">
            <input  type="text" class="form-control input-sm">
          </div>
        </div>
        <div class="row form-group">
          <div class="col-md-5" align="right">
            <label>密码:</label>
            </div>
          <div class="col-md-2">
            <input type="password" class="form-control input-sm">
          </div>
        </div>
      </div>
    </form>
   <div style="color:red;">${msg}</div>
  </div>
  </body>
</html>
