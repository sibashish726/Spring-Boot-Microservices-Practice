package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

@RestController
@ResponseBody
@RequestMapping("/hello")
public class HomeController {
	
   @RequestMapping("/spring")	
   public String home() {
	   return "Hello spring";
   }
   
   @RequestMapping("/world")	
   public String world() {
	   return "Hello world";
   }
   
   @GetMapping("/user")
   public User user() {
	   User user= new User();
	   user.setId("2026001");
	   user.setEmail("sibashishbiswas@gmail.com");
	   user.setName("Sibashish Biswas");
	   return user;
	    
   }
   
   @GetMapping("/user/{id}")
   public String pathVaribale(@PathVariable String id) {
	return "Path varible is "+id;
	   
   }
   
   @GetMapping("/requestParam")
   public String requestParam(@RequestParam String name , @RequestParam(required = false, defaultValue = "default@gmail.com") String email) {
	return "Your name is : "+name+" email is "+email;
	   
   }
}
