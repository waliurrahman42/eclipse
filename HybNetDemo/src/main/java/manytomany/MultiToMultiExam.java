package manytomany;

import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

import org.hibernate.*;

public class MultiToMultiExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(manytomany.MultiAnswer.class);
		cfg.addAnnotatedClass(manytomany.Multiquestion.class);
		cfg.configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session   = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Multiquestion q1 = new Multiquestion();
		q1.setQuestionName("what is orm?");
		Multiquestion q2 = new Multiquestion();
		q2.setQuestionName("what is jdbc?");
		
		MultiAnswer ans1 = new MultiAnswer();
		ans1.setAnsName("orm is object relation mapping");
		
		MultiAnswer ans2 = new MultiAnswer();
		ans2.setAnsName("orm help in conversion of object into entity");
		
		MultiAnswer ans3 = new MultiAnswer();
		ans3.setAnsName("jdbc is java data base connectivity");
		
		MultiAnswer ans4 = new MultiAnswer();
		ans4.setAnsName("jdbc is an api for database connection ");
		
		
		ArrayList<MultiAnswer> ansList1 = new ArrayList<MultiAnswer>();
		ansList1.add(ans1);
		ansList1.add(ans2);
		
		ArrayList<MultiAnswer> ansList2 = new ArrayList<MultiAnswer>();
		ansList2.add(ans3);
		ansList2.add(ans4);
		
		q1.setAnswers(ansList1);
		q2.setAnswers(ansList2);
		
		session.save(q1);
		session.save(q2);
		
		tx.commit();
		
		session.close();
		
		System.out.println(" done ...........");
	}

}
