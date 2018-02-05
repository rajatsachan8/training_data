import java.util.*;
public class Fibonacci {

	public static int print_fibonacci(int n){
		
        if(n==0){
        	return 0;
        }
        else if(n==1){
        	return 1;
        }
        else{
        	return(print_fibonacci(n-1)+print_fibonacci(n-2));
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int n;
        StringBuilder str;
        while(true){
        	try{
        		System.out.println("Enter the nth fibonacci number");
                 n=scan.nextInt();
                   break;
                }
        	
        	catch(Exception e){
        		System.out.println("Kindly enter combination of digits");
        		scan=new Scanner(System.in);
        	}
        	
        }
        
        if(n<0){
        	System.out.println("Fibonacci of negative number not possible");
        }
        else{
        	System.out.println(print_fibonacci(n));	
        }
        
        
	}

}
