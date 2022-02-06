package com.test.Assignment;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {

	
	


	public static void main( String[] args ) {
		System.out.println( "Hello World!" );

		Configuration cfg= new Configuration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();

		AppFunction funct=new AppFunction();

		int ch;
		do {

			System.out.println("enter 1 for product section ");
			System.out.println("enter 2 for company");
			System.out.println("enter 3 for list");
			System.out.println(" 4 for exit");
			Scanner sc=new Scanner(System.in);
			ch=sc.nextInt();
			switch (ch) {

			case 1:	System.out.println("welcome to product section");
					int opt;
					do {
						System.out.println("enter 1 for insert product ");
						System.out.println("enter  2 for delete product ");
						System.out.println("enter 3 for exit");
						opt=sc.nextInt();
						switch (opt) {
						case 1: funct.addProduct(sc, session, tx);
						break;
						case 2: funct.removeProduct(sc, session, tx);
						break;
						case 3:	break;
						default:	System.err.println("Invalid choice!!! Please make a valid choice. \\n\\n");
						}
					}while(opt!=3);
					break;
			
			case 2:	System.out.println("welcome to company section");
					int key;
					do {
						System.out.println("enter 1 for insert company ");
						System.out.println("enter  2 for delete company");
						System.out.println("enter  3 for exit;");
						key=sc.nextInt();
		
						switch (key) {
						case 1:funct.addCompany(sc, session, tx);
						break;
						case 2:funct.removeCompany(sc, session, tx);
						break;
						case 3:	break;
						default:	System.err.println("Invalid choice!!! Please make a valid choice. \\n\\n");
						}
					}while(key!=3);
					break;
			
			case 3:	System.out.println("list");
					int ls;
					do {
						System.out.println("enter 1 for insert add ProductList");
						System.out.println("enter 2 for insert ProductListIn Db ");
						System.out.println("enter  3 for exit;");
						ls=sc.nextInt();
		
						switch (ls) {
						case 1:funct.addProductList();
						break;
						case 2:funct.insertProductListInDb(session, tx);
						break;
						case 3:	break;
						default:	System.err.println("Invalid choice!!! Please make a valid choice. \\n\\n");
						}
					}while(ls!=3);
					break;
			case 4:	System.exit(0);
			
			default:	System.err.println("Invalid choice!!! Please make a valid choice. \\n\\n");
			}

		}while(ch!=4);

	}
}
