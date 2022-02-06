package oneTomany.maping;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoManyex {
	
	 public static void AddQans(Session session,Transaction tx) {
		 Answers ans1=new Answers();
		 ans1.setStatus(true);
		 ans1.setAns("hibernate is framework");
		 
		 Answers ans2=new Answers();
		 ans2.setStatus(false);
		 ans2.setAns("hibernate is used for db con");
		 
		 Answers ans3=new Answers();
		 ans3.setStatus(true);
		 ans3.setAns("hibernate is orm based");
		 
		 ArrayList<Answers> ansList = new ArrayList<Answers>();
		 ansList.add(ans1);
		 ansList.add(ans2);
		 ansList.add(ans3);
		 
		 Question ques= new Question();
		 ques.setQuestion("whwt is hibername?");
		 ques.setAnswers(ansList);
		 
		 session.save(ques);
		   
		   tx.commit();
		   session.close();
		   System.out.println("question and answer ....");
		 
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
		case 1:AddQans(session, tx); 
				break;
		case 2:
				break;
		default:System.out.println("invalid choice");
			break;
		}
	}
}
