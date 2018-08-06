package com.Daemons.Hibernate;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Daemons.dto.UserDetails;

public class HibernateTest {

    public static void main(String[] args) {
	
	UserDetails user = new UserDetails();
	user.setUserId(1);
	user.setUserName("Manoj Sharma");
	user.setAddress("101 Raghunathpuri");
	user.setJoinedDate(new Date());
	user.setDescription("CEO Google");
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(user);
	session.getTransaction().commit();
	session.close();
	
	user=null;
	session = sessionFactory.openSession();
	session.beginTransaction();
	user = (UserDetails) session.get(UserDetails.class, 1);
	System.out.println(user.getUserName());
	
	String hql = "SELECT COUNT(*) FROM CIRCLE";
	Query query = session.createQuery(hql);
	
	System.out.println( (int) query.uniqueResult());
    }

}
