package com.test.Assignment;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class AppFunction {

	//add product


	public void addProduct(Scanner sc,Session session,Transaction tx) {
		Product pd=new Product();

		System.out.println("enter product name");
		String name=sc.next();
		System.out.println("enter product price");
		Double price=sc.nextDouble();
		System.out.println("enter product company name");
		String company=sc.next();

		pd.setProductName(name);
		pd.setProductPrice(price);
		pd.setProductCompancy(company);
		session.save(pd);
		tx.commit();		
	}

	ArrayList<Product> al=new ArrayList<Product>();//for add product in list
	//add product in list	
	public void addProductList() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter product name");
		String name=sc.next();
		System.out.println("enter product price");
		Double price=sc.nextDouble();
		System.out.println("enter product company name");
		String company=sc.next();

		Product pd=new Product();
		pd.setProductName(name);
		pd.setProductPrice(price);
		pd.setProductCompancy(company);
		al.add(pd);

	}
	//add product list	in data base
	public void insertProductListInDb(Session session,Transaction tx) {
		for(Product sb : al) {
			sb.getProductId();
			sb.getProductName();
			sb.getProductCompancy();
			sb.getProductPrice();
			session.save(sb);
			System.out.println("data save");
		}
		tx.commit();
	}

	//remove product
	public void removeProduct(Scanner sc,Session session,Transaction tx) {


		System.out.println("enter product id to remove ");
		int id=sc.nextInt();

		Product pd=session.get(Product.class, id);
		if(pd!=null) {
			session.remove(pd);
			System.out.println("product removed");
		}
		else {
			System.out.println("product not found");
		}
		tx.commit();		
	}

	//add company
	public void addCompany(Scanner sc,Session session, Transaction tx) {
		Company cp=new Company();

		System.out.println("enter name of company");
		String name=sc.next();
		System.out.println("enter name of company catagary");
		String compcatg=sc.next();

		cp.setCompName(name);
		cp.setCompCategory(compcatg);
		session.save(cp);
		tx.commit();

	}

	//remove Company	
	public void removeCompany(Scanner sc,Session session, Transaction tx) {

		System.out.println("enter company id to remove ");
		int id=sc.nextInt();

		Company cp=session.get(Company.class, id);
		if(cp!=null) {
			session.delete(cp);
			System.out.println("company removed");

		}
		else {
			System.out.println("company not found");
		}

		tx.commit();
	}
}
