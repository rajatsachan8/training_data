package classtest;

import java.util.Scanner;

public class Multiply_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
        System.out.println("enter the size for matrix1 and matrix2 ");
        int n1=scan.nextInt();
      
        int matrix1[][]=new int[n1][n1];
        int matrix2[][]=new int[n1][n1];
        System.out.println("enter elements in matrix 1");
        for(int i=0;i<n1;i++){
        	for(int j=0;j<n1;j++){
        		matrix1[i][j]=scan.nextInt();
        	}
        }
        System.out.println("enter elements in matrix 2");
        for(int i=0;i<n1;i++){
        	for(int j=0;j<n1;j++){
        		matrix2[i][j]=scan.nextInt();
        	}
        }
       int sum=0;
        int result_matrix[][]=new int[n1][n1];
      
        
        
        for (int c = 0; c < n1; c++) {
            for (int d = 0; d < n1; d++) {
              for (int k = 0; k <n1; k++) {
                sum = sum + matrix1[c][k]*matrix2[k][d];
              }
          
              result_matrix[c][d] = sum;
              sum = 0;
            }
          }
        for(int i=0;i<n1;i++){
        	for(int j=0;j<n1;j++){
        		System.out.print(result_matrix[i][j]+"   ");
        	}
        	System.out.println();
        	
        }

	}

}
