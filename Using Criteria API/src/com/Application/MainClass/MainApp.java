package com.Application.MainClass;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.Application.DTO.User;

public class MainApp {

    public static void main(String...strings) {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	session.beginTransaction();
	//Criteria & HQL Both Requires Class Specification not Database Table
	Criteria criteria = session.createCriteria(User.class);
	criteria.add(Restrictions.eq("name", "User 3"))
		.add(Restrictions.gt("id", 6));
	
	List<User> users = (List<User>)criteria.list();
	
	
	session.getTransaction().commit();
	session.close();
	sessionFactory.close();
	
	if(!users.isEmpty())
	for(User user:users) {
	    System.out.println(user);
	}
	else 
	    System.out.println("No Record Found");
    }
}
