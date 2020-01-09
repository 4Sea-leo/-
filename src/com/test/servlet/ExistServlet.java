package com.test.servlet;

import com.test.dao.UserDao;
import com.test.dao.UserDaoInter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ExistServlet")
public class ExistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //前台用了get方法
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("username");
        UserDaoInter  userDao = new UserDao();
        boolean isExist = userDao.getUserByName(name);


        if(isExist){
            //不能转发不能重定向告诉用户
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().print("用户名已被占用");
        }else {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().print("用户名可以使用");
        }

    }
}
