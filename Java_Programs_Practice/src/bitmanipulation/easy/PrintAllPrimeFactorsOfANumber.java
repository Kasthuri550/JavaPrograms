package bitmanipulation.easy;

import java.util.ArrayList;

public class PrintAllPrimeFactorsOfANumber {

	public static void main(String[] args) {

		int N = 100;

		System.out.println(printAllPrimeFactorsOfANumberApproach1(N));	
		System.out.println(printAllPrimeFactorsOfANumberApproach2(N));
		System.out.println(printAllPrimeFactorsOfANumberApproach3(N));
		System.out.println(printAllPrimeFactorsOfANumberApproach4(N));
	}
	/*
	 * Time Complexity: O(sqrt(n) * log n)
	 * Space Complexity: O(log n)
	 * */
	private static ArrayList<Integer> printAllPrimeFactorsOfANumberApproach4(int n) {

		ArrayList<Integer> list=new ArrayList<>();

		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				list.add(i);

				while(n%i==0)
				{
					n=n/i;
				}
			}
		}

		if(n!=1)
			list.add(n);


		return list;
	}

	/*
	 * Time Complexity: O(n) worst-case, O(sqrt(n)) average
	 * Space Complexity: O(log n)(very rare) 
	 * */	
	private static ArrayList<Integer> printAllPrimeFactorsOfANumberApproach3(int n) {

		ArrayList<Integer> list=new ArrayList<>();

		for(int i=2;i<=n;i++)
		{
			if(n%i==0)
			{
				list.add(i);

				while(n%i == 0)
				{
					n=n/i;
				}
			}
		}

		return list;
	}
	/*
	 * Time Complexity: O(sqrt(n) * 2 * sqrt(n))
	 * Space Complexity: O(no. of prime factors)
	 * */
	private static ArrayList<Integer> printAllPrimeFactorsOfANumberApproach2(int n) {

		ArrayList<Integer> list=new ArrayList<>();

		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				if(primeNumber(i))
				{
					list.add(i);
				}

				if(n/i!=i)
				{
					if(primeNumber(n/i))
						list.add(n/i);
				}
			}
		}

		return list;
	}

	/*
	 * Time Complexity: O(n*Sqrt(n))
	 * Space Complexity: O(no. of prime factors)
	 * */	
	private static ArrayList<Integer> printAllPrimeFactorsOfANumberApproach1(int n) {

		ArrayList<Integer> list=new ArrayList<>();

		for(int i=2;i<=n;i++)
		{
			if(n%i==0)
			{
				if(primeNumber(i))
				{
					list.add(i);
				}
			}
		}

		return list;
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
