package week_4_assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class syncmulti_threading {
	static int counter=0;
	static int y=0;
	static int limit;
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		while(true){
			try{
				System.out.println("Enter the threads limit");
				limit=s.nextInt();
				if(limit<=0)
					throw new InputMismatchException("Wrong Limit");
				System.out.println("Enter the counter limit");
				y=s.nextInt();
				if(y<=0)
					throw new InputMismatchException("Wrong Counter");
				break;
			}
			catch(InputMismatchException e){
				System.out.println("Wrong Input...enter again");
				s=new Scanner(System.in);
			}
			
		}
		
		
		syncmulti_threading mobj=new syncmulti_threading();
		mobj.SomeOther();
	}
	public void SomeOther() {
		// TODO Auto-generated method stub
		Thread[] obj1=new Thread[limit];
		for(int z=0;z<obj1.length;z++){
			obj1[z]=new Thread(new Runnable(){
				public void run(){
					counter3();
				}
			});
		obj1[z].start();
		}
		for(Thread ob: obj1){
			try{
				ob.join();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println("counter value is: "+counter);
	}
	public synchronized void counter3(){
		for(int k=0;k<y;k++){
			counter++;
		}
	}

}
