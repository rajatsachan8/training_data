import java.util.*;
/**
 * @author M1043153
 *
 */
public class sorting_and_searching {
    
    private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
         
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
        
        int pivot = array[(lowerIndex+higherIndex)/2];
        
        while (i <= j) {
           
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                
                i++;
                j--;
            }
        }
        
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
    public static void main(String a[]){
         Scanner scan=new Scanner(System.in);
         
         System.out.println("Enter the number of elements in Array");
         int n=scan.nextInt();
         int arr[]=new int[n];
         System.out.println("Enter elements in array");
         for(int i=0;i<n;i++){
        	 arr[i]=scan.nextInt();
         }
        sorting_and_searching sorter = new sorting_and_searching();
        
        sorter.sort(arr);
        System.out.println("Sorted Array:");
        for(int i:arr){
            System.out.print(i+"  ");
        }
        System.out.println();
        System.out.println("Enter the element to be searched");
        int num=scan.nextInt();
        int low_index=0;
        int high_index=arr.length-1;
        int flag=binarySearch(arr,low_index,high_index,num);
        if(flag<0){
        	System.out.println("Element Not found");
        }
        else{
        	System.out.println("Element Found at ="+(flag+1));
        }
    }
    
       static int binarySearch(int arr[], int l, int r, int x)
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
}

	