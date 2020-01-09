package com.test.pojo;

public class Myuser {
    private String name;
    private String pwd;                                          //封装的思想

    public Myuser() {
    }

    public Myuser(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
