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

@WebServlet("/getStuByIDServlet")
public class getStuByIDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取学生编号
        String id_s = request.getParameter("id");
        int id = Integer.parseInt(id_s);
        //调用DAO层方法，获取学生对象
        UserDaoInter userDao = new UserDao();
        Student stu = userDao.getStudentByID(id);

        //资源跳转到编辑页面
        request.setAttribute("stu",stu);
        request.getRequestDispatcher("edit.jsp");


    }
}
