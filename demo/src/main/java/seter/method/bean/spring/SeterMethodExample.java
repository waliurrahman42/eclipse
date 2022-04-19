package seter.method.bean.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SeterMethodExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		Lead l=(Lead)context.getBean("leaddetails");	
			System.out.println("lead id is "+l.getLeadid());
			System.out.println("lead name is "+l.getLeadName());	
			System.out.println("lead course is "+l.getLeadCourse());	
	
		MyProduct pd=(MyProduct) context.getBean("myproduct1");
			pd.showDetails();
	}

}
