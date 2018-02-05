import java.util.*;
public class SlotMachine2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lengths[]={26,103,59};
		 int costpercut=1, saleprice=10;
	        int optimal_length=0;
	        int final_optimal_cost=0,optimal_cost=0,total_uniform_rod=0,total_cut=0;
	        
	          int number_uniform_rod[]=new int[lengths.length];
	          int number_cut[]=new int[lengths.length];
	             Arrays.sort(lengths);
	        
	        do{
	            ++optimal_length;
	             final_optimal_cost=optimal_cost;
	        total_uniform_rod=0;
	        total_cut=0;
	            
	            for(int i=0;i<lengths.length;i++){
	                number_uniform_rod[i]=lengths[i]/optimal_length;
	                if(lengths[i]/optimal_length==0)
	                    number_cut[i]=number_uniform_rod[i]-1;
	                    else
	                     number_cut[i]=number_uniform_rod[i];
	            }
	            
	            for(int i=0;i<lengths.length;i++){
	                System.out.println("number rod="+number_uniform_rod[i]+"   number cuts="+number_cut[i]);
	            }
	            
	            for(int j=0;j<number_uniform_rod.length;j++){
	                total_uniform_rod+=number_uniform_rod[j];
	                total_cut+=number_cut[j];
	            }
	             System.out.println("total rod="+total_uniform_rod+ "    total cuts="+ total_cut);
	              System.out.println( optimal_cost +"    "+"   optimal length="+optimal_length);
	            
	            optimal_cost=(saleprice*total_uniform_rod*optimal_length)-(total_cut*costpercut);
	           
	        }while(optimal_length<lengths[0]);
	            
	        
	}

}
