package com.Demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.Demo.model.Circle;

@Component
public class JdbcDaoImpl {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    
    public int getCircleCount() {
	String query = "SELECT COUNT(*) FROM CIRCLE";
	return jdbcTemplate.queryForInt(query);

    }

    public String getCircleName(int circleId) {

	// String sql = "SELECT NAME FROM CIRCLE WHERE ID = 1";
	// return jdbcTemplate.queryForObject(sql, String.class);

	// String sql = "SELECT NAME FROM CIRCLE WHERE ID = " + circleId;
	// return jdbcTemplate.queryForObject(sql , String.class);

	String sql = "SELECT NAME FROM CIRCLE WHERE ID = ?";
	return jdbcTemplate.queryForObject(sql, new Object[] { circleId }, String.class);

    }

    public DataSource getDataSource() {
	return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

    public Circle getCircle(int circleId) {
	
	String sql = "SELECT * FROM CIRCLE WHERE ID = ?";
	return jdbcTemplate.queryForObject(sql, new Object[] {circleId} , new CircleMapper());
    }

    public List<Circle> getAllCircle() {
	String sql = "SELECT * FROM CIRCLE";
	return jdbcTemplate.query(sql , new CircleMapper());
	
    }
    private static final class CircleMapper implements RowMapper<Circle> {

	@Override
	public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	    
	    Circle circle = new Circle();
	    circle.setId(resultSet.getInt("ID"));
	    circle.setName(resultSet.getString("NAME"));
	    return circle;
	}

    }

}
