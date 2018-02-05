package bookstore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.mindtree.exceptions.*;


public class BookStoreSystemManager {

	static ResultSet st;
	static int bookId;
	static String bookName;
	static String authorName;
	static String publisher;
	static String category123;
	static int price;
	static String category;
	String customer_name;
	String customer_number;
	int purchase_number=0;
	Scanner scan=new Scanner(System.in);
 public void getCategory() throws SQLException{
	 while(true){
		 
		 try{ 
			 System.out.println("Enter the Category [Kids,General,Technology]:");  
			     category=scan.next();
			 if(category.equals("Kids")||category.equals("General")||category.equals("Technology"))
				 break;
			 else 
				 throw new InvalidCategoryException();
		 }
		 catch(InvalidCategoryException e){
			 System.out.println("Invalid category name please check your input");
		 }
	 }
	 DAO dao=new DAO();
	 st=dao.getresult(category);
	   System.out.println("Id"+"    "+"Name"+"                       "+"    Author"+"      "+"    Publisher"+"   "+"   Price");
	 while(st.next()){
		 bookId=st.getInt("Book_id");
		 bookName=st.getString("Book_name");
		 authorName=st.getString("Author_name");
		 publisher=st.getString("Publisher");
		 //category123=st.getString("Category");
		 price=st.getInt("price");
		System.out.println(bookId+"   "+bookName+"     "+authorName+"       "+publisher+"       "+price);
	 }
 }
public void getpurchase() throws SQLException {
	// TODO Auto-generated method stub
	while(true){
		try{
			System.out.print("Enter book id: ");
			  bookId=scan.nextInt();
			  boolean check=validate_bookId(bookId);
			  if(!check){
				 throw new InvalidBookIdException(); 
			  }
			  System.out.print("Enter customer name: ");
			  customer_name=scan.next();
			  System.out.print("Enter customer number: ");
			  customer_number=scan.next();
			   check=validate_phoneno(customer_number);
			   if(!check){
				   throw new InvalidMobileNoException();
			   }
			   ++purchase_number;
			   break;
		}
		catch(InvalidMobileNoException e){
			System.out.println("Invalid mobile no, please check your input");
		}
		catch(InvalidBookIdException e){
			System.out.println("Invalid book id, please check your input");
		}
		
	}
	 System.out.println("Book Purchased Successfully!");
	 System.out.println("Purchase number: "+purchase_number);
	 Date date = new Date();
	 System.out.println("Purchase date: "+date.toString());
	 DAO dao=new DAO();
	 int amount=dao.getamount(bookId);
	  System.out.println("Purchase amount: "+ amount);
	 System.out.println();
}
public boolean validate_phoneno(String customer_number2) {
	// TODO Auto-generated method stub
	
	if(customer_number2.length()!=10 || customer_number2.charAt(0)=='0'){
		return false;
	}
	for(int i=0;i<customer_number2.length();i++){
		if(customer_number2.charAt(i)>=48 && customer_number2.charAt(i)<=57){
			
		}
		else
			return false;
	}
	return true;
}
public boolean validate_bookId(int bookId2) {
	// TODO Auto-generated method stub
	if(bookId2==1001 || bookId2==1002 || bookId2==1003 || bookId2==1004 || bookId2==1005 || bookId2==1006){
		return true;
	}
	else
	return false;
}

}
