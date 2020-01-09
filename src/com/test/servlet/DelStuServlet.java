package com.test.servlet;

import com.test.dao.UserDao;
import com.test.dao.UserDaoInter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelStuServlet")
public class DelStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要删除的学生编号
        String ids = request.getParameter("ids");
        //把ids的字符串转换成数组
        //获取每一个学号
        String[]arr_ids = ids.split(",");
        //将数组中的数值转化成int类型
        int[] int_ids = new int[arr_ids.length];

        for(int i=0; i<arr_ids.length; i++){
            int_ids[i] = Integer.parseInt(arr_ids[i]);//字符串数组中每一个都转成int
        }
        //调用dao层
        UserDaoInter userDao = new UserDao();
        boolean isdelete = userDao.delStudent(int_ids);
        if(isdelete){
            response.sendRedirect("GetAllServlet");
        }

    }
}
