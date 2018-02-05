package classtest;

import java.util.Scanner;

public class Mindtreetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner scan=new Scanner(System.in);
        System.out.println("enter the size for matrix1 and matrix2 ");
        int n1=scan.nextInt();
      
        char matrix1[][]=new char[n1][n1];
        char matrix2[][]=new char[n1][n1];
        System.out.println("enter elements in matrix 1");
        for(int i=0;i<n1;i++){
        	for(int j=0;j<n1;j++){
        		matrix1[i][j]=scan.next().charAt(0);
        	}
        }
        System.out.println("enter elements in matrix 2");
        for(int i=0;i<n1;i++){
        	for(int j=0;j<n1;j++){
        		matrix2[i][j]=scan.next().charAt(0);
        	}
        }
        
        String str[][]=new String[n1][n1];
         for(int i=0;i<n1;i++){
        	 for(int j=0;j<n1;j++){
        		 str[i][j]=new StringBuilder().append(matrix1[i][j]).append(matrix2[i][j]).toString();
        	 }
         }
         
         for(int i=0;i<n1;i++){
        	 for(int j=0;j<n1;j++){
        		 System.out.print(str[i][j]+"   ");
        	 }
        	 System.out.println();
         }
        
        
	}

}
