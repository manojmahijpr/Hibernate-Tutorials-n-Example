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
	Query queryPos = session.getNamedQuery("PosUser.byId");
	queryPos.setInteger(0, 5);
	List<User> posUsers = (List<User>) queryPos.list();
	
	//Name Placeholder Substitution
	Query queryNamed = session.getNamedQuery("NamedUser.byId");
	queryNamed.setInteger("id", 7);
	List<User> namedUsers = (List<User>) queryNamed.list();
	
	
	Query queryNativePos = session.getNamedNativeQuery("PosUserNative.byId");
	queryNativePos.setInteger(0, 2);
	List<User> posNativeUsers = (List<User>) queryNativePos.list();
	
	//Name Placeholder Substitution
	Query queryNativeNamed = session.getNamedNativeQuery("NamedUserNative.byId");
	queryNativeNamed.setInteger("id", 3);
	List<User> namedNativeUsers = (List<User>) queryNativeNamed.list();
	
	
	
	for(User user:posUsers) {
	    System.out.println(user);
	}
	
	for(User user:namedUsers) {
	    System.out.println(user);
	}
	
	for(User user:posNativeUsers) {
	    System.out.println(user);
	}
	for(User user:namedNativeUsers) {
	    System.out.println(user);
	}
	
	session.getTransaction().commit();
	session.close();
	sessionFactory.close();
	
    }
}
