package com.lanou.test;

import com.lanou.domain.IDCard;
import com.lanou.domain.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import util.HibernateUtil;

/**
 * Created by dllo on 17/10/18.
 */
public class OneTwoOne {
     @Test
    public void save(){
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
         Person person = new Person("钊钊2","123");
         IDCard idCard = new IDCard("354668432");
         //设置对应关联属性
         person.setIdCard(idCard);
         idCard.setPerson(person);
//         1如果只保存idCard,需要设置IDCard.hbm.xml中的cascade级联属性
         //session.save(person);
         // session.save(idCard);

         // 2如果只保存Person,需要设置person.hbm.xml中的cascade级联属性
         //3维护外键的一方在不设置cascade级联时,保存单个对象时会抛出异常,而引用的一方不会抛出异常,只不过不保存级联对象
          session.save(person);
          //session.save(idCard);
            transaction.commit();
            HibernateUtil.closeSession();
        }
        @Test
        public void find(){
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Person person =session.get(Person.class,1);
            System.out.println(person);
            System.out.println("身份证号码:"+person.getIdCard());

            //查询某个身份证号码所属用户信息
            IDCard idCard = session.get(IDCard.class,1);
            System.out.println("基础属性:" + idCard);
            System.out.println("用户属性:" + idCard.getPerson());


           transaction.commit();
            HibernateUtil.closeSession();
        }
}
