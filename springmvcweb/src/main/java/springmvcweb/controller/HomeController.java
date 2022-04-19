package springmvcweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		
		System.out.println("hello this is home page");
		return "index";
	}
	
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		System.out.println("contact page executed");
		
		model.addAttribute("name","wali");
		model.addAttribute("contact","9572950888");
	
		
		return "contact";	
	}
	
	
	@RequestMapping("/about")
	public String abboutus(Model m) {
		System.out.println("aboutus page");
		
		List<String> about=new ArrayList<String>();
		
		about.add("this is about us page");
		about.add("nothig more than that");
		about.add("hello");
		
		m.addAttribute("listtype",about);
		
		
		return "aboutus";	
	}

}
