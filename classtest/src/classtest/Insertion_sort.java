package classtest;
import java.util.*;

public class Insertion_sort {

	static void insert_elements(int a[]){
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<a.length;i++){
			a[i]=scan.nextInt();
		}
	}
	static void insertion_sort(int arr[]){
		
        for (int i=1; i<arr.length; i++)
        {
            int unsorted_elements= arr[i];
            int j = i-1;
 
           
            while (j>=0 && arr[j] > unsorted_elements)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = unsorted_elements;
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner scan=new Scanner(System.in);
       System.out.println("Enter the size of array");
       int length_array=scan.nextInt();
       int arr[]=new int[length_array];
       System.out.println("Enter the elements in array");
       
           insert_elements(arr);
         insertion_sort(arr);  
         for(int i:arr){
        	 System.out.print(i+" ");
         }
	}

}
