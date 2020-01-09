package com.test.pojo;

public class Student {
    private  int id;
    private String name;
    private int age;
    private String tel;
    private String sex;

    public Student() {
    }

    public Student(String name, int age, String tel, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tel = tel;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTel() {
        return tel;
    }

    public String getSex() {
        return sex;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}



