import java.util.*;
public class spiral_matrix {
	
	static void spiral_print(int a[][],int row, int column )
	    {
	        int i, k = 0, l = 0;
	        while (k < row && l < column){ 
	        	for (i = l; i < column; ++i)
	            { System.out.print(a[k][i]+" ");
	              }
	        	k++;
	            for (i = k; i < row; ++i){
	            	System.out.print(a[i][column-1]+" ");
	            }
	            column--;
	            if ( k < row){
	            	for (i = column-1; i >= l; --i)
	                { System.out.print(a[row-1][i]+" ");
	                   }
	                row--;
	                 }
	            if (l < column)
	            {  
	            	for (i = row-1; i >= k; --i)
	                { System.out.print(a[i][l]+" ");
	                    }
	                  l++;    
	            }        
	        }
    }
	
	
	static void initialize(int [][] arr){
		System.out.println("Enter the array elements");
		Scanner scan=new Scanner(System.in);
		 for(int i=0;i<arr.length;i++){
	        	for(int j=0;j<arr[0].length;j++){
	        		arr[i][j]=scan.nextInt();
	        	}
	        }
	}
	
	static void array_print(int[][] arr){
		 for(int i=0;i<arr.length;i++){
	        	for(int j=0;j<arr[0].length;j++){
	        		System.out.print(arr[i][j]+" ");
	        	}
	        	System.out.println();
	        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the matrix size");
        int n1=scan.nextInt();
        int n2=scan.nextInt();
        int arr[][]=new int[n1][n2];
           initialize(arr);
           array_print(arr);
           System.out.println("Spiral Print");
		spiral_print(arr,n1,n1);
		
	} 

}
