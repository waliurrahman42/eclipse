package hql.assig;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserFunction {
	//start inserting data in table
	public static void insertDatainUser(Session session, Transaction tx) {

		Scanner sc=new Scanner(System.in);
		User user=new User();

		System.out.println("enter username");
		String name=sc.next();
		System.out.println("enter movie id");
		int mId=sc.nextInt();
		System.out.println("enter rating between 0 to 5");
		Double rt=sc.nextDouble();

		user.setUsername(name);
		user.setMovieid(mId);
		user.setRating(rt);

		LocalDate date = LocalDate.now();
		user.setDate(date);

		System.out.println( "now enter time in hr min and sec:");
		int h,m,s,sec;
		System.out.println( "Enter time in hours:");
		h=sc.nextInt();
		System.out.println( "Enter time in minutes:");
		m=sc.nextInt();
		System.out.println( "Enter time in seconds:");
		s=sc.nextInt();
		sec=h*3600+m*60+s;
		System.out.println( "Time in seconds:"+sec);

		//LocalTime curtime = LocalTime.now();
		//user.setCurrentTime(curtime);
		user.setTime(sec);
		session.save(user); // save is used to insert data
		tx.commit();
	}
	//end  inserting data in table



	//start fetch user in in data using HQL
	public static void ShowUsers(Session session, Transaction tx) {

		String hql="from User";
		Query query=session.createQuery(hql);
		List<User> list=query.list();
		for(User q:list) {
			System.out.print(q.getUserId()+"\t");
			System.out.print(q.getUsername()+"\t");
			System.out.print(q.getMovieid()+"\t");
			System.out.print(q.getRating()+"\t");
			System.out.print(q.getDate()+"\t");
			System.out.println(q.getTime()+"\t");
		}
	}
	//END  fetch user in in data using HQL

	// start user data who is created yesterday;
	public static void fetchyesterdaydata(Session session, Transaction tx) {
		String hql="select b.username from User b where b.date <= subdate(curdate(), 1)";
		Query query=session.createQuery(hql);
		List list= query.list();
		System.out.println("name"+list);
	}
	// end user data who is created yesterday;


	// start show to total no of user in data
	public static void noOfuser(Session session, Transaction tx) {
		String hql="SELECT Count(*) from User"; 
		Query query = session.createQuery(hql);
		List list = query.list();
		System.out.println(list);
	}
	// end show to total no of user in data





	//start fetch data who are watching movie above 3.5 rating
	public static void showNameWatchingR(Session session, Transaction tx) {
		String hql="from User r where r.rating > 3.5"; 
		Query query = session.createQuery(hql);

		List<User> list=query.list();
		//System.out.println(list);
		for(User q:list) {
			System.out.println(q.getUsername());
		}
	}
	//end fetch data who are watching movie above 3.5 rating

	//start show total hr spend by total user on movie
	public static void totalHrSpend(Session session, Transaction tx) {
		String hql="select sec_to_time(sum(u.time)) from User u";	
		Query query=session.createQuery(hql);
		List<User> list=query.list();
		System.out.print(" Total hr spend by total user on movie ");
		System.err.println(list);
	}
	////end show total hr spend by total user on movie


	//start updating movie rating
	public static void updateMovieRating(Session session, Transaction tx) {
		Scanner sc=new Scanner(System.in);

		String hql="update User u set u.rating =: pram1 where u.movieid =: pram2"; 
		Query query = session.createQuery(hql);

		System.out.println("enter movie id to update rating");
		int mid=sc.nextInt();
		System.out.println("enter movie rating 1-5 to update rating");
		double rating=sc.nextDouble();

		query.setParameter("pram2", mid);
		query.setParameter("pram1", rating);
		int r=query.executeUpdate();
		if(r>0) {
			System.out.println("data updated");
		}
		tx.commit();
	}
	//end updating movie rating

	//start delete user on basis of movieid
	public static void deleteUserUsingMovieId(Session session, Transaction tx) {
		Scanner sc=new Scanner(System.in);

		String hql="delete User u where u.movieid=:pram"; 
		Query query = session.createQuery(hql);

		System.out.println("enter movie id to delete all the user on basis of movieid ");
		int mid=sc.nextInt();
		query.setParameter("pram", mid);

		int r=query.executeUpdate();
		if(r>0) {
			System.out.println("data is deleted");
		}
		tx.commit();
	}
	//end delete user on basis of movieid

	///////////////////////////////////////////////////////////////////////////////////////////
	//rashik code
	public static void fetchtime(Session session, Transaction tx) {
		String hql="select e.userId, e.username, time(e.time), hour(e.time), minute(e.time), second (e.time) from User e";
		Query query = session.createQuery (hql);

		List<Object[]> user= (List<Object[]>) query.list();
		for (Object[] u: user) {
			Integer id= (Integer)u[0];
			System.out.println("user id="+id);
			String name = (String)u[1];
			System.out.println("username="+name);
			String time = (String)u[2]; System.out.println("movie time="+time);
			Integer hour = (Integer)u[3];
			System.out.println("movie time in hour="+hour);
			Integer min = (Integer)u[4];
			System.out.println("movie time in minutes="+min);
			Integer sec= (Integer)u[5]; System.out.println("movie time in seconds="+sec);
		}
	}
	//RASHIK CODE
	public static void fetchtimecount (Session session, Transaction tx) {
		String hqlt="select time(b.time) from User b"; 
		String hqlh="select hour(b.time) from User b"; 
		String hqlm="select minute (b.time) from User b";
		String hqls="select second (b.time) from User b";
		String hqln="select b.username from User b";
		Query queryt = session.createQuery (hqlt);
		Query queryh = session.createQuery (hqlh);
		Query querym = session.createQuery (hqlm); 
		Query querys = session.createQuery (hqls);
		Query queryn = session.createQuery (hqln);
		List listt=queryt.list();
		List listh=queryh. list();
		List listm=querym.list();
		List lists=querys.list();
		List listn =queryn.list();
		System.out.println("name="+listn);
		System.out.println("time="+listt);
		System.out.println("hours"+listh);
		System.out.println("minutes"+listm); 
		System.out.println("seconds "+lists);
	}


}
