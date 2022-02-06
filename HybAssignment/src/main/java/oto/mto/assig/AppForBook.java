package oto.mto.assig;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.Assignment.AppFunction;

import antlr.debug.ParserEventSupport;

public class AppForBook {
	
	public static void addpubliccationdetails(Scanner sc,Session session,Transaction tx ) {
		Publication pb=new Publication();
		
		System.out.println("publication name");
		String pName=sc.next();
		pb.setPublicationName(pName);
		
		Address add=new Address();
		System.out.println("publication address");
		System.out.println("enter street");
		String street=sc.next();
		
		System.out.println(" city");
		String city=sc.next();
		System.out.println(" state");
		String state=sc.next();
		System.out.println(" PIN code");
		int pin=sc.nextInt();
		
		add.setStreetName(street);
		add.setCity(city);
		add.setState(state);
		add.setPinCode(pin);
		
		pb.setAddress(add);	
		session.save(pb);
		tx.commit();
		session.close();
		
	}
	
	
	public static void addBookAndPubl(Scanner sc,Session session,Transaction tx) {
		
		Book bk1=new Book();
		bk1.setBookName("try");
		bk1.setPageNo(30);
		
		Book bk2=new Book();
		bk2.setBookName("ndf ");
		bk2.setPageNo(40);
		
		Book bk3=new Book();
		bk3.setBookName("msi ");
		bk3.setPageNo(50);
		
		Publication pb1=new Publication();
		pb1.setPublicationName("Group");
		
		Publication pb2=new Publication();
		pb2.setPublicationName("Delhi Press ");
		
		bk1.setBookPubl(pb1);
		bk2.setBookPubl(pb2);
		bk3.setBookPubl(pb2);
		
		
		session.save(bk1);
		session.save(bk2);
		session.save(bk3);
		tx.commit();
		session.close();
	}

	public static void main( String[] args ) {
		System.out.println( "Hello World!" );
		Configuration cfg= new Configuration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();

		int ch;
		do {

			System.out.println("enter 1 for addpubliccationdetails using one to one ");
			System.out.println("enter 2 for addbook and publication deatis using many to one company");
			//System.out.println("enter 3 for list");
			System.out.println(" 4 for exit");
			
			Scanner sc=new Scanner(System.in);
			ch=sc.nextInt();
			switch (ch) {

			case 1:	
					addpubliccationdetails(sc, session, tx);
					break;
			
			case 2:	addBookAndPubl(sc, session, tx);
					break;			
			case 3:	System.exit(0);
			
			default:System.err.println("Invalid choice!!! Please make a valid choice. \\n\\n");
			}

		}while(ch!=3);

	}
}
