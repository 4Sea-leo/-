package com.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection conn = null;
        try{
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","980814");
        System.out.println("连接成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
        //关闭数据库
        try{
            assert conn != null;
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

