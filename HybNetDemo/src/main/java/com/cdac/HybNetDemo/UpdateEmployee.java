package com.cdac.HybNetDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class UpdateEmployee {
	
	public static void updateUsingMerge(Session session,Transaction tx) {
		Employee emp=new Employee();
	
		emp.setEname("wali");
		emp.setEpassword("1234");
		session.save(emp);
		
		session.evict(emp);
		emp.setEname("waliur");
		emp.setEpassword("23fsf");
		Employee empmgr=(Employee)session.merge(emp);
		tx.commit();
	}
	
	public static void fetchCriteria(Session session,Transaction tx) {
		Criteria ctr=session.createCriteria(Employee.class);
		List<Employee> emplist=ctr.list();
		System.out.println("id \t name \t password");
		System.out.println("=====================================");
		for(Employee emp:emplist) {
			System.out.println(emp.getEid()+"|\t"+emp.getEname()+"|\t"+emp.getEpassword());
			System.out.println("----------------------------------");
		}
		tx.commit();
	}

	public static void updateEmployeeUsingTransientUpdate(Session session , Transaction tx) {
		   Employee e = new Employee();
		   e.setEid(13);
		   e.setEname("Pranshun");
		   session.update(e);
		   tx.commit();
		}
	
	public static void updateEmployeeUsingPersistentUpdate(Session session , Transaction tx) {
		  Employee emp= session.get(Employee.class,13);
		  if(emp!=null) {
			  emp.setEname("Pintola");
			  emp.setEpassword("28384");
			  session.update(emp);
			  tx.commit();
		  }
		}
	public static void updateEmployeeUsingUpdateAndSave(Session session , Transaction tx) {
		 Employee e = new Employee();
		  e.setEid(10);
		  e.setEname("junior g");
		  e.setEpassword("sismsim");
		  session.saveOrUpdate(e);
		  tx.commit();
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure();
		SessionFactory sf=  cfg.buildSessionFactory();
		Session  session = sf.openSession();
		Transaction tx = session.beginTransaction();
		 
		int ch;
		do {
			Scanner  sc = new Scanner(System.in);
	        System.out.println("enter to 1 to udate using merge");
	        System.out.println("enter 2 to update using update ");
	        System.out.println("enter 3 to update persistent object");
	        System.out.println("enter 4 to save or  update object");
	        System.out.println("enter 5 to view data");
	        ch = sc.nextInt();
	        switch (ch) {
			case 1:
				updateUsingMerge(session, tx);
				break;
			case 2:
				 updateEmployeeUsingTransientUpdate(session, tx);
				break;
			case 3:
				 updateEmployeeUsingPersistentUpdate(session, tx);
				break;
			case 4:
				 updateEmployeeUsingUpdateAndSave(session, tx);
				break;
			case 5:
				fetchCriteria(session, tx);
				break;
			case 6:break;
	        }
		}while(ch!=6);
	}
}