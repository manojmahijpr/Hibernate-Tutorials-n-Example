package com.Demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.Demo.model.Circle;

@Component
public class JdbcDaoImpl {

    @Autowired
    private DataSource dataSource;

    public Circle getCircle(int circleId) {

	Connection con = null;
	try {

	    con = dataSource.getConnection();

	    PreparedStatement ps = con.prepareStatement("SELECT * FROM Circle where id = ?");
	    ps.setInt(1, circleId);

	    Circle circle = null;

	    ResultSet rs = ps.executeQuery();

	    while (rs.next()) {
		circle = new Circle(circleId, rs.getString("name"));
	    }
	    rs.close();
	    ps.close();
	    return circle;
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    throw new RuntimeException(e);
	} finally {
	    try {
		con.close();
	    } catch (SQLException e) {

	    }
	}

    }

    public DataSource getDataSource() {
	return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
    }

}
