package Basicmaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Time Complexity: O(n log log n)
 * Space Complexity: O(n)
 * */
public class PrimeFactorizationForMultipleQueriesUsingSieve {

	public static void main(String[] args) {

		int arr[] = {15, 17, 21};

		List<List<Integer>> result=primeFactorization(arr);
		System.out.println(result);
	}

	private static List<List<Integer>> primeFactorization(int[] arr) {

		int max = Arrays.stream(arr).max().getAsInt();
		int[] spf=sieve(arr,max);

		List<List<Integer>> result=new ArrayList<>();

		for(int num:arr)
		{
			result.add(getPrimeFactors(num,spf));
		}

		return result;
	}

	private static List<Integer> getPrimeFactors(int num, int[] spf) {

		List<Integer> result=new ArrayList<Integer>();

		while(num!=1)
		{
			result.add(spf[num]);
			num=num/spf[num];
		}

		return result;
	}

	private static int[] sieve(int[] arr,int n)
	{
		int spf[]=new int[n+1];

		for(int i=1;i<=n;i++)
		{
			spf[i]=i;
		}

		for(int i=2;i*i<=n;i++)
		{
			if(spf[i]==i)
			{
				for(int j=i*i;j<=n;j+=i)
				{
					if(spf[j]==j)
					{
						spf[j]=i;
					}
				}
			}
		}

		return spf;
	}
}
