package com.test.servlet;

import com.test.dao.UserDao;
import com.test.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStuServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String tel = req.getParameter("tel");
        String sex = req.getParameter("sex");


        Student student = new Student(name,age,tel,sex);
        UserDao userDao = new UserDao();

        userDao.addStudent(student);

        req.getRequestDispatcher("GetAllServlet").forward(req,resp);







;    }
}

