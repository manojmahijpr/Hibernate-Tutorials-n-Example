package com.Demo;

import com.Demo.dao.JdbcDaoImpl;
import com.Demo.model.Circle;

public class jdbcDemo {

    public static void main(String...args) {
	
	Circle circle = (Circle)new JdbcDaoImpl().getCircle(1);
	if(!circle.equals(null))
	System.out.println(circle.getName());
    }
}
