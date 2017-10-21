package com.lanou.test;

import com.lanou.domain.Customer;
import com.lanou.domain.Order;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/10/18.
 */
public class CascadeTest {
    /**cascade级联单元测试**/
    /**测试级联中的更新操作
     * 即修改用户的相关信息,查询该用户名下的订单对象 检查订单中的用户属性是否随之修改**/
    @Test
    public void cascadeUpdate(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //获得要修改的用户对象
        Customer customer = session.get(Customer.class,1);
        //修改用户信息
        customer.setName("鑫鑫");
        System.out.println("修改后的对象:" + customer);
        //获得用户id为1的订单,该订单为1
        Order order = session.get(Order.class,1);
        //获得订单的所属用户
        System.out.println("通过订单找用户:" + order.getCustomer());
        transaction.commit();
        HibernateUtil.closeSession();
    }
    @Test
    public void cascadeSave(){
        Session session= HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //创建用户和订单
        Customer customer = new Customer("桂桂啊","guigui","1234","男");
        Order order = new Order("003",15446,new Date());
        //将订单对象添加到用户中的订单集合
        customer.getOrders().add(order);

        //给订单对象绑定用户
        order.setCustomer(customer);

        session.save(order);
        //session.save(customer);

        transaction.commit();
        HibernateUtil.closeSession();
    }
    /**删除用户,一起将用户下的所有定单删除**/
    @Test
    public void cascadeDelete(){
        Session session= HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        //获得要删除的用户
        Customer customer = session.get(Customer.class,7);
//        //删除该用户名下的所有订单,将这些订单都删除,该用户才能删除
//        Query query = session.createQuery("from Order where customer=?");
//        query.setEntity(0,customer);
//        List<Order> orderList = query.list();
//        for (Order order : orderList) {
//            session.delete(order);//删除用户
//        }
        session.delete(customer);

        transaction.commit();
        HibernateUtil.closeSession();
    }
    //删除某个订单
    @Test
    public void deleteOrder(){
        Session session= HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        //过得要删除的订单
        Order order = session.get(Order.class,2);
        session.delete(order);
        transaction.commit();
        HibernateUtil.closeSession();

    }
}
