package bitmanipulation.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorisation {

	private static final int N_1E5=(int)1e5;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int queries = sc.nextInt();
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < queries; i++) {
			list.add(sc.nextInt());
		}

		sc.close();

		System.out.println("Input numbers: " + list);

		primeFactorizationBrute(list);

		primeFactorizationOptimal(list);
	}
	/*
	 * Time Complexity: O(n*log(log n))+O(q*log a)
	 * Space Complexity: O(n)
	 * */
	private static void primeFactorizationOptimal(List<Integer> list) {

		int spf[]=new int[N_1E5+1];

		for(int i=1;i<=N_1E5;i++)
		{
			spf[i]=i;
		}

		for(int i=2;i*i<=N_1E5;i++)
		{
			if(spf[i]==i)
			{
				for(int j=i*i;j<=N_1E5;j+=i)
				{
					if(spf[j]==j)
					{
						spf[j]=i;
					}
				}
			}
		}

		for(int arr:list)
		{
			int n=arr;

			while(n!=1)
			{
				System.out.print(spf[n]+" ");
				n=n/spf[n];
			}
			System.out.println();
		}
	}
	/*
	 * Time Complexity: O(sqrt(n)+log n)
	 * Space Complexity: O(log n)
	 * */
	private static void primeFactorizationBrute(List<Integer> list) {

		for (int number : list) {
			List<Integer> primeFactors = getPrimeFactorization(number);
			System.out.println("Prime factors of " + number + ": " + primeFactors);
		}
	}

	private static List<Integer> getPrimeFactorization(int n) {

		List<Integer> result=new ArrayList<>();

		for(int i=2;i*i<=n;i++)
		{
			while(n%i==0)
			{
				result.add(i);
				n=n/i;
			}
		}

		if(n>1)
			result.add(n);

		return result;
	}
}
