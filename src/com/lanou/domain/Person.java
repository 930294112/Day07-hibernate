package com.lanou.domain;

/**
 * Created by dllo on 17/10/18.
 * 用户表
 */
public class Person {
    private int id; //主键id
    private String name; //姓名
    private String password; //密码
    private IDCard idCard;//身份证号码

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Person() {

    }

    public Person(int id, String name, String password) {

        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
