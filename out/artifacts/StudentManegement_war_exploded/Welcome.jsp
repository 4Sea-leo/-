<%--
  Created by IntelliJ IDEA.
  User: 雷耀宏
  Date: 2020/1/3
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" href="bootstrap.min.css">
        <title>欢迎首页</title>
        <script>
            //新增按钮
            function addStu() {
                location.href='add.jsp';
            }
            //修改按钮
            function editStu() {
                //判断用户是否选择了要编辑的记录
                var chks = document.getElementsByName("chk");
                var count = 0;//记录选中的用户数
                var index = 0; //被选中的序号
                //判断选中了哪个复选框
                for(var i=0; i<chks.length;i++){
                    if(chks[i].checked == true ){
                        count++;
                        index = i;
                    }
                }
                //判断选择的记录是否符合要求
                if(count == 0){
                    alert("请选择要编辑的记录")
                }else if(count > 1){
                    alert("只能选择一条记录进行编辑")
                }else {
                    //编辑操作
                    //获取一个学生的学号
                    var id = chks[index].value;
                    alert(id);

                    //调用GetStuID编辑学生
                    window.location.href = "getStuByIDServlet?id="+id;
                    location.href = 'edit.jsp'
                }
            }
            //删除按钮
            function delStu() {
                var ids = "";
                //获取所有复选框查看是否选择了相应的记录
                var chks = document.getElementsByName("chk");
                for (var i=0; i<chks.length; i++)
                    if (chks[i].checked == true){
                        //获取被选中的学号
                        ids += chks[i].value;   //拼接学号
                        ids += ","      //分隔学号
                    }
                if(ids == ""){
                    alert("请选择要删除的记录")
                }else {
                    if(confirm("确定删除")){
                        //调用后台进行操作
                        window.location.href = "DelStuServlet?ids=" + ids;//双引号内不加空格

                    }
                }
            }
            //全选框功能
            function checkAll() {
                //获取全选框
                var node = document.getElementById("chkAll");
                //获取记录前的复选框
                var chks = document.getElementsByName("chk");

                if(node.checked){//全选框被选中
                    for (var i=0; i<chks.length; i++){
                        chks[i].checked = true;//
                    }
                }else{
                    for (var i=0; i<chks.length; i++){
                        chks[i].checked = false;//
                    }
                }
            }
            //其他选择框控制全选框    //需要修改
            function unchk(chk_s) {
                //获取全选纽
                var chkall = document.getElementById("chkAll");
                if(chk_s.checked == false){ //当前选择框没被选中
                    chkall.checked = false  //全选框也不被选中
                }else {
                    var chks = document.getElementsByName("chk");
                    var isAll = true;   //标记目前是否全选
                    for(var i=0; i<chks.length; i++){
                        if(chks[i].checked == false){
                            isAll = false;
                            break;
                        }
                    }
                    chkall.checked = isAll;
                }
            }
        </script>
    </head>

    <body>
    <div align="center">
        <h3>欢迎 ${username} 登陆学生管理系统</h3>
        <form action="QueryStuServlet" method="post">
            学号：<input type="text" size="10px" name="id" placeholder="请输入学号" value="${id}" class="input-sm">
            姓名：<input type="text" size="10px" name="name" placeholder="请输入姓名" value="${name}" class="input-sm">
            <input type="submit" value="查询">
        </form>
        <input type="button" value="新增" onclick="addStu()" class="btn btn-primary btn-danger">
        <input type="button" value="编辑" onclick="editStu()" class="btn btn-primary btn-warning">
        <input type="button" value="删除" onclick="delStu()" class="btn btn-primary btn-default">
    <div align="center">
        <table style="width:70% " class="table table-bordered table-hover table-striped">
            <tr>
                <td align="center">
                    <input type="checkbox" onclick="checkAll()" id="chkAll">
                </td>
                <td>学号</td>
                <td>姓名</td>
                <td>年龄</td>
                <td>联系方式</td>
                <td>性别</td>
            </tr>

            <c:forEach items="${list}" var="stu">
                <tr>
                    <td><input type="checkbox" value="${stu.id}" name="chk" onclick="unchk(this)"></td>
                    <td>${stu.id}</td>
                    <td>${stu.name}</td>
                    <td>${stu.age}</td>
                    <td>${stu.tel}</td>
                    <td>${stu.sex}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </div>
    </body>
</html>
