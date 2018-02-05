import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Consecutive_characters {
	public static String retrieveValuesFromList(Set set,int i)
    {       String arr[]=new String[set.size()];
               int n=0;
        Iterator itr = set.iterator();
        while(itr.hasNext())
        {   //System.out.println(itr.next());
            arr[n]=(String)itr.next();
            //System.out.println(arr[n]);
              n++;
        }
        return arr[i];
    }
	
	public static void printConsecutiveCharacter(String input){
		
		StringBuilder str;
		Set<String> set=new HashSet<String>();
		int count,k=0;
		String ch;
		for(int i=0;i<input.length();i++){
			for(int j=0;j<(input.length()-1);j++){
				
				
				if((input.charAt(j)+1)== input.charAt(j+1)){
					str=new StringBuilder();
					str=str.append(input.charAt(j));
					str=str.append(input.charAt(j+1));
					ch=str.toString();
					//System.out.println(ch);
					set.add(ch);
					
				}
			}
		}
	    
		
		 count_char(set,input);
	}
	
	public static void count_char(Set set,String input){
		String[] word_str=input.split("\\s");
		StringBuilder str;
		int count=0,flag=0;
		
		String check_string,ch="";
		for(int k=0;k<set.size();k++){
			check_string=retrieveValuesFromList(set, k);
			//System.out.println(check_string);
			for(int i=0;i<word_str.length;i++){
				for(int j=0;j<(word_str[i].length()-1);j++){
						str=new StringBuilder();
						str=str.append(word_str[i].charAt(j));
						str=str.append(word_str[i].charAt(j+1));
						ch=str.toString();
						if(ch.compareTo(check_string)==0){
							count++;
							flag++;
						}
					
				}
			}
			System.out.println(check_string +" "+count);
			count=0;
		}
		if(flag==0){
			System.out.println("No Consecutive characters found");
		}
			
	}
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 InputStreamReader r=new InputStreamReader(System.in);    
		    BufferedReader br=new BufferedReader(r); 
		    String input="";
		    int count;
		    while(true){
		    	try{
		    		count=0;
		    		System.out.println("Enter the string");
			        input=br.readLine();
			        for(int i=0;i<input.length();i++){
			        	if((input.charAt(i)>=32 && input.charAt(i)<=64) || (input.charAt(i)>=91 && input.charAt(i)<=96) ||(input.charAt(i)>=123 && input.charAt(i)<=126)){
			        		++count;
			        		input=input.replace(input.charAt(i), '+');
			        	}
			        }
			        //System.out.println("count= "+count+"  length="+input.length());
			        if(count==input.length()){
			        	throw new InputMismatchException("dump");
			        }
			        break;
		    	}
		    	catch(InputMismatchException e){
		             System.out.println("Kindly enter a string consisting only alphabet(a-z)");
		    	}
		    	 
		    }
		    
		   
		    //System.out.println(input);
		    input=input.replace("+","");
		    //System.out.println(input);
		   
        input=input.toUpperCase();
        //System.out.println(input);
       printConsecutiveCharacter(input);
	}

}
