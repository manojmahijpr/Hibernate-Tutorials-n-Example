package com.Application.MainClass;

import java.util.List;
import java.util.Map;

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
	
	Query query = session.createQuery("from User");
	List<User> users = (List<User>) query.list();
	
	Query query1 = session.createQuery("Select name from User");
	List<String> userNames = (List<String>) query1.list();
	
	Query query2 = session.createQuery("select new max(id) from User");
	List<Map<String,String>> userMap= (List<Map<String, String>>) query2.list();
	
	Query query3 = session.createQuery("Select name from User");
	List<Integer> Max = (List<Integer>) query3.list();
	
	
	session.getTransaction().commit();
	session.close();
	sessionFactory.close();
	
	for(User user : users) {
	    System.out.println(user);
	}
	
	for(String userName : userNames) {
	    System.out.println(userName);
	}
	
	/*for(Map<Integer,String> usermap : userMap) {
	    System.out.println(usermap.get("id"));
	    System.out.println(usermap.get("name"));
	    
	}*/
	
	for(int i=0;i<userMap.size();i++){

	        Map<String,String> map=userMap.get(i);

	        System.out.println(map.get("liscense"));
	        System.out.println(map.get("name"));
	    }
	
    }
}
