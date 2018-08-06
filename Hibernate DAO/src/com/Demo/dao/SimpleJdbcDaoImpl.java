package com.Demo.dao;



@SuppressWarnings("deprecation")
public class SimpleJdbcDaoImpl  {

    public int getCircleCount() {
	String query = "SELECT COUNT(*) FROM CIRCLE";
	return 1;

    }
}
