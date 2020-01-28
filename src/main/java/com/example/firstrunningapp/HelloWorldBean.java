package com.example.firstrunningapp;

public class HelloWorldBean {
	private String message=" Says Hi peeps";
    
	public HelloWorldBean(){
		message="its from the constructor";
	}
	public HelloWorldBean(String msg){
		message=msg;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		
		return "HelloWorldBean [message=" + message + "]";
	}
	
}
