package com.Daemons.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Daemons.dto.FourWheeler;
import com.Daemons.dto.TwoWheeler;
import com.Daemons.dto.UserDetails;
import com.Daemons.dto.Vehicle;


public class Main {

    public static void main(String[] args) {
	
	Vehicle vehicle = new Vehicle();
	vehicle.setVehicleName("Aston Martin");
	
	TwoWheeler bike = new TwoWheeler();
	bike.setVehicleName("Pulsar");
	bike.setSteeringHandle("Handle Type");
	
	FourWheeler car = new FourWheeler();
	car.setVehicleName("Porsche");
	car.setSteeringWheel("Porsche Steering Wheel");
	
	
	/*
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
	*/
	
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(vehicle);
	session.save(car);
	session.save(bike);
	session.getTransaction().commit();
	session.close();
	
	
	System.out.println("First Transaction Completed");
	
	//session.close();	// Close the Session when fetch type is Eager
	
	sessionFactory.close();
	
    }

}
