package com.mindtree;

import java.sql.SQLException;

public class Validation {

	public int firstServletValidate(String firstname,String lastname,String username,String password) throws SQLException{
		int result=0;
		  for(int i=0;i<firstname.length();i++){
			  if(!((firstname.charAt(i)>=65 && firstname.charAt(i)<=90)||(firstname.charAt(i)>=97 && firstname.charAt(i)<=122))){
				  result=1;
				  break;
			  }
		  }
		  for(int i=0;i<lastname.length();i++){
			  if(!((lastname.charAt(i)>=65 && lastname.charAt(i)<=90)||(lastname.charAt(i)>=97 && lastname.charAt(i)<=122))){
				  result=2;
				  break;
			  }
		  }
		  if(password.length()<=8){
			  result=3;
		  }
		  DAO dao=new DAO();
		  if(!dao.validateUser(username)){
			  result=4; 
		  }
		      
		  return result;
	}

	public static int BatchMidValidation(String mId, String city) {
		int result=0;
		System.out.println(mId.charAt(0));
		if(mId.charAt(0)!='M')
		{
			result=1;
		}
		for(int i=0;i<city.length();i++){
			  if(!((city.charAt(i)>=65 && city.charAt(i)<=90)||(city.charAt(i)>=97 && city.charAt(i)<=122))){
				  result=2;
				  break;
			  }
		  }
		System.out.println(result);
		return result;
	}
	
}
