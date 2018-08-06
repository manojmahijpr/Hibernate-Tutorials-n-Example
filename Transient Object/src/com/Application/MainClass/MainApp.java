package com.Application.MainClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Application.DTO.User;

public class MainApp {

    public static void main(String...strings) {
	
	User user = new User();
	user.setName("Manoj Sharma");
	//Before session.save(user) user Object or table object is in Transient Form 
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	session.beginTransaction();
	
	session.save(user);
	// After session.save() its in Persistant form 
	user.setName("Deepak Sahu");
	
	user.setName("Hariom Sharma");
	
	//user 1 is in Persistent form because it is between Transaction
	User user1 = (User) session.get(User.class, 1);
	user1.setName("Kallu Kalia");
	
	/*
	 * After session.delete() we are moving from Persistent to Transient state of user object.
	 *  which means object user1 is deleted now and if we make any change in user1 its not 
	 *  going to be reflected
	 */
	
	//session.delete(user1);
	//user1.setName("Chota Bheem");
	//session.save(user1);
	
	/*
	 * But if we again do session.save(user1) then its again goint to save user object 
	 * but this ti,e with increment in Primary key because the State of Primary key is 
	 * changed session treates now this as new fresh object
	 */
	
	session.getTransaction().commit();
	user.setName("Rahul Sharma");
	
	session.close();
	//Now Detached
	sessionFactory.close();
	
    }
}
