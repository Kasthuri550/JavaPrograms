package DynamicProgramming;

import java.util.Arrays;

public class Knapsack0by1 {

	public static void main(String[] args) {

		int capacity = 4, val[] = {1, 2, 3}, wt[] = {4, 5, 1},n=wt.length;

		//		System.out.println(knapsackBrute(n-1,wt,val,capacity));
		//		System.out.println(knapsackMemo(n, wt, val, capacity));
//		System.out.println(knapsackTabulation(n, wt, val, capacity));
		System.out.println(knapsackSpaceOptimized1(n, wt, val, capacity));
		System.out.println(knapsackSpaceOptimized2(n, wt, val, capacity));
		
	}

	private static int knapsackSpaceOptimized2(int n, int[] wt, int[] val, int capacity) {
		
		int prev[]=new int[capacity+1];

		for(int weight=wt[0];weight<=capacity;weight++)
		{
			prev[weight]=val[0];
		}

		for(int index=1;index<n;index++)
		{
			for(int weight=capacity;weight>=0;weight--)
			{
				int notTake=0+prev[weight];
				int take=Integer.MIN_VALUE;

				if(wt[index]<=weight)
				{
					take=val[index]+prev[weight-wt[index]];
				}

				prev[weight]=Math.max(notTake, take);
			}
			
		}

		return prev[capacity];
	}

	private static int knapsackSpaceOptimized1(int n, int[] wt, int[] val, int capacity) {

		int prev[]=new int[capacity+1];
		int curr[]=new int[capacity+1];

		for(int weight=wt[0];weight<=capacity;weight++)
		{
			prev[weight]=val[0];
		}

		for(int index=1;index<n;index++)
		{
			for(int weight=0;weight<=capacity;weight++)
			{
				int notTake=0+prev[weight];
				int take=Integer.MIN_VALUE;

				if(wt[index]<=weight)
				{
					take=val[index]+prev[weight-wt[index]];
				}

				curr[weight]=Math.max(notTake, take);
			}
			
			prev=curr.clone();
		}

		return prev[capacity];
	}

	private static int knapsackTabulation(int n, int[] wt, int[] val, int capacity) {

		int dp[][]=new int[n][capacity+1];

		for(int weight=wt[0];weight<=capacity;weight++)
		{
			dp[0][weight]=val[0];
		}

		for(int index=1;index<n;index++)
		{
			for(int weight=0;weight<=capacity;weight++)
			{
				int notTake=0+dp[index-1][weight];
				int take=Integer.MIN_VALUE;

				if(wt[index]<=weight)
				{
					take=val[index]+dp[index-1][weight-wt[index]];
				}

				dp[index][weight]=Math.max(notTake, take);
			}
		}

		return dp[n-1][capacity];
	}

	private static int knapsackMemo(int n, int[] wt, int[] val, int capacity) {

		int dp[][]=new int[n][capacity+1];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		return knapsackMemoization(n-1,wt,val,capacity,dp);
	}

	private static int knapsackMemoization(int index, int[] wt, int[] val, int capacity,int dp[][]) {

		if(index==0)
		{
			if(wt[index]<=capacity)
			{
				return val[index];
			}

			return 0;
		}

		if(dp[index][capacity]!=-1) return dp[index][capacity];

		int notTake=0+knapsackBrute(index-1, wt, val, capacity);
		int take=Integer.MIN_VALUE;

		if(wt[index]<=capacity)
			take=val[index]+knapsackBrute(index-1, wt, val,capacity-wt[index]);

		return Math.max(notTake, take);		
	}

	private static int knapsackBrute(int index, int[] wt, int[] val, int capacity) {

		if(index==0)
		{
			if(wt[index]<=capacity)
			{
				return val[index];
			}

			return 0;
		}

		int notTake=0+knapsackBrute(index-1, wt, val, capacity);
		int take=Integer.MIN_VALUE;

		if(wt[index]<=capacity)
			take=val[index]+knapsackBrute(index-1, wt, val,capacity-wt[index]);

		return Math.max(notTake, take);		
	}
}
