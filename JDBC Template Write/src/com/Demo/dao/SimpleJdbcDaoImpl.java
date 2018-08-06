package com.Demo.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {

    public int getCircleCount() {
	String query = "SELECT COUNT(*) FROM CIRCLE";
	return this.getJdbcTemplate().queryForInt(query);

    }
}
