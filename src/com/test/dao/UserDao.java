package com.test.dao;

import com.mysql.jdbc.MySQLConnection;
import com.test.pojo.Myuser;
import com.test.pojo.Student;
import com.test.util.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//实现类implements，
public class UserDao implements UserDaoInter {
    DataBase dataBase = new DataBase();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;



    //登陆功能
    public boolean getLogin(Myuser myuser) {
        boolean flag = false;
        //标识登陆是否成功
        try{
            //打开数据库
            connection = dataBase.openConn();
            String sql = "SELECT * FROM `Myuser` u WHERE u.`name`=? and u.pwd=?";//'?'用来接收用户名和密码
            //创建prepared对象
            preparedStatement = connection.prepareStatement(sql);
            //为？赋值，对对象执行操作
            preparedStatement.setString(1,myuser.getName());
            preparedStatement.setString(2,myuser.getPwd());

            resultSet = preparedStatement.executeQuery();//执行sql语句
            //判断sql语句是否执行成功
            while (resultSet.next()){
                //登陆成功
                flag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            //关闭数据库连接
            dataBase.closeConn(connection,preparedStatement,resultSet);
        }
        return flag;
    }
    //新增学生方法
    public boolean addStudent (Student student){
        boolean flag = false;
        connection = dataBase.openConn();
        String sql = "INSERT INTO Student (name,age,tel,sex) VALUES(?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setString(3,student.getTel());
            preparedStatement.setString(4,student.getSex());
            int num = preparedStatement.executeUpdate();
            if (0 != num){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dataBase.closeConn(connection,preparedStatement,resultSet);
        }
        return flag;
    }

    @Override
    //查询方法
    public List<Student> getAllstudent() {
        List<Student> list = new ArrayList<Student>();

        String sql = "select id,name,age,tel,sex from `student`";
        connection = dataBase.openConn();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Student student = new Student() ;//创建学生对象
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setTel(resultSet.getString("tel"));
                student.setSex(resultSet.getString("sex"));
                System.out.println(student);
                //学生对象添加到list中
                list.add(student);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dataBase.closeConn(connection,preparedStatement,resultSet);
        }

        return list;
    }

    @Override//按学生id查找学生
    public Student getStudentByID(int id) {
        Student student = null;
        String sql = "select id,name,age,tel,sex from 'student' where id = ?";
        connection = dataBase.openConn();
        try {
            preparedStatement = connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setInt(1,id);
            //执行sql语句
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                student = new Student();
                student.setId(resultSet.getInt(1));//列索引
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                student.setTel(resultSet.getString(4));
                student.setSex(resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean editStudent(Student student) {
        boolean isEdit = false;
        String sql = "updata student set name=?,age=?,tel=?,sex=? where id =? ";

        connection = dataBase.openConn();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setString(3,student.getTel());
            preparedStatement.setString(4,student.getSex());
            preparedStatement.setInt(5,student.getId());

            if (preparedStatement.executeUpdate()>0){
                isEdit = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isEdit;
    }

    @Override//删除操作
    public boolean delStudent(int[] ids) {
        boolean isDelete = false;

        String sql = "delete from student where id in(" ;//删除语句拼接
        for(int i=0; i<ids.length; i++) {
            sql += "?";
            if(i != ids.length-1) {
                sql += ",";
            }
        }
        sql += ")"; //批量删除

        connection = dataBase.openConn();
        try {
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0; i<ids.length; i++){
                preparedStatement.setInt((i+1),ids[i]);
            }
            int num = preparedStatement.executeUpdate();
            if(num>0){
                isDelete = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dataBase.closeConn(connection,preparedStatement,null);
        }
        return isDelete;
    }

    @Override//按姓名查询
    public List<Student> getStudentByName(int id, String name) {
        List<Student> list = new ArrayList<Student>();
        String sql = "select * from student where 1=1 ";   //让where后面都能接
        if(name != null && !("".equals(name))){
            sql += "and name like ?"; //按名字查询
        }
        if (id != -1){
            sql += "and id = ?";
        }

        connection = dataBase.openConn();
        try {
            preparedStatement = connection.prepareStatement(sql);           //姓名和学号都填了
            if (name != null && !( "".equals(name)) && id != -1){
                preparedStatement.setString(1,"%"+name+"%");
                preparedStatement.setInt(2,id);
            }else if(name != null && !( "".equals(name)) && id == -1){      //姓名填了没填学号
                preparedStatement.setString(1,"%"+name+"%");
            }else if((name == null ||"".equals(name) )&& id != -1){         //姓名没填学号填了
                preparedStatement.setInt(1,id);
            }

            //执行sql
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                student.setTel(resultSet.getString(4));
                student.setSex(resultSet.getString(5));

                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dataBase.closeConn(connection,preparedStatement,resultSet);
        }

        return list;
    }

    @Override
    public boolean getUserByName(String name) {
        boolean isExist = false;

        String sql ="select * from myuser where name=?";
        connection = dataBase.openConn();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                isExist = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dataBase.closeConn(connection,preparedStatement,resultSet);
        }

        return isExist;
    }

    @Override
    public boolean addUser(Myuser myuser) {
        boolean isSuccess = false;
        String sql = "insert into myuser (name,pwd) value(?,?)";//有问题

        connection = dataBase.openConn();
        try {
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,myuser.getName());
            preparedStatement.setString(2,myuser.getPwd());
            int num = preparedStatement.executeUpdate();
            if (num != 0){
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dataBase.closeConn(connection,preparedStatement,resultSet);

        }
        return isSuccess;
    }


}