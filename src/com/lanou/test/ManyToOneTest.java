package com.lanou.test;

import com.lanou.domain.Customer;
import com.lanou.domain.Order;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import util.HibernateUtil;

import java.util.Date;

/**
 * Created by dllo on 17/10/18.
 */
public class ManyToOneTest {

    @Test
    public void single(){
        //先创建用户对象
        Customer customer = new Customer("福鑫","xiuqin","1234","男");

        //创建订单对象
        Order order = new Order("001",1222,new Date());
        order.setCustomer(customer);//绑定订单所属的用户
        //保存用户以及订单对象
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        /*
        单项n-1,在进行n的插入是需要确定1已经保存到数据库,即1是一个持久化对象
        此实例中指的是插入订单时需要确保所属用户已经存在
         */
        session.save(customer);//保存用户
        session.save(order); //保存订单

        transaction.commit();
        HibernateUtil.closeSession();

    }

    /**查询订单所属的对象**/
    @Test
    public void singleFind(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //查找主键id为1的订单对象
        Order order = session.get(Order.class,1);
        System.out.println("订单的基础属性" + order);
       // System.out.println("订单所属用户的属性" + order.getCustomer());

        transaction.commit();
        HibernateUtil.closeSession();
    }

    /**双向1-n中的插入**/
    @Test
    public void doubleInsert(){
        //创建用户对象和订单对象
        Customer customer = new Customer("瑞超","瑞超超","123","男");
        Order order = new Order("002",1456,new Date());
        order.setCustomer(customer);//绑定订单所属的用户
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //保存用户与订单
        session.save(customer);
        session.save(order);

        transaction.commit();
        HibernateUtil.closeSession();
    }
    /**双向1-n查询用户下的所有订单集合**/
    @Test
    public void doubleFind(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //查找主键id=2的用户
        Customer customer = session.get(Customer.class,2);
        System.out.println("基础属性:" + customer);
        System.out.println("用户名下的订单:" + customer.getOrders());

        transaction.commit();
        HibernateUtil.closeSession();
    }
}
