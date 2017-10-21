package com.lanou.domain;

import java.util.Date;

/**
 * Created by dllo on 17/10/18.
 * 订单的实体类
 */
public class Order {
    private int id;
    private String orderNumber;//订单编号
    private float price;
    private Date startDate;
    private Customer customer;//该订单所属的用户

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order() {
    }

    public Order(String orderNumber, float price, Date startDate) {
        this.orderNumber = orderNumber;
        this.price = price;
        this.startDate = startDate;
    }

    public Order(int id, String orderNumber, float price, Date startDate) {

        this.id = id;
        this.orderNumber = orderNumber;
        this.price = price;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", customer=" + customer +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
