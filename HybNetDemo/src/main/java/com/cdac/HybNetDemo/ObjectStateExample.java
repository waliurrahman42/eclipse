package com.cdac.HybNetDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObjectStateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg= new Configuration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Employee emp= new Employee();
		emp.setEname("wali");
		session.save(emp);
		
		if(session.contains(emp)==true) {
			System.out.println("object is attached to session");
		}
		else {
			System.out.println("object is transist");
		}
		session.close();
		emp.setEname("ramu");
		session.save(emp);
		if(session.isOpen()==false) {
			System.out.println(session.contains(emp));
		}
	}

}
