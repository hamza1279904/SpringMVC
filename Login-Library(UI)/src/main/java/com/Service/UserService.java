package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.dao.UserDao;

@Service
public class UserService
{
	

@Autowired
UserDao dao;


public boolean Search(String username,String password)
{
	
	boolean check=dao.Authentication(username, password);
	try {
	} catch (Exception e) {
	}
	if(check)
	{
		try {
		System.out.println("Yes I have got in-going to csv");
		 }
		catch(Exception e) { System.out.println(" Error in CSV");}
		
	}
	else
		System.out.println("Not Found in DATABASE");
	return check;
}
}
