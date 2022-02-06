package com.cdac.dipendencyexample2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringDependencyInjectionExample {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();

		context.scan("com.cdac.dipendencyexample2");
		context.refresh();
		
		User u = (User) context.getBean("gamer");
		u.doWork();
	}

}
