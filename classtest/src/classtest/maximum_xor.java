package classtest;

public class maximum_xor {
    static int maximum_XOR(int a, int b) {
        int max=0;
          if(a==b)
              return 0;
          
          else 
          {
              for(int i=a;i<b;i++){
                  for(int j=i+1;j<=b;j++){
                      int binary=i^j;
                      if(binary > max)
                          max=binary;
                      
                  }
              }
          }
          return max;
      }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(maximum_XOR(10,15));
	}

}
