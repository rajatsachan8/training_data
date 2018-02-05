import java.util.*;
import java.io.*;

public class testmindtree {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
			StringBuilder str=new StringBuilder();
			StringBuilder str1=new StringBuilder();
			StringBuilder str2=new StringBuilder();
			String first_name,last_name;
			String name="rajat sachan";
			String[] separate_name=name.split("\\s");
			 str1=new StringBuilder(separate_name[0]);
			 str2=new StringBuilder(separate_name[1]);
			 str1=str1.reverse();
			 str2=str2.reverse();
			 first_name=str1.toString();
			 last_name=str2.toString();
			 str=str.append(first_name);
			 str=str.append(" ");
			 str=str.append(last_name);
			  name=str.toString();
			  System.out.println(name);
			  str=new StringBuilder();
			  separate_name=name.split("\\s");
			  str=str.append(separate_name[0]);
			  str=str.append(separate_name[1]);
			  name=str.toString();
			  System.out.println(name);
		      
			
		
		
	}
}
