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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.Demo.model.Circle;

@Component
public class JdbcDaoImpl {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    
    @Autowired
    public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public DataSource getDataSource() {
	return dataSource;
    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void insertCircle(Circle circle) {
	
//	String sql = "insert into Circle (ID,NAME) values (?,?)";
//	jdbcTemplate.update(sql,new Object[] {circle.getId(),circle.getName()});
	
	String sql = "insert into Circle (ID,NAME) values (:id,:name)";
	SqlParameterSource namedParameters = new MapSqlParameterSource("id",circle.getId()).addValue("name", circle.getName());
	namedParameterJdbcTemplate.update(sql, namedParameters);
	
    }
    public int getCircleCount() {
	String query = "SELECT COUNT(id) FROM CIRCLE";
	return 1;
	
    }
    public String getCircleName(int circleId) {
	String sql = "SELECT NAME FROM CIRCLE WHERE ID = ?";
	return jdbcTemplate.queryForObject(sql, new Object[] { circleId }, String.class);
    }
    public void createTriangleTable() {
	String sql = "create table triangle (id integer,name varchar2(40))";
	jdbcTemplate.update(sql);
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
