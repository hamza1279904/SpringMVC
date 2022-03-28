package com.dao;

import org.hibernate.usertype.UserCollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.UserDataModel;

@Repository
public class UserDao 
{
     @Autowired
	HibernateTemplate hiberTemplate;
     
      
   public boolean Authentication(String username,String password)
   {
	   try {
	   UserDataModel ud= hiberTemplate.get(UserDataModel.class, username);
	   if(ud.getPassword().equals(password))
	   return true;
	   }
	   catch(Exception E) {
		   return false;
		   }
	   return false;
   }
      
}
