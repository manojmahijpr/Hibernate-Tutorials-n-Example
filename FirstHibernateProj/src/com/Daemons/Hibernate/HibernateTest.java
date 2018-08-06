package com.Daemons.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Daemons.dto.User;
import com.Daemons.dto.Details;

public class HibernateTest {

    public static void main(String[] args) {
	
	User user = new User();
	user.setId(7);
	user.setName("Manoj Sharma");
	
	Details details = new Details();
	details.setAge(19);
	details.setBranch("CSE");
	details.setMobile("121");
	user.setDetails(details);
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(user);
	session.getTransaction().commit();
	session.close();
	sessionFactory.close();
    }

}
