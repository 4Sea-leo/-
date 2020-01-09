package com.test.util;

import java.sql.*;

/*
 *
 * 打开和关闭数据库
 *
 */
public class DataBase {
    //打开数据库
    public Connection openConn(){
        Connection connection = null;
        //加载驱动
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","980814");
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;


    }
    //关闭数据库
    //关闭数据库原则：先打开后关闭
    public void closeConn(Connection conn, PreparedStatement preparedStatement, ResultSet resultSet){
        try{
            if (null != resultSet){
                resultSet.close();
            }
            if(null != preparedStatement){
                preparedStatement.close();
            }
            if (null != conn){
                conn.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
