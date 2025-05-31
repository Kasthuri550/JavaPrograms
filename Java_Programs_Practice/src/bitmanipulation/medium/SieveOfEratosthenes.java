package bitmanipulation.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenes {

	public static void main(String[] args) {

		int n=35;

		System.out.println(sieveOfEratosthenesBrute(n));
		sieveOfEratosthenesBetter(n);
		sieveOfEratosthenesOptimal(n);
	}
	/*
	 * Time Complexity: O(n log(log n))
	 * Space Complexity: O(n)
	 * */
	private static void sieveOfEratosthenesOptimal(int n) {

		int prime[]=new int[n+1];

		Arrays.fill(prime,2,n,1);

		for(int i=2;i*i<=n;i++)
		{
			if(prime[i]==1)
			{
				for(int j=i*i;j<=n;j+=i)
				{
					prime[j]=0;
				}
			}
		}

		System.out.println();
		for(int i=2;i<=n;i++)
		{
			if(prime[i]==1)
				System.out.print(i+" ");
		}
	}
	/*
	 * Time Complexity: O(n log(log n))
	 * Space Complexity: O(n)
	 * */
	private static void sieveOfEratosthenesBetter(int n) {

		int prime[]=new int[n+1];

		Arrays.fill(prime,2,n,1);

		for(int i=2;i<=n;i++)
		{
			if(prime[i]==1)
			{
				for(int j=2*i;j<=n;j+=i)
				{
					prime[j]=0;
				}
			}
		}

		for(int i=2;i<=n;i++)
		{
			if(prime[i]==1)
				System.out.print(i+" ");
		}
	}
	/*
	 * Time Complexity: O(n * sqrt(n))
	 * Space Complexity: O(no. of primes)
	 * */
	private static ArrayList<Integer> sieveOfEratosthenesBrute(int n) {

		ArrayList<Integer> result=new ArrayList<>();

		for(int i=2;i<=n;i++)
		{
			if(primeNumber(i))
			{
				result.add(i);
			}
		}

		return result;
	}

	private static boolean primeNumber(int n) {

		if(n<=1)
			return false;

		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
				return false;
		}

		return true;
	}
}
