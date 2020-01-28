package com.example.firstrunningapp;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private Date birthdate;
	
	public User(int id){
		this.id=id;
	}
	
	public User(int id, String name){
		this.id=id;
		this.name=name;
	}
	
	public User(int id, String name,Date bdate){
		this.id=id;
		this.name=name;
		birthdate=bdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
	
}
