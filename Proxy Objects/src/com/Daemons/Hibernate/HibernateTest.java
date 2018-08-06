package com.Daemons.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Daemons.dto.Address;
import com.Daemons.dto.UserDetails;


public class HibernateTest {

    public static void main(String[] args) {
	
	UserDetails user = new UserDetails();
	user.setUserName("Manoj Sharma");
	
	Address homeAddress = new Address();
	homeAddress.setCity("Jaipur");
	homeAddress.setPincode(302033);
	homeAddress.setState("Rajasthan");
	homeAddress.setStreet("Pratap Nagar");
	
	
	Address officeAddress = new Address();
	officeAddress.setCity("Kota");
	officeAddress.setPincode(302080);
	officeAddress.setState("Rajasthan");
	officeAddress.setStreet("Borkheda");
	
	user.getAddressList().add(homeAddress);
	user.getAddressList().add(officeAddress);
	
	
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
	
	System.out.println("First Transaction Completed");
	
	//session.close();	// Close the Session when fetch type is Eager
	System.out.println(user.getAddressList().size());
	
	sessionFactory.close();
	System.out.println(user.getUserName());
	
    }

}
