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

@WebServlet("/QueryStuServlet")
public class QueryStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String id_s = request.getParameter("id");
        //学号不为空时，正常转换
        int id = 0;

        if(!("".equals(id_s))) {
            id = Integer.parseInt(request.getParameter("id"));
        }else {
            id = -1; //代表用户没填值
        }
        String name = request.getParameter("name");

        UserDaoInter userDao = new UserDao();
        List<Student> list = userDao.getStudentByName(id,name);


        request.setAttribute("id",id_s);
        request.setAttribute("name",name);
        request.setAttribute("list",list);//返回的表都叫list，前台页面读取名称为list
        request.getRequestDispatcher("Welcome.jsp").forward(request,response);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
