package constructor.bean.collection.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MainCjExampleApp {
	
	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		
		ApplicationContext context= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		Question  q=(Question) context.getBean("mcq");
		
		q.show();
		
		Customer cs=(Customer) context.getBean("customer");
	
		cs.details();
	
	}
}
