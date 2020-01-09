<%--
  Created by IntelliJ IDEA.
  User: 雷耀宏
  Date: 2020/1/8
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>

<script>
    function chk_pwd() {
        //获取密码
        var pwd = document.getElementById("pwd").value;
        var pwd_c = document.getElementById("pwd_c").value;

        //alert(pwd.length) 可以获取密码长度

        if(pwd != pwd_c){
            document.getElementById("msg").innerHTML = "输入的密码不一致";
            return false;
        }else {
            document.getElementById("msg").innerHTML = "";
            return true;
        }
    }
    function creatXml() {
        //用来创建ajax依赖的一个对象
        try{
            return new XMLHttpRequest();
        }catch (e) {
            try{
                return new ActiveXObject("Microsoft.XMLHttp");
            }catch (e) {
                alert("浏览器版本过低")
            }
        }
    }
    function chk_name() {
        var username = document.getElementById("username").value;
        //ajax访问后台，局部刷新，页面其他位置不会发生变化
        var xmlh = creatXml();

        xmlh.open("get","ExistServlet?username="+username,true);

        xmlh.send(null);

        var isTrue = true;//监听用户名是否通过

        xmlh.onreadystatechange = function () {
            //后台状态码发生变化，就会进入func
            if(xmlh.readyState == 4 && xmlh.status == 200){//后台代码200表示成功
                //后台执行结束并执行正确
                var msg = xmlh.responseText;
                document.getElementById("name_msg").innerHTML = msg;//后台响应文本转到前台
                if(msg == "用户名已被占用"){
                    isTrue = false;
                }
            }
        }
        return isTrue;
    }
    function chk() {
        //提交前的验证
        if(chk_pwd() == true && chk_name() == true){
            return true;
        }else{
            return false;
        }
    }
</script>

<body>
<div align="center">
    <h3>用户注册</h3>
    <hr width="800px">
    <form action="RegisterServlet" method="post" onsubmit="chk()">
        <table>
            <tr>
                <td align="center">用户名</td>
                <td><input type="text" name="username" onblur="chk_name()" id="username"></td>
                <td width="200px">
                    <span id="name_msg" style="color: red"></span>
                </td>

            </tr>
            <tr>
                <td align="center">密码</td>
                <td><input type="password" name="pwd" id="pwd"></td>
                <td width="200px">
                    <span></span>
                </td>
            </tr>
            <tr>
                <td align="center">确认密码</td>
                <td><input type="password" name="pwd_c" id="pwd_c" onblur="chk_pwd()"></td>
                <td width="200px">
                    <span id="msg" style="color: red"></span>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="注册">
                    <input type="button" value="取消" onclick="javascript:location.href='login.jsp'">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
