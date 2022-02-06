package maping;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneExm {
	
	
	 public static void AddEmpAdd(Session session,Transaction tx) {
		 Employee1 emp=new Employee1();
		 emp.setEmpName("wali");
		 emp.setEmpMail("wali@gmail.com");
		 
		 Address addr=new Address();
		 
		 addr.setStreet("khajpura");
		 addr.setCity("patna");
		 addr.setPincode(800014);
		 addr.setEmployee(emp);
		 
		 emp.setAddress(addr);
		 session.save(emp);
		 tx.commit();
		 session.close();
		 System.out.println("data save");
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( "Hello World!" );
	       
        Configuration cfg = new Configuration().configure();
        
        SessionFactory sf= cfg.buildSessionFactory();  
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();
        Scanner sc=new Scanner(System.in);
       
        System.out.println("enter 1 for insert 2 for delete");
        int ch =sc.nextInt();
        
        switch (ch) {
		case 1: AddEmpAdd(session, tx);
				break;
		case 2:
				break;
		default:System.out.println("invalid choice");
			break;
		}
        
        
  	   
//  	   Employee1 emp = new Employee1();
//  	   emp.setEmpName("Ankit");
//  	   emp.setEmpMail("ankit@gmail.com");
//  	  
//  	   Address  addr  = new Address();
//  	   addr.setStreet("street no 1");
//  	   addr.setCity("delhi");
//  	   addr.setPincode(110032);
//  	   addr.setEmployee(emp);
//  	   
//  	   emp.setAddress(addr);
//  	   session.save(emp);
//  	   tx.commit();
//  	   session.close();
//  	   System.err.println("worke done..");

	}
}
