import java.util.Scanner;


public class classtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scan=new Scanner(System.in);
int n=scan.nextInt();
int temp;
int original=n;
int sum=0;
  while(n!=0)
  {
	temp=n%10;
	sum=sum+(temp*temp*temp);
	n=n/10;
  }
  //System.out.print(sum);
    if(sum == original){
    	System.out.println("Number is armstrong");

    }
	    
	  else {
		  System.out.println("No armstrong");	 
	  }
		  	
	}

}
