package assigment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Outstanding_person {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	         Person person[]=new Person[5];
	      Scanner scan=new Scanner(System.in);
	      String name;
	      int book;
	      double marks;
	      int choice;
	      
	      int count=0,number=0;;
	      do{
	    	  System.out.println("Enter choice");
	    	  System.out.println("1.Professor");
	    	  System.out.println("2.Student");
	    	  choice=scan.nextInt();
	    	  if(choice==1){
	    		  
		    	  System.out.println("Enter the details for Professor");
		    	  
		    	  while(true){
		    		  try{
		    			  System.out.println("Enter name");
				    	  name=scan.next();
				    	  number=0;
		    			  for(int i=0;i<name.length();i++){
				    		  if(name.charAt(i)>=65 && name.charAt(i)<=122){
				    			  number++;
				    		  }
				    	  }
		    			  if(number!=name.length()){
		    				  throw new NumberFormatException("not a string"); 
		    			  }
		    				  
		    			  System.out.println("Enter number of books");
			    		  book=scan.nextInt();
			    		  if(book<0)
			    			  throw new InputMismatchException("");
			    		  break;
		    		  }
		    		  catch(InputMismatchException e){
			    		   System.out.println("Enter positive digits");
			    		   scan=new Scanner(System.in);
			    	   }
		    		  catch(NumberFormatException e){
		    			  System.out.println(e);
		    		  }
		    		  
		    	  }
		    	  
		    	  person[count]=new Professor(name,book);
		    	  Professor p=(Professor)person[count];
	        		 if(p.isOutstanding()){
	        			 p.print();
	        		 }
		    	  count++;
	    	  }
	    	  
	    	  if(choice==2){
	    		  System.out.println("Enter the details for Student");
	    		  
	    		  while(true){
		    		  try{
		    			  System.out.println("Enter name");
				    	  name=scan.next();
				    	  number=0;
		    			  for(int i=0;i<name.length();i++){
				    		  if(name.charAt(i)>=65 && name.charAt(i)<=122){
				    			  number++;
				    		  }
				    	  }
		    			  if(number!=name.length()){
		    				  throw new NumberFormatException("not a string"); 
		    			  }
		    				  
		    			  System.out.println("Enter number of marks");
			    		  marks=scan.nextDouble();
			    		  if(marks<0 || marks>100)
			    			  throw new InputMismatchException("dump");
			    		  break;
		    		  }
		    		  catch(InputMismatchException e){
			    		   System.out.println("Enter positive digits");
			    		   scan=new Scanner(System.in);
			    	   }
		    		  catch(NumberFormatException e){
		    			  System.out.println(e);
		    		  }
		    		  
		    	  }
	    		  person[count]=new Student(name,marks);
	    		  Student s=(Student)person[count];
	        		 if(s.isOutstanding()){
	                	 s.display();
	                 }
	    		  count++;
	    	  }
	    	  
	      }while(count<5);
	     
	       
	         
	}

}
