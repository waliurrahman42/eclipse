package springwebfirst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelpingController {
		
	@RequestMapping("/aboutus")
	public ModelAndView name() {
		System.out.println("about us page");
		ModelAndView modAndView=new ModelAndView();
		
		modAndView.addObject("name", "waliur rahman");
		modAndView.addObject("email","wali@gmail.com");
		modAndView.setViewName("aboutus");
		return modAndView;
	}
	
}
