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
import java.util.List;

@WebServlet("/GetAllServlet")//自动用注解在web.xml中注册servlet
public class GetAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //字符编码处理
        request.setCharacterEncoding("utf-8");
        //获取所有学生信息
        UserDaoInter userDaoInter = new UserDao();
        List<Student> list = userDaoInter.getAllstudent();
        //转发
        request.setAttribute("list",list);
        request.getRequestDispatcher("Welcome.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);//方法调用，doGet跳到doPost

    }
}
