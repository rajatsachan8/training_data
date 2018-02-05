import java.util.*;

public class Triplets {
	public static int linear_search(int arr[],int index,int value){
	         int data=-2;
	     for(int i=index+1;i<arr.length;i++){
	    	 if(arr[i]==value){
	    		 data=value;
	    	 }
	     }
		return data;
	}
	
	public static void printTriplets(int[] data) {
		Arrays.sort(data);
		int sum,flag=-1,number;	
		ArrayList list=new ArrayList();
		
		for(int i=0;i<data.length;i++){
			for(int j=i+1;j<data.length-1;j++){
				sum=data[i]+data[j];
				//System.out.println(data[i]+  "   "+data[j]);
			    flag=linear_search(data,j,sum);
			    
			    if(flag>=0){
			    	//
			    	number=10*data[i]+data[j];
			    	if(list.contains(number)){
			    		
			    	}
			    	else{
			    		System.out.println("< "+data[i]+",  "+data[j]+",  "+flag+" >");
			    		list.add(number);
			    	}
			    	//i=j;
			    	//break;
			    }
			}
		}
		if(list.size()==0){
			System.out.println("No Triplets Found");
		}
	}
	
	
    
	public static void print_all_triplets(int[] arr) {
		    Arrays.sort(arr);
		    int sum,flag=-1,number;
		    ArrayList list=new ArrayList();
		    for(int i=0;i<arr.length;i++){
				for(int j=0;j<arr.length-1;j++){
					if(i!=j){
						sum=arr[i]+arr[j];
						//System.out.println(arr[i]+  "   "+arr[j]);
					    flag=linear_search_neg(arr,j,sum);
					    
					    if(flag>-50){
					    	//
					    	number=10*arr[i]+arr[j];
					    	if(list.contains(number)){
					    		
					    	}
					    	else{
					    		if(arr[i]!=flag && arr[j]!=flag)
					    		System.out.println("< "+arr[i]+",  "+arr[j]+",  "+flag+" >");
					    		list.add(number);
					    	}
					    	//i=j;
					    	//break;
					    }
					}
					
				}
				
				
			}
		    if(list.size()==0){
				System.out.println("No Triplets Found");
			}
	}

	private static int linear_search_neg(int[] arr,int index, int value) {
		 int data=-100;
	     for(int i=index;i<arr.length;i++){
	    	 if(arr[i]==value){
	    		 data=value;
	    	 }
	     }
		return data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
         Scanner scan=new Scanner(System.in);
         int n;
         while(true){
        	 try{
        		 System.out.println("Enter the array size");
                  n=scan.nextInt();
                 break;
        	 }
        	 catch(InputMismatchException e){
        		 System.out.println("Wrong value entered...enter digits.");
        		 scan=new Scanner(System.in);
        	 }
         }
          
          int arr[]=new int[n];
          int flag=1;
          System.out.println("Enter the array element");
          for(int i=0;i<n;i++){
        	  while(true){
        		  try{
        			  arr[i]=scan.nextInt();  
                	  if(arr[i]<0){
                		  flag=-1;
                	  }
                	  break;
        		  }
        		  catch(InputMismatchException e){
        			  System.out.println("Enter Digits.....");
        			  scan=new Scanner(System.in);
        		  }
        	  }
        	  
          }
          if(flag>=0){
        	  printTriplets(arr);
          }
          else{
        	  print_all_triplets(arr);
          }
          
	}

	

}
