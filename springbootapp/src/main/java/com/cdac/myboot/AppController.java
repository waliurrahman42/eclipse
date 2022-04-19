package com.cdac.myboot;

import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository uRepo;
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showSignup(Model model) {
		model.addAttribute("user",new User());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
		String encodeString= bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodeString);	
		uRepo.save(user);
		return "registration_sucess";
	}

	 @GetMapping("/list_user")
	   public String viewUserList(Model model) {
		  List<User>  uList = uRepo.findAll();
		  model.addAttribute("userlist", uList);
		  
		   return "users";
	  }
	
}
