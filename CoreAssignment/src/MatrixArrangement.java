import java.util.*;
public class MatrixArrangement {
 
	public static void right_update(int arr[],int index,int value){
		//System.out.println("length= "+arr.length+"  index="+index+"  value= "+value);
	   arr[index]=value;
	}
	public static void left_update(int arr[],int index,int value){
		//System.out.println("length= "+arr.length+"  index="+index+"  value= "+value);
		arr[index]=value;
	}
	public static int [] arrangeElements(int[][]inputArray) { 
		   //System.out.println(inputArray.length);
		int row=inputArray.length;
		int column=inputArray[0].length;
		int size=row*column;
		int linear_arr[]=new int[size];
	        int k=0;
	    
	        for(int i=0;i<inputArray.length;i++){
	        	for(int j=0;j<inputArray[0].length;j++){
	        		linear_arr[k]=inputArray[i][j];
	        		k++;
	        	}
	        }
	       
	        Arrays.sort(linear_arr);
	        
	        int arr[]=new int[linear_arr.length];
	        int mid= linear_arr.length/2-1;
	        arr[mid]=linear_arr[0];
	        int index=1;
	          //System.out.println("mid= "+mid);
	        for(int i=1;i<linear_arr.length-1;i++){
	        	
	        	if(i==1 || i%2!=0)
	        	{     //System.out.println("index"+(mid+index)+"  "+"value= "+linear_arr[i]);
	        		right_update(arr,(mid+index),linear_arr[i]);
	        	}
	        	if(i%2==0){
	        		 //System.out.println("index"+(mid-index)+"  "+"value= "+linear_arr[i]);
	        		left_update(arr,(mid-index),linear_arr[i]);
	        		index++;
	        	}
	        }
	        arr[arr.length-1]=linear_arr[linear_arr.length-1];
	        return arr;
		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner scan=new Scanner(System.in);
     int n,m;
        System.out.println("Enter the size of 2D array");
        while(true){
        	try{
        		System.out.println("Enter rows");
                 n=scan.nextInt();
                System.out.println("Enter columns");
                 m=scan.nextInt();
                break;
        	}
        	catch(InputMismatchException e){
        		System.out.println("Kindly enter digits");
        		scan=new Scanner(System.in);
        	}
        }
        
        int twoD_arr[][]=new int[n][m];
        System.out.println("Enter array elements");
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
        		twoD_arr[i][j]=scan.nextInt();
        	}
        }
        
        
       //System.out.println("row= "+twoD_arr.length+" column= "+twoD_arr[0].length);
        	int arr[]=arrangeElements(twoD_arr);
		for(int i:arr){
			System.out.print(i+" ");
		}
        
	}

}
