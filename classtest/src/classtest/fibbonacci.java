package classtest;
import java.util.*;
public class fibbonacci {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner scan=new Scanner(System.in);
      int n=scan.nextInt();
      int t1=0,t2=1,nextTerm;
      for (int i = 1; i <= n; ++i)
      {
          System.out.println(t1);
          nextTerm = t1 + t2;
          t1 = t2;
          t2 = nextTerm;
      }
	}

}
