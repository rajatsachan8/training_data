package com.mindtree;

import java.io.IOException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {

	       Scanner scan=new Scanner(System.in);
	       char choice;
	       int ch;
	       DAO access=new DAO();
	       do{
	    	   System.out.println("----- Enter the choice ------");
	    	   System.out.println("1. Enter the candidate in new Constituency");
	    	   System.out.println("2. Enter the candidate in existing constituency");
	    	   System.out.println("3. Display candidate (Name,Party,Constituency");
	    	   System.out.println("4. Display candidate (Name,Constituency");
	    	   System.out.println("5. Display candidate contesting in constituency");
	    	   System.out.println("6. Display candidate name for party and constituency");
	    	   ch=scan.nextInt();
	    	   if(ch==1){
	    		   access.insertNewData();
	    	   }
	    	   if(ch==2){
	    		   access.insertNewData();
	    	   }
	    	   if(ch==3){
	    		   access.showDetails();
	    	   }
	    	   if(ch==4){
	    		   access.showName();
	    	   }
	    	   if(ch==5){
	    		   access.contestants();
	    	   }
	    	   if(ch==6){
	    		   access.partyAndConsti();
	    	   }
	    	   System.out.println("Do you wish to continue...press(y/Y)");
	    	   choice=scan.next().charAt(0);
	       }while(choice=='y'|| choice=='Y');
	       System.out.println("Program Terminated and Scanner closed");
	       scan.close();
	   
		
	}

}       
