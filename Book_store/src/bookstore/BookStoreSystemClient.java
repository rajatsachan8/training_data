package bookstore;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookStoreSystemClient {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int choice;
		BookStoreSystemManager obj=new BookStoreSystemManager();
		while(true){
			try{
				do{
					System.out.println("     XYZ Book Store   ");
					System.out.println("------------------------");
					System.out.println("1. Display Book Details");
					System.out.println("2. Purchase a book");
					System.out.println("3. Exit");
					System.out.print("Enter the choice:");
				     choice=scan.nextInt();
				     if(choice<1 || choice>3){
				    	 throw new InputMismatchException("dump");
				     }
				    if(choice==1){
				    System.out.println("-------------------------");
				    System.out.println("Available Book Categories");
				    System.out.println("-------------------------");
				    
				    obj.getCategory();
					}
					if(choice==2){
				    System.out.println("--------------------------");
				    System.out.println("      Purchase Book       ");
				    System.out.println("--------------------------");
				    
				    obj.getpurchase();
					}
					
				}while(choice!=3);
				break;
			}
			catch(InputMismatchException e){
				System.out.println("Wrong Input Entered");
				scan=new Scanner(System.in);
			}
		}
		
		
	}

}
