package com.Demo;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Demo.dao.JdbcDaoImpl;
import com.Demo.dao.SimpleJdbcDaoImpl;
import com.Demo.model.Circle;


public class jdbcDemo {

    public static void main(String...args) {

	int circleId = 4;
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//	JdbcDaoImpl dao = (JdbcDaoImpl) ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
//	dao.insertCircle(new Circle(circleId,"Fourth Circle"));
//	System.out.println(dao.getCircleName(circleId));
//	
	SimpleJdbcDaoImpl dao = (SimpleJdbcDaoImpl) ctx.getBean("simpleJdbcDaoImpl",SimpleJdbcDaoImpl.class);
	System.out.println(dao.getCircleCount());
	
    }
}
