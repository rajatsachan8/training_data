import java.util.*;

public class can_you_sort {


    /*
     * Complete the function below.
     */
    static void customSort(int[] arr) {
               Arrays.sort(arr);
        int count,index=0,k=0;
        int freq_length=0;
        int num[]=new int[arr.length];
        int freq[]=new int[arr.length];
          
          for(int i=0;i<arr.length;i++){
              count=0;
               for(int j=k;j<arr.length;j++){
                   //System.out.println("Number= "+arr[k]+"  compared with="+arr[j]+" value of j="+j +"   value of k="+k);
                   
                    if(arr[k]==arr[j]){
                       count++;
                    //  System.out.println("count="+count);
                        num[index]=arr[k];
                       freq[index]=count;
                         }
                         else {
                       
                       num[index]=arr[k];
                       freq[index]=count;
                      // System.out.println("Number inserted="+num[index]+" frequency inserted="+freq[index]);
                       index++;
                       k=j;
                      // System.out.println("value of index="+index+"  value of k="+k);
                       break;
                       }
                   
               }
              freq_length++;
              

          }
        

         int max_freq=0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                if(freq[i]>max_freq){
                    max_freq=freq[i];
                }
            }
        }
        //System.out.println("Max Freq="+max_freq);
        System.out.println("max frequency="+max_freq);
        System.out.println();
          for(int i=1;i<=max_freq;i++){
              for(int j=0;j<freq_length;j++){
                  if(freq[j]==i){
                       for(int ij=0;ij<freq[j];ij++){
                    	   System.out.println(num[j]);
                       }
                  }
              }
        }
        
        

   }
   
   


	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[]={3,1,2,2,4};
      customSort(arr);
		
	}

}
