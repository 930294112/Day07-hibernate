package com.lanou.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/10/18.
 *
 */
public class Customer {
    private int id;
    private String name;//用户的名字
    private String loginName;//用户的登录名称
    private String password;//用户的登录密码
    private String gender;//用户的性别
    //定义该用户名下的订单集合
    private Set<Order> orders = new HashSet<>();

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Customer(String name, String loginName, String password, String gender) {
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.gender = gender;
    }

    public Customer() {
    }

    public Customer(int id, String name, String loginName, String password, String gender) {
        this.id = id;
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
