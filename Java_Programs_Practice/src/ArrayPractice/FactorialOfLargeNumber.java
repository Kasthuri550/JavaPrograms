package ArrayPractice;

import java.math.BigInteger;

public class FactorialOfLargeNumber {

	public static void main(String[] args) {
		
		int n=22;
		
		System.out.println(factorial(n));

	}

	private static BigInteger factorial(int n) {
		
		BigInteger factorial=BigInteger.ONE;
		
		for(int i=1;i<=n;i++)
		{
			factorial=factorial.multiply(BigInteger.valueOf(i));
		}
		
		return factorial;
	}
}
