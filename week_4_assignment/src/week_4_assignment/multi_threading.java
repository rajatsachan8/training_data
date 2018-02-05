package week_4_assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

class Runner extends Thread{
	static int count=0;
	static int inc1=0;
	static int length=0;
	public Runner(int count2, int inc) {
		// TODO Auto-generated constructor stub
		length=count2;
		inc1=inc;
	}

	public void run(){
		for(int i=0;i<inc1;i++){
			count=count+length;
//			Thread t = Thread.currentThread();
//		      String name = t.getName();
//			System.out.println(count+ "   "+name);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}
}

public class multi_threading
{
  public static void main(String args[])
  {  Scanner scan=new Scanner(System.in);
	  int threads;
	  int count;
	  int inc;
	  while(true){
		  try{
			  
			  System.out.println("Enter the threads");
			  threads=scan.nextInt();
			  if(threads<=0)
					 throw new InputMismatchException("Enter correct Value");
			  System.out.println("Enter increment counter value");
			  count=scan.nextInt();
			  if(count<=0)
				 throw new InputMismatchException("Enter correct Value");
			  System.out.println("Enter the number of times to increment value");
			  inc=scan.nextInt();
			  if(inc<=0)
					 throw new InputMismatchException("Enter correct Value");
			  break;
		  }
		  catch(InputMismatchException e){
			  System.out.println("Enter correct Value");
			  scan=new Scanner(System.in);
		  }
	  }
	 
	  for(int i=0;i<threads;i++){
		  Runner runner1=new Runner(count,inc);
		  runner1.start();
	  }
	  System.out.println(Runner.count);
  }
}