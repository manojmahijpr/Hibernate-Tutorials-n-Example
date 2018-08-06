package com.Demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Demo.model.Circle;


public class JdbcDaoImpl {

    public Circle getCircle(int circleId) {
	
	Connection con = null;
	Circle circle = null;
	try {
	    
	    Class.forName("oracle.jdbc.driver.OracleDriver");	//Derby Driver
	    
	    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","spring","1234");
	    
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM Circle where id = ?");
	    ps.setInt(1, circleId);
	    
	    
	    
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()) {
		circle  = new Circle(circleId,rs.getString("name"));
	    }
	    rs.close();
	    con.close();
	    
	} catch (ClassNotFoundException | SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}	
	
	return circle;
    }
    
}
