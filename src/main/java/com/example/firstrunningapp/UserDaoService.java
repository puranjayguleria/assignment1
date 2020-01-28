package com.example.firstrunningapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	static int userCount=3;
	private static List<User>users =new ArrayList();
	static{
		users.add(new User(1, "Adam", new Date())); 

		users.add(new User(2, "Eve", new Date())); 

		users.add(new User(3, "Jack", new Date())); 
	}
	
	public List<User> findAll(){
		return users;
		
		}
	
	public User save(User user) { 

		if (user.getId() == 0) { 

		user.setId(++userCount); 

		} 

		users.add(user); 

		return user; 

		}
	
	public User findOne(int id) {
		
		Iterator<User> iter=users.iterator();
		User use = null;
		while(iter.hasNext()){
			use=iter.next();
			if(use.getId()==id)
			{
				break;
			}
			
		}
		System.out.println("We have id of object as >>>>>>"+use.getId());
		return use;
	}
	
	

}
