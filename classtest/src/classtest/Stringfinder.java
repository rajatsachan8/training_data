package classtest;
import java.util.*;
public class Stringfinder {
	
	private char array[];
    private int length;
    
  public static int uppercase(char arr[]){
	  int count=0;
	     for(int i=0;i<arr.length;i++){
	    	 if(arr[i]>64 && arr[i]<92){
	    		 count++;
	    	 }
	     }
	  return count;
  }
  public static String ret_Uppercase_string(char arr[]){
	  String str;
	  StringBuilder str1=new StringBuilder();
	  for(int i=0;i<arr.length;i++){
		  if(arr[i]>64 && arr[i]<92){
			  str1=str1.append(arr[i]);
		  }
		  
	  }
	  str=str1.toString();
	  
	  return str;
  }
     public static int string_length(char[] ch){
    	 int count=ch.length;
    	 return count;
     }
     
     public static boolean driver_function(){
    	 Scanner scan=new Scanner(System.in);
    	 System.out.println("Enter the String");
    	 String str=scan.next();
    	 char ch_arr[]=str.toCharArray();
    	 int length=string_length(ch_arr);
    	 int flag=0;
    	 if(length<10){
    		 driver_function();
    	 }
    	 else{
    		 int uppercase_number=uppercase(ch_arr);
    		 if(uppercase_number<5){
    			 driver_function();
    		 }
    		 else {
    			 String Uppercase_string=ret_Uppercase_string(ch_arr);
    			 System.out.println("Uppercase String="+ Uppercase_string);
        		 System.out.println("Searching for Z");
        		 char ch_string[]=Uppercase_string.toCharArray();
        		 //Arrays.sort(ch_string);
        		char ch='Z';
        		  Stringfinder sorter=new Stringfinder();
        		 sorter.sort(ch_string);
        		  flag=binarySearch(ch_string,0,((ch_string.length)-1),ch);
        		
    		 }
    	 }
    	 
//    	 int count=ch.length;
//    	 
//    	 return count;
    	 if(flag<0){
    		 System.out.println("Cannot find the Z character");
    		 return false;
    	 }
    	 else
    	 {  System.out.println("Character Z found");
    		 return true;
    	 }
     }
     
     static int binarySearch(char arr[], int l, int r, char x)
     {
         if (r>=l)
         {
             int mid = l + (r - l)/2;

             if (arr[mid] == x)
                return mid;
  
             if (arr[mid] > x)
                return binarySearch(arr, l, mid-1, x);
  
             return binarySearch(arr, mid+1, r, x);
         }
         return -1;
     }
     
     public void sort(char[] inputArr) {
     if (inputArr == null || inputArr.length == 0) {
         return;
     }
     this.array = inputArr;
     length = inputArr.length;
     quickSort(0, length - 1);
 }
  private void quickSort(int lowerIndex, int higherIndex) {
    
    int i = lowerIndex;
    int j = higherIndex;
    
    char pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
    
    while (i <= j) {
       
        while (array[i] < pivot) {
            i++;
        }
        while (array[j] > pivot) {
            j--;
        }
        if (i <= j) {
            exchangeNumbers(array[i], array[j]);
            
            i++;
            j--;
        }
    }
    
    if (lowerIndex < j)
        quickSort(lowerIndex, j);
    if (i < higherIndex)
        quickSort(i, higherIndex);
}

private void exchangeNumbers(char i, char j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
     
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner scan=new Scanner(System.in);
         
         boolean result=driver_function();
         
         if(result){
        	 System.out.println("Congratulations");
         }
         else {
        	 result=driver_function();
         }
         
          
             
             }    
	}

