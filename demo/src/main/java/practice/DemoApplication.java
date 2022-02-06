package practice;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		
		ApplicationContext context= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		//sales
//		Sales s=context.getBean(Sales.class);//calling through class
		Sales s1 = (Sales) context.getBean("salebean");//calling through bean id
//		s.show();
		s1.show();
//		System.out.println(s.getSalename());//s
//		System.out.println(s1.getSid());//s1
//		
//		//product
//		Product p=(Product)context.getBean("myproduct");
//		System.out.println(p.toString());
		
	}
}
