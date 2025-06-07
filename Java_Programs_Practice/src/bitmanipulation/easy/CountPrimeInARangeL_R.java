package bitmanipulation.easy;

import java.util.Arrays;

public class CountPrimeInARangeL_R {

	public static void main(String[] args) {

		int queries=3;

		int queriesArray[][]= {{3,10},{8,20},{1,5}};

		countPrimeInARangeL_RBrute(queries,queriesArray);
		countPrimeInARangeL_RBetter(queries, queriesArray);
		countPrimeInARangeL_ROptimal(queries, queriesArray);
	}
	/*
	 * Time Complexity: O(queries)+O(n log(log n))+ O(n) +O(queries) ~ O(n log(log n) + queries)  where n=maxR
	 * Space Complexity: O(n)
	 * */	
	private static void countPrimeInARangeL_ROptimal(int queries, int[][] queriesArray) {

		int maxR=0;

		for(int i=0;i<queries;i++)
		{
			maxR=Math.max(maxR, queriesArray[i][1]);
		}

		int prime[]=getSeive(maxR),count=0;

		for(int i=2;i<=maxR;i++)
		{
			count=count+prime[i];
			prime[i]=count;
		}

		int l=0,r=0;

		for(int i=0;i<queries;i++)
		{
			l=queriesArray[i][0];
			r=queriesArray[i][1];

			System.out.println(l+" to "+r+" -> "+(prime[r]-prime[l-1]));
		}
	}

	/*
	 * Time Complexity: O(q + n log(log n) + (r-l+1))
	 * Space Complexity: O(n)
	 * */	
	private static void countPrimeInARangeL_RBetter(int queries, int[][] queriesArray) {

		int maxR = 0;
		for (int i = 0; i < queries; i++) {
			maxR = Math.max(maxR, queriesArray[i][1]);
		}

		int prime[]=getSeive(maxR);

		for(int i=0;i<queries;i++)
		{
			int l=queriesArray[i][0],r=queriesArray[i][1],count=0;

			for(int j=l;j<=r;j++)
			{
				if(prime[j]==1)
				{
					count++;
				}
			}

			System.out.println(l+" to "+r+" -> "+count);
		}
	}
	private static int[] getSeive(int n) {

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

		return prime;
	}
	/*
	 * Time Complexity: O(q + (r-l+1) + sqrt(n))
	 * Space Complexity: O(1)
	 * */
	private static void countPrimeInARangeL_RBrute(int queries, int[][] queriesArray) {

		for(int i=0;i<queries;i++)
		{
			int l=queriesArray[i][0],r=queriesArray[i][1];
			int count=0;

			for(int j=l;j<=r;j++)
			{
				if(isPrime(j))
				{
					count++;
				}
			}

			System.out.println(l+" to "+r+" -> "+count);
		}
	}

	private static boolean isPrime(int n) {

		if(n<=1)
			return false;

		int count=0;

		for(int i=1;i*i<=n;i++)
		{
			if(n%i==0)
			{
				count++;

				if(n/i!=i)
				{
					count++;
				}
			}

			if(count>2)
				break;
		}

		return count==2;
	}
}
