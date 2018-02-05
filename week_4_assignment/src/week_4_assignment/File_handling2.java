package week_4_assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class File_handling2 {
	static PreparedStatement stmt=null;
	 static Connection conn=null;
	 static ResultSet rs;
	 
//	 public void search(String word) {
//		 String keyword="better";
//		   String line;
//		    
//		   Object br;
//		Object s;
//		while ((s=((Object) br).readLine())!=null){
//		      if(((String) s).contains(keyword))
//		     System.out.println(s);
//		 
//		   }
//	}
	 static void CreateConnection() throws SQLException{
		 try {
				Class.forName ("com.mysql.jdbc.Driver");
				//System.out.println("Connecting to a selected database...");
			     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/products","root","Welcome123");
			     //System.out.println("Connected database successfully...");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();	
			}
	 }

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("C:\\Users\\M1043153\\Documents\\assignments soluttion\\test.txt"));
       Scanner scan=new Scanner(System.in);
     	CreateConnection();
//		while (reader.hasNext()){
//		   String str = reader.nextLine();
//		   String arr[]=str.split(",");
//		   arr[3]=arr[3].replace(" ","");
//          String query="insert into product_info (product_id,product_name,price,category) values(?,?,?,?)";
//          stmt = (PreparedStatement)conn.prepareStatement(query);
//           stmt.setString(1, arr[0]);
//           stmt.setString(2,arr[1]);
//           stmt.setString(3, arr[2]);
//          stmt.setString(4, arr[3]);
//          stmt.executeUpdate();
//             
//		}
		//System.out.println("File data read and stored.");
     
		char ch;
		do{
			System.out.println("Enter the category you want to search for...");
			String search=scan.next();
			search_table(search);
			System.out.println();
			System.out.println("Press y/Y to search more...");
			ch=scan.next().charAt(0);
		}while(ch=='y'||ch=='Y');
	     
	}

	private static void search_table(String search) throws SQLException, IOException {
		String query="select product_id,product_name,price,category from product_info where category=? order by product_name";
		stmt=(PreparedStatement)conn.prepareStatement(query);
		stmt.setString(1,search);
		rs=stmt.executeQuery();
		FileWriter writer = new FileWriter("YourFile.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		String id, name, price, category;
		System.out.println("ID"+"     Product Name"+"      Price"+"    Category");
		int flag=0;
			while(rs.next()){
				id=rs.getString("product_id");
				name=rs.getString("product_name");
				price=rs.getString("price");
				category=rs.getString("category");
				System.out.println(id+"      "+name+"     "+price+"    "+category);
				flag++;
				bufferedWriter.write(id);
				bufferedWriter.write(" ");
				bufferedWriter.write(name);
				bufferedWriter.write("");
				bufferedWriter.write(price);
				bufferedWriter.write("");
				bufferedWriter.write(category);
				bufferedWriter.newLine();
				
			}
			if(flag==0)
			{
				System.out.println("No Category Found!!");
		}
			
	}
     
}
