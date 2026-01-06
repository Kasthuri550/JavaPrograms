package Basicmaths;

import java.util.Arrays;

public class SieveOfEratosthenes {

	public static void main(String[] args) {

		int n = 10;

		//		sieveOfEratosthenesBrute(n);
		//		sieveOfEratosthenesBetter(n);
		sieveOfEratosthenesOptimal(n);
	}

	/*
	 * Time Complexity: O(n log log n)	
	 * Space Complexity: O(n)
	 * */	
	private static void sieveOfEratosthenesOptimal(int n) {

		int prime[]=new int[n+1];

		Arrays.fill(prime,2,n+1,1);

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

		for(int i=2;i<=n;i++)
		{
			if(prime[i]==1)
			{
				System.out.print(i+" ");
			}
		}
	}
	/*
	 * Time Complexity: O(n root(n))
	 * Space Complexity: O(1)
	 * */
	private static void sieveOfEratosthenesBetter(int n) {

		for(int i=2;i<=n;i++)
		{
			if(isPrime(i))
			{
				System.out.print(i+" ");
			}
		}
	}

	private static boolean isPrime(int n) {

		if(n<=1)
			return false;

		for(int i=2;i*i<=n;i++)
		{
			if(n%i==0)
				return false;
		}

		return true;
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */	
	private static void sieveOfEratosthenesBrute(int n) {

		for(int i=2;i<=n;i++)
		{
			if(prime(i))
			{
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}

	private static boolean prime(int n) {
		if(n<=1)
			return false;

		for(int i=2;i<n;i++)
		{
			if(n%i==0)
				return false;
		}

		return true;
	}

}
