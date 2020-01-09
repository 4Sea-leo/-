package com.test.servlet;

import com.test.dao.UserDao;
import com.test.dao.UserDaoInter;
import com.test.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditStuServlet")
public class EditStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户请求数据
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String tel = request.getParameter("tel");
        String sex = request.getParameter("sex");//sex需要修改类型

        //封装student数据传给dao层
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setTel(tel);
        student.setSex(sex);

        //调用dao层
        UserDaoInter userDao = new UserDao();
        boolean isEdit = userDao.editStudent(student);
        if(isEdit){
            response.sendRedirect("GetAllServlet");
        }else {
            //如果更新失败，跳回编辑页面
            response.sendRedirect("edit.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
