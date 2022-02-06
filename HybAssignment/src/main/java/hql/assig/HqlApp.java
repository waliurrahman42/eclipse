package hql.assig;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HqlApp {

	public static void main(String[] args) {
		Configuration cfg= new Configuration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();

		UserFunction uf=new UserFunction();
		int ch;
		do {

			System.out.println("enter 1 for one to insert data in table");
			System.out.println("enter 2 show table ");
			System.out.println("enter 3 show total time spent by all user in hr and min and sec using hql");
			System.out.println("enter 4  update movie rating by user using hql ");
			System.out.println("enter 5  show user name watching movie having rating higher than 3.5. using hql ");
			System.out.println("enter 6  update movie rating by user using hql");
			System.out.println("enter 7 delete all the user on basis of movieid  using hql");
			System.out.println("enter 8 show all the users from yesterday ");
			//System.out.println("enter  ");

			System.out.println(" 10 for exit");

			Scanner sc=new Scanner(System.in);
			ch=sc.nextInt();
			switch (ch) {

			case 1:uf.insertDatainUser(session, tx);break;
			case 2:	uf.ShowUsers(session, tx);break;		
			case 3:	uf.totalHrSpend(session, tx);break;
			case 4:	uf.noOfuser(session, tx);break;
			case 5:	uf.showNameWatchingR(session, tx);break;
			case 6:	uf.updateMovieRating(session, tx);break;
			case 7:	uf.deleteUserUsingMovieId(session, tx);break;
			case 8:	uf.fetchyesterdaydata(session, tx);break;
			case 10: System.exit(0);

			default:System.err.println("Invalid choice!!! Please make a valid choice. \\n\\n");
			}
		}while(ch!=10);
	}



}
