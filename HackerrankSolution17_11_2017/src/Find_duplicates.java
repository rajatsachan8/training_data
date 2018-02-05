import java.util.*;
public class Find_duplicates {
	
	static int[] merge_array(int arr1[],int arr2[],int size){
		int merge_arr[]=new int[size];
		int end_index=0,k=0;
		for(int i=0;i<arr1.length;i++){
			merge_arr[i]=arr1[i];
			
		}
		int start_index=arr1.length;
		for(int i=start_index;i<merge_arr.length;i++,k++){
			merge_arr[i]=arr2[k];
			   
		}
		
		return merge_arr;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the size of 1st Array");
        int n1=scan.nextInt();
        int arr1[]=new int[n1];
        System.out.println("Enter the elements in Array 1");
        for(int i=0;i<arr1.length;i++){
        	arr1[i]=scan.nextInt();
        }
        
        System.out.println("Enter the size of 2nd Array");
        int n2=scan.nextInt();
        int arr2[]=new int[n2];
        System.out.println("Enter the elements in Array 2");
        for(int i=0;i<arr2.length;i++){
        	arr2[i]=scan.nextInt();
        }
        
        int merge_size=n1+n2;
        int merge_arr[]=merge_array(arr1,arr2,merge_size);
        System.out.println("Merged Array");
        for(int j:merge_arr){
        	System.out.print(j+"  ");
        }
        System.out.println();
        Arrays.sort(merge_arr);
        
        
        int count=0,index=0,k=0;
        int num[]=new int[merge_arr.length];
        int freq[]=new int[merge_arr.length];
          
          for(int i=0;i<merge_arr.length;i++){
              count=0;
               for(int j=k;j<merge_arr.length;j++){
                   //System.out.println("Number= "+arr[k]+"  compared with="+arr[j]+" value of j="+j +"   value of k="+k);
                   
                    if(merge_arr[k]==merge_arr[j]){
                       count++;
                    //  System.out.println("count="+count);
                        num[index]=merge_arr[k];
                       freq[index]=count;
                         }
                         else {
                       
                       num[index]=merge_arr[k];
                       freq[index]=count;
                      // System.out.println("Number inserted="+num[index]+" frequency inserted="+freq[index]);
                       index++;
                       k=j;
                      // System.out.println("value of index="+index+"  value of k="+k);
                       break;
                       }
               }
          }
          
         /*System.out.println("Number");
         for(int i:num){
        	 System.out.print(i+" ");
         }
         System.out.println();
         
         System.out.println("Frequency");
         for(int j:freq){
        	 System.out.print(j+" ");
         }
         System.out.println();*/
         for(int i=0;i<freq.length;i++){
        	 if(freq[i]>1){
        		 System.out.print(num[i]+"  ");
        	 }
         }
	}

}
