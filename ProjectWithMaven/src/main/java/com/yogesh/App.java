package com.yogesh;

import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("program stated!");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		//creating Student
		student st = new student();
		st.setId(103);
		st.setName("dvd");
		st.setCity("haldwani");
		System.out.println(st);
		//creating object of address class
		Address ad=new Address();
		ad.setStreet("street1");
		ad.setCity("haldwani");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(12355);
		//reading image
		FileInputStream fis=new FileInputStream("src/main/java/yogesh.jpg");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("Done....");

	}
}
