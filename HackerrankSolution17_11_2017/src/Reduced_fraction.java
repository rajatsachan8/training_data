import java.util.*;

public class Reduced_fraction {


    static int greatest_common_factor(int a, int b)
  {
      
      if (a == 0 || b == 0)
         return 0;
        
      if (a == b)
          return a;
   
      if (a > b)
          return greatest_common_factor(a-b, b);
      return greatest_common_factor(a, b-a);
  }

  static String[] reducedFractionSums(String[] expressions) {
    String output[]=new String[expressions.length];
      String temp;
      
      String fraction1,fraction2;
      StringBuilder str;
      for(int i=0;i<expressions.length;i++){
          str=new StringBuilder();
          String []arr=expressions[i].split("\\+");
          fraction1=arr[0];
          fraction2=arr[1];
          String frac1[]=fraction1.split("/");
          String frac2[]=fraction2.split("/");
          int num1=Integer.parseInt(frac1[0]);
           int deno1=Integer.parseInt(frac1[1]);
          int num2=Integer.parseInt(frac2[0]);
         int deno2=Integer.parseInt(frac2[1]);
          
          int frac11=num1*deno2;
          int frac22=deno1*num1;
          int upper_num=frac11+frac22;
          int lower_deno=deno1*deno2;
          
          int gcd=greatest_common_factor(upper_num,lower_deno);
          
          upper_num/=gcd;
          lower_deno/=gcd;
          
          fraction1=String.valueOf(upper_num);
          fraction2=String.valueOf(lower_deno);
          
          str=str.append(fraction1);
          str=str.append("/");
          str=str.append(fraction2);
          temp=str.toString();
          output[i]=temp;
      }
      return output;
      
  }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Scanner scan=new Scanner(System.in);
   
	}

}
