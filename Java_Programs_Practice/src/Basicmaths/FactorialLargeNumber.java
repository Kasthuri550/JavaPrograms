package Basicmaths;

import java.math.BigInteger;
import java.util.ArrayList;

public class FactorialLargeNumber {

	public static void main(String[] args) {
		
		int N = 10;
		
		factorial(N);

	}

	private static void factorial(int n) {
		
		BigInteger fact=new BigInteger("1");
		
		ArrayList<Integer> mulList=new ArrayList<>();
		
		for(int i=1;i<=n;i++)
		{
			fact=fact.multiply(BigInteger.valueOf(i));
		}
		
		String result=String.valueOf(fact);
		int ans=0;
		for(int i=0;i<result.length();i++)
		{
			ans=Integer.parseInt(Character.toString(result.charAt(i)));
			mulList.add(ans);
		}
		
		System.out.println(mulList);
	}
}
