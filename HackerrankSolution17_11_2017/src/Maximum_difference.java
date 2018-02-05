import java.util.*;
import java.io.*;
public class Maximum_difference {

    public static void sort(int[] arr,int start_index,int last_index)
	    {
	        quickSort(arr, start_index, last_index);
	    }
	    
	    public static void quickSort(int arr[], int low, int high) 
	    {
	        int i = low, j = high;
	        int temp;
	        int pivot = arr[(low + high) / 2];
	 
	      
	        while (i <= j) 
	        {
	            while (arr[i] < pivot)
	                i++;
	            while (arr[j] > pivot)
	                j--;
	            if (i <= j) 
	            {
	                temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	 
	                i++;
	                j--;
	            }
	        }
	 
	        
	        if (low < j)
	            quickSort(arr, low, j);
	      
	        if (i < high)
	            quickSort(arr, i, high);
	    }
   static int smaller_number(int[] arr,int index){
            
       for(int i=0;i<index;i++){
           if(arr[i]<arr[index]){
               return i;
           }
       }
       return -1;
   }
 static int max_number(int []arr,int start_index,int last_index){
        int max=arr[start_index];
           int index=0;
     for(int i=start_index;i<last_index;i++){
         if(arr[i]>max){
             max=arr[i];
             index=i;
         }
     }
     return index;
 }

 static int maxDifference(int[] a) {
       int start_index=0,last_index=a.length;
     int flag=0;
    int max_diff;
     
     int max_index=max_number(a,start_index,last_index);
     if(max_index==0){
           start_index++;
         while(max_index < start_index && start_index<a.length){  
            max_index=max_number(a,start_index,last_index);
             start_index++;
      }
         if(start_index==a.length){
             return -1;
         }
         else{
                sort(a,start_index,max_index);
                  max_diff=a[max_index]-a[start_index];
               return max_diff;
         }
     }
      else{
          sort(a,start_index,max_index);
         // System.out.println("Sorted array");
          //for(int i : a){
           //   System.out.print(i+"  ");
         // }
          max_diff=a[max_index]-a[start_index];
          return max_diff;
      }
    
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  Scanner scan=new Scanner(System.in);
  System.out.println("Enter the size of array");
    int len=scan.nextInt();
    int arr[]=new int[len];
    System.out.println("Enter the elements in array");
    for(int i=0;i<arr.length;i++){
    	arr[i]=scan.nextInt();
    }
        int max_difference=maxDifference(arr);
    
      System.out.println(max_difference);
	}

}
