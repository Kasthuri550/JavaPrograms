import java.math.BigInteger;
import java.util.ArrayList;

public class factorialLargeNumber {

	public static void main(String[] args) {
		
		int N=5;
		ArrayList<Integer> factorial = factorial(N);
		System.out.println(factorial);
		

	}
	
	static ArrayList<Integer> factorial(int N)
	{
		ArrayList<Integer> al=new ArrayList<Integer>();
		BigInteger fact=BigInteger.valueOf(1);
		int ans=0;
		
		for(int i=1;i<=N;i++)
		{
			fact=fact.multiply(BigInteger.valueOf(i));
		}
		
		String s=String.valueOf(fact);
		
		for(int j=0;j<s.length();j++)
		{
			ans = Integer.parseInt(String.valueOf(s.charAt(j)));
			al.add(ans);
		}
		
		return al;
	}

}
