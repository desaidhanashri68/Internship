package com.oit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.oit.entity.reservation;
import com.oit.entity.user;
 import com.oit.entity.signup;
 import com.oit.entity.contact;
import com.oit.service.contactService;
import com.oit.service.reservationService;
import com.oit.service.signService;
import com.oit.service.userService;

@Controller
public class userController {
	
	@Autowired
	private userService service;
	
	@Autowired
	private signService service2;
	
	@Autowired
	private contactService service3;
	
	@Autowired
	private reservationService service4;
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	
   @GetMapping("/loginpage")	
   public String userlogin() {
	return "login";
	   
   }
   
    @PostMapping("/loginsave")
   public String login(@ModelAttribute user u) {
	   
	  System.out.println(u); 
	  service.addUser(u);
	    return "signup";
	   
   }
    @GetMapping("/signuppage")
    public String signup() {
		return "signup";
    	
    }
    @GetMapping("/gallerypage")
    public String gallery() {
    	return "gallery";
    }
    
    @GetMapping("/contactpage")
    public String contact() {
		return "contact";
    	
    }
    @GetMapping("/about")
    public String about() {
    	return "about";
    }
    
  
    @GetMapping("/menu")
    public String menu() {
		return "menu";
    	
    }
    
    @PostMapping("/signupsave")
    public String signup(@ModelAttribute signup s) {
    	System.out.println(s);
    	service2.signup(s);
		return "reservation";
    	
    }
    @PostMapping("/contactsave")
    public String contact(@ModelAttribute com.oit.entity.contact c) {
    	System.out.println(c);
    	service3.contact(c);
		return "contact";
    	
    }
    
    @PostMapping("/reservationsave")
    public String reservation(@ModelAttribute reservation r) {
    	System.out.println(r);
    	service4.reservation(r);
		return "reservation";
    	
    }
    
    
    	
    
}
