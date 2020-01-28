package com.example.firstrunningapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	
	
		@GetMapping("/helloworld")
		public String hworld(){
			return "Hello World"; 
		}
		
		@RequestMapping("/hello-world-bean")
		public HelloWorldBean gethworld(){
			return new HelloWorldBean();
		}
		@RequestMapping("/hello-world/path-variable/{name}")
		public HelloWorldBean getgreeting(@PathVariable("name") String name) {
			return new HelloWorldBean(String.format("Hello World, %s", name));
		}
}
