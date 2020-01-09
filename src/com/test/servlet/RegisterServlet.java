package com.test.servlet;

import com.test.dao.UserDao;
import com.test.dao.UserDaoInter;
import com.test.pojo.Myuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        //将name，pwd封装成MyUser对象

        Myuser myuser = new Myuser(name,pwd);
        //调用Dao层addUser
        UserDao userDao = new UserDao();
        userDao.addUser(myuser);


        request.setAttribute("msg","注册成功");
        request.getRequestDispatcher("index.jsp").forward(request,response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
