package commandline;
import java.util.*;
import java.io.*;
import java.sql.*;

public class database_college {
     
	static PreparedStatement stmt=null;
	static Connection conn=null;
	
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
	
		     try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Welcome123");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      System.out.println("Connected database successfully...");
			
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
                		 System.out.println("Enter 3 digit integer value" );
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
           String sql = "INSERT INTO id_name(ID,Name) values(?,?)";
           try {
			stmt = (PreparedStatement)conn.prepareStatement(sql);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
           
           for(int i=0;i<id_set.size();i++){
        	     id=retrieveValuesFromList(id_set,i);
        	     name=name_list.get(i);
        	     try {
					stmt.setInt(1, (int)id);
					stmt.setString(2, name);     		 
	                 stmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		 
              System.out.println("Table updated");
        	     
           }
           
           String sql2 = "INSERT INTO id_marks(ID,Marks) values(?,?)";
           try {
			stmt = (PreparedStatement)conn.prepareStatement(sql2);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           
           double cgpa;
           System.out.println("Enter CGPA for students with ID's (1-10)");
           for(int i=0;i<id_set.size();i++) {
        	   id=retrieveValuesFromList(id_set,i);
        	   System.out.println("Enter cgpa for student id= "+ id);
        	   while(true){
        		   try{
            		   cgpa=scan.nextDouble();
            		   if(cgpa>=1 && cgpa<=10) { 
            			     try {
								stmt.setInt(1, (int)id);
								 stmt.setDouble(2, cgpa);     		 
	            		         stmt.executeUpdate();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
            				
            		    System.out.println("Table updated");
                		   
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
           
//           for(int i=0;i<id_set.size();i++){
//    	   id=retrieveValuesFromList(id_set,i);
//    	   System.out.println("ID= "+ id+" Name: "+map_id_name.get(id)+" Marks= "+map_id_marks.get(id));
//       }
//           double marks_arr[]=new double[id_set.size()];
//           int id_arr[]=new int[id_set.size()];
//           
//           for(int i=0;i<id_set.size();i++){
//        	   id=retrieveValuesFromList(id_set,i);
//        	   try{
//        		   marks_arr[i]=(double) map_id_marks.get(id);
//        	   }
//        	   catch(java.lang.NullPointerException e){
//        		marks_arr[i]=0.00;
//        	   }
//        	   id_arr[i]=id;
//           }
//           
//           int len=marks_arr.length;
//          
//           int temp;
//           double temp1;
//           for (int i = 0; i < len; i++) 
//           {
//               for (int j = i + 1; j < len; j++) 
//               {
//                   if (marks_arr[i] > marks_arr[j]) 
//                   {
//                       temp1 = marks_arr[i];
//                       marks_arr[i] = marks_arr[j];
//                       marks_arr[j] = temp1;
//                       
//                       temp= id_arr[i];
//                       id_arr[i]=id_arr[j];
//                       id_arr[j]=temp;
//                   }
//               }
//           }
//           if(len==1){
//        	   System.out.println("-----TOP PERFORMER----");
//        	   System.out.println("First: "+ map_id_name.get(id_arr[len-1]));
//           }
//           if(len==2){
//        	   System.out.println("-----TOP PERFORMER----");
//        	   System.out.println("First: "+ map_id_name.get(id_arr[len-1]));
//               System.out.println("Second: "+map_id_name.get(id_arr[len-2]));
//           }
//           if(len>=3){
//        	   System.out.println("-----TOP PERFORMER----");
//               System.out.println("First: "+ map_id_name.get(id_arr[len-1]));
//               System.out.println("Second: "+map_id_name.get(id_arr[len-2]));
//               System.out.println("Third: "+map_id_name.get(id_arr[len-3]));
//           }

           String fetch_sql="select id_name.ID,id_name.Name,id_marks.Marks from id_name,id_marks where id_name.ID=id_marks.ID";
           try {
			Statement stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           System.out.println("ID     Name     Marks");
           try {
			ResultSet rs=stmt.executeQuery(fetch_sql);
			
	           while (rs.next()) {
	              int id2 = rs.getInt("ID");
	               String stu_name = rs.getString("Name");
	               double marks = rs.getDouble("Marks");
	               System.out.println(id2 + "  " + stu_name+"   "+marks);
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
             
	}

}
