package commandline;
import java.util.*;
import java.io.*;

public class college {

	public static int retrieveValuesFromList(Set set,int i)
    {       int arr[]=new int[set.size()];
               int n=0;
        Iterator itr = set.iterator();
        while(itr.hasNext())
        {   //System.out.println(itr.next());
            arr[n]=(int)itr.next();
            //System.out.println(arr[n]);
              n++;
        }
        return arr[i];
    }
	public static int digits(int n){
		int count=0;
		while(n>0){
			count++;
			n/=10;
		}
		return count;
		
	}
 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int n=0;
         
         Scanner scan=new Scanner(System.in);
         
        	 try{
            	 n=Integer.parseInt(args[0]);
             }
             catch(java.lang.NumberFormatException e){
            	 System.out.println("Entered number is not integer");
            	 System.out.println("Enter the value again");
            	 n=scan.nextInt();
             }
             //System.out.println("number is: "+ n);
               if(n<1 || n>20){
            	   System.out.println("Kindly check student limit(1-20)");
               }
         
         
           int len1=n;
           LinkedHashSet<Integer> id_set=new LinkedHashSet<Integer>();
           
           System.out.println("Enter the Student ID's");
           int id=0,number_digits;
           for(int i=0;i<n;i++){
        	   //System.out.println("value of n="+n);
        	   while(true){
        		   try{ 
        			   id=scan.nextInt();
       	        number_digits=digits(id);
       	         if(number_digits==3){
       		       id_set.add(id);
       		       break;
       	            }
       	      else{
       	    	  throw new InputMismatchException("dump");
       	        }
       	    }
        	 catch(InputMismatchException e){
        		 System.out.println("Enter 3 digit integer value" );
        		scan=new Scanner(System.in);
        	 }
       	   
        	   }
        	 }
           
           int set_length=id_set.size();
           do{
        	   if(set_length<len1){
            	   int k=len1-set_length;
            	   System.out.println(k+ "number of ID's matched..kindly enter "+k+" ID's more");
            	   for(int i=0;i<k;i++){
            	  	   while(true){
                		   try{ 
                			   id=scan.nextInt();
               	        number_digits=digits(id);
               	         if(number_digits==3){
               		       id_set.add(id);
               		       break;
               	            }
               	      else{
               	    	  throw new InputMismatchException("dump");
               	        }
               	    }
                	 catch(InputMismatchException e){
                		 System.out.println("Enter 3 digit integer value" +e);
                		scan=new Scanner(System.in);
                	 }
               	   
                	   }
            	   }
               }
        	   set_length=id_set.size();
           }while(set_length<len1);
             
         
          List<String> name_list=new ArrayList<String>();
           String name;
           System.out.println("Enter the student Name for respective ID's");
           for(int i=0;i<id_set.size();i++){
        	   System.out.println("Enter name for student"+ (i+1));
        	   name=scan.next();
        	   name_list.add(i,name);
           }
           
           HashMap map_id_name=new HashMap();
           for(int i=0;i<id_set.size();i++){
        	     id=retrieveValuesFromList(id_set,i);
        	     name=name_list.get(i);
        	     map_id_name.put(id, name);
           }
           
           HashMap map_id_marks=new HashMap();
           
           double cgpa;
           System.out.println("Enter CGPA for students with ID's (1-10)");
           for(int i=0;i<id_set.size();i++) {
        	   id=retrieveValuesFromList(id_set,i);
        	   System.out.println("Enter cgpa for student id= "+ id);
        	   while(true){
        		   try{
            		   cgpa=scan.nextDouble();
            		   if(cgpa>=1 && cgpa<=10) { 
                		   map_id_marks.put(id,cgpa);
                		   break;
                	   }
            		   else{
            			   throw new InputMismatchException("dump");
            		   }
            	   }
            	   catch(InputMismatchException e){
            		   System.out.println("CGPA should be between(1-10)");
            		   scan=new Scanner(System.in);
            	   }
        	   }
        }
           
           for(int i=0;i<id_set.size();i++){
    	   id=retrieveValuesFromList(id_set,i);
    	   System.out.println("ID= "+ id+" Name: "+map_id_name.get(id)+" Marks= "+map_id_marks.get(id));
       }
           double marks_arr[]=new double[id_set.size()];
           int id_arr[]=new int[id_set.size()];
           
           for(int i=0;i<id_set.size();i++){
        	   id=retrieveValuesFromList(id_set,i);
        	   try{
        		   marks_arr[i]=(double) map_id_marks.get(id);
        	   }
        	   catch(java.lang.NullPointerException e){
        		marks_arr[i]=0.00;
        	   }
        	   id_arr[i]=id;
           }
           
           int len=marks_arr.length;
          
           int temp;
           double temp1;
           for (int i = 0; i < len; i++) 
           {
               for (int j = i + 1; j < len; j++) 
               {
                   if (marks_arr[i] > marks_arr[j]) 
                   {
                       temp1 = marks_arr[i];
                       marks_arr[i] = marks_arr[j];
                       marks_arr[j] = temp1;
                       
                       temp= id_arr[i];
                       id_arr[i]=id_arr[j];
                       id_arr[j]=temp;
                   }
               }
           }
           if(len==1){
        	   System.out.println("-----TOP PERFORMER----");
        	   System.out.println("First: "+ map_id_name.get(id_arr[len-1]));
           }
           if(len==2){
        	   System.out.println("-----TOP PERFORMER----");
        	   System.out.println("First: "+ map_id_name.get(id_arr[len-1]));
               System.out.println("Second: "+map_id_name.get(id_arr[len-2]));
           }
           if(len>=3){
        	   System.out.println("-----TOP PERFORMER----");
               System.out.println("First: "+ map_id_name.get(id_arr[len-1]));
               System.out.println("Second: "+map_id_name.get(id_arr[len-2]));
               System.out.println("Third: "+map_id_name.get(id_arr[len-3]));
           }

             
	}

}
