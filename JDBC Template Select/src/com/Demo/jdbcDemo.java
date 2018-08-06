package com.Demo;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Demo.dao.JdbcDaoImpl;
import com.Demo.model.Circle;


public class jdbcDemo {

    public static void main(String...args) {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	JdbcDaoImpl dao = (JdbcDaoImpl) ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
	//Circle circle = (Circle)dao.getCircle(2);
	//System.out.println(circle.getName());
	//System.out.println(dao.getCircleCount());
	//System.out.println(circle.toString());
	//System.out.println(dao.getCircleName(2));
	
	List<Circle> circleList = dao.getAllCircle();
	System.out.println(circleList);
	/*for(int i=0;i<circleList.size();i++)
	    System.out.println(circleList.get(i).getName());*/
    }
}
