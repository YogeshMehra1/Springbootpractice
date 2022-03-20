package com.yogesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class fetchdemo {
public static void main(String args[]) {
	//get //load
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	Session session=factory.openSession();
	//get student:106
	student st=(student)session.load(student.class, 102);
	System.out.println(st);
	
	Address ad=(Address)session.get(Address.class, 1);
	System.out.println(ad.getStreet()+" "+ad.getAddedDate());
	session.close();
	factory.close();
	
}
		

	}


