package com.Demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Demo.dao.JdbcDaoImpl;
import com.Demo.model.Circle;


public class jdbcDemo {

    public static void main(String...args) {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	JdbcDaoImpl dao = (JdbcDaoImpl) ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
	Circle circle = (Circle)dao.getCircle(1);
	System.out.println(circle.getName());
    }
}
