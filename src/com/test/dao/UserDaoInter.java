package com.test.dao;

import com.test.pojo.Myuser;
import com.test.pojo.Student;

import java.util.List;

/*
 *用户接口声明
 * 声明用户的一些方法
 */
public interface UserDaoInter {
    //登陆功能
    boolean getLogin(Myuser myuser);
    //学生新增功能
    boolean addStudent (Student student);
    //学生查询展示功能
    List <Student> getAllstudent();/*
                                    *<>中与pojo对应
                                    *（）中不需要填写参数，前台页面没有请求
                                    */
    //根据学号查询学生信息
    Student getStudentByID(int id );

    //修改学生信息
    boolean editStudent(Student student);

    //删除学生信息
    boolean delStudent(int[] ids);//与前台发的类型对应

    //根据条件查询学生信息
    List<Student> getStudentByName(int id,String name);

    //查询用户名是否被占用
    boolean getUserByName(String name);

    //新增一个账号
    boolean addUser (Myuser myuser);
}
