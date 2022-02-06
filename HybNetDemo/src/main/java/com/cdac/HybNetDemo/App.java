package com.cdac.HybNetDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void adddata(Scanner sc,Session session, Transaction tx) {
		System.out.println("enter name");
		String name =sc.next();
		System.out.println("enter password");
		String pass =sc.next();
		Employee emp = new Employee();
		emp.setEname(name);
        emp.setEpassword(pass);
        session.save(emp);
        tx.commit();
		
	}
	
	public static void deletedata( Scanner sc,Session session, Transaction tx) {
		System.out.println("enter id");
		int id =sc.nextInt();
		Employee emp = new Employee();
        
        emp.setEid(id);
        session.delete(emp);
        tx.commit();
		
	}
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       
        Configuration cfg = new Configuration().configure();
        
        SessionFactory sf= cfg.buildSessionFactory();  
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();
        Scanner sc=new Scanner(System.in);
       
        System.out.println("enter 1 for insert 2 for delete");
        int ch =sc.nextInt();
        
        switch (ch) {
		case 1: adddata(sc, session, tx);
				break;
		case 2: deletedata(sc, session, tx);
				break;
		default:System.out.println("invalid choice");
			break;
		}
        
        
        
    }
}
