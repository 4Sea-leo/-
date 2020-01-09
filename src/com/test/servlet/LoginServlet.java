package com.test.servlet;

import com.test.dao.UserDao;
import com.test.pojo.Myuser;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //请求的处理
        //获取用户名和密码信息
        String name = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        //控制台测试用户名与密码是否获取正常
        //System.out.println(name);
        //System.out.println(pwd);

        //创建user对象
        Myuser myuser = new Myuser(name,pwd);
        UserDao userDao = new UserDao();

        //如果验证通过，跳转到欢迎页
        if (userDao.getLogin(myuser)) {
            //跳转到欢迎页
            //跳转方式 1 重定向
            //response.sendRedirect("Welcome.jsp");//改变浏览器访问路径
            //response与doPost中对应,""中填要跳转到的页面

            //session 对话
            //将用户名存储到session当中，在访问系统其他页面时都不会丢失
            //获取session对象
            //HttpSession session = request.getSession();
            ////将用户名存到session中
            //session.getAttribute("name",name);

            //方式2 转发
            //把用户名放到request对象中
            request.setAttribute("username",name);
            request.getRequestDispatcher("GetAllServlet").forward(request,response);
        }else{

            //跳转回登陆页面
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
