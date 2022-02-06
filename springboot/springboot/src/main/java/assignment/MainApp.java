package assignment;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import assignment.PersonDetails;
import assignment.Sales;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("assignment");
		context.refresh();
		
		Sales s= (Sales) context.getBean("sales");
		s.show();
		System.out.println(s);
		
	}

}
