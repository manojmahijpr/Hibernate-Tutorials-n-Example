package com.Application.MainClass;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Application.DTO.User;

public class MainApp {

    public static void main(String...strings) {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	session.beginTransaction();
	
	String userId = "6";
	String userName = "User 10";
	
	
	//Positional Placeholder Substitution
	Query query = session.createQuery("from User where id > ? and name = ?");
	query.setInteger(0, Integer.parseInt(userId));
	query.setString(1, userName);
	List<User> posUsers = (List<User>) query.list();
	
	//Name Placeholder Substitution
	Query query1 = session.createQuery("from User where id > :id and name = :name");
	query1.setInteger("id", Integer.parseInt(userId));
	query1.setString("name", userName);
	List<User> namedUsers = (List<User>) query1.list();
	
	
	for(User user:posUsers) {
	    System.out.println(user);
	}
	
	for(User user:namedUsers) {
	    System.out.println(user);
	}
	
	
	session.getTransaction().commit();
	session.close();
	sessionFactory.close();
	
    }
}
