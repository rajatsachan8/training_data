package classtest;
import java.util.*;
public class Test {
    

    /*
     * Complete the function below.
     */
	static int number_of_cuts(int arr[],int cut_length){
		int cut=0;
		
		cut=number_of_nonzero(arr);
		  for(int i=0;i<arr.length;i++){
			  if(arr[i]>0){
				  arr[i]-=cut_length;
			  }
		  }
		return cut;
	}
	static int number_of_nonzero(int arr[]){
		int count=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>0){
				count++;
			}
		}
		return count;
	}
	  static int sum_of_arr(int arr[]){
		  int sum=0;
		  for(int i=0;i<arr.length;i++){
			  sum+=arr[i];
		  }
		  
		  if(sum>0)
			  return sum;
		  else
			  return 0;
	  }
	  static int mini_length(int arr[]){
		  int k=0;
		  int mini_len=arr[k];
		  while(arr[k]<0){
			  k++;
		  }
		  mini_len=arr[k];
		  for(int i=k;i<arr.length;i++){
			  if(arr[i]<mini_len){
				  mini_len=arr[i];
			  }
			  
		  }
		  return mini_len;
	  }
	    static int[] cutSticks(int[] lengths) {
	            
	         int cut_arr[]=new int[lengths.length];
	    	
	         
	         int cuts=0,i=0;
	         int mini_length;
	          int sum_of_array=sum_of_arr(lengths);
	          if(sum_of_array>0){
	        	  mini_length=mini_length(lengths);
	          }
	          while(sum_of_array>0){
	        	  mini_length=mini_length(lengths);
	        	  cuts=number_of_cuts(lengths,mini_length);
	        	  	cut_arr[i]=cuts;
	        	  	i++;
	        	  sum_of_array=sum_of_arr(lengths);
	          }
	         
	          
	         return cut_arr;  
	    }


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
      int arr[]={5,4,4,2,2,8};
      int new_arr[]=cutSticks(arr);
      System.out.println("cut array");
      for(int i:new_arr){
    	  System.out.print(i+"  ");
      }
      
	}

}
