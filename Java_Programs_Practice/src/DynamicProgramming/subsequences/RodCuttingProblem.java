package DynamicProgramming.subsequences;

import java.util.Arrays;

public class RodCuttingProblem {

	public static void main(String[] args) {

		int N = 8,price[] = {1, 5, 8, 9, 10, 17, 17, 20};

		System.out.println(rodCuttingProblemRecurrsion(N-1,N,price));
		System.out.println(rodCuttingProblemMemoization(N,N,price));
		System.out.println(rodCuttingProblemTabulation(N,N,price));
		System.out.println(rodCuttingProblemSpaceOptimized(N,N, price));
		System.out.println(rodCuttingProblemSpaceOptimizedMore(N, N, price));
	}

	/*
	 * Time Complexity: O(index*n)
	 * Space Complexity: O(n)
	 * */
	private static int rodCuttingProblemSpaceOptimizedMore(int index, int n, int[] price) {

		int prev[]=new int[n+1];

		for(int i=0;i<=n;i++)
		{
			prev[i]=i*price[0];
		}

		for(int i=1;i<index;i++)
		{
			for(int j=0;j<=n;j++)
			{
				int notTake=0+prev[j];
				int take=Integer.MIN_VALUE;
				int rodLength=i+1;
				if(rodLength<=j)
				{
					take=price[i]+prev[j-rodLength];
				}
				prev[j]=Math.max(take, notTake);
			}
		}

		return prev[n];
	}

	/*
	 * Time Complexity: O(index*n)
	 * Space Complexity: O(n)
	 * */
	private static int rodCuttingProblemSpaceOptimized(int index, int n, int[] price) {

		int prev[]=new int[n+1],curr[]=new int[n+1];

		for(int i=0;i<=n;i++)
		{
			prev[i]=i*price[0];
		}

		for(int i=1;i<index;i++)
		{
			for(int j=0;j<=n;j++)
			{
				int notTake=0+prev[j];
				int take=Integer.MIN_VALUE;
				int rodLength=i+1;
				if(rodLength<=j)
				{
					take=price[i]+curr[j-rodLength];
				}
				curr[j]=Math.max(take, notTake);
			}

			prev=curr;
		}

		return prev[n];
	}

	/*
	 * Time Complexity: O(index*n)
	 * Space Complexity: O(index*n)
	 * */
	private static int rodCuttingProblemTabulation(int index, int n, int[] price) {

		int dp[][]=new int[index][n+1];

		for(int i=0;i<=n;i++)
		{
			dp[0][i]=i*price[0];
		}

		for(int i=1;i<index;i++)
		{
			for(int j=0;j<=n;j++)
			{
				int notTake=0+dp[i-1][j];
				int take=Integer.MIN_VALUE;
				int rodLength=i+1;
				if(rodLength<=j)
				{
					take=price[i]+dp[i][j-rodLength];
				}

				dp[i][j]=Math.max(take, notTake);
			}
		}

		return dp[index-1][n];
	}

	/*
	 * Time Complexity: O(index*n)
	 * Space Complexity: O(index*n)
	 * */
	private static int rodCuttingProblemMemoization(int index, int n, int[] price) {

		int dp[][]=new int[index][n+1];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return rodCuttingProblemMemo(index-1, n, price,dp);
	}

	private static int rodCuttingProblemMemo(int index, int n, int[] price, int[][] dp) {

		if(index==0)
		{
			return n*price[0];
		}

		if(dp[index][n]!=-1) return dp[index][n];

		int notTake=0+rodCuttingProblemMemo(index-1, n, price, dp);
		int take=Integer.MIN_VALUE;
		int rodLength=index+1;
		if(rodLength<=n)
		{
			take=price[index]+rodCuttingProblemMemo(index,n-rodLength, price, dp);
		}

		return dp[index][n]=Math.max(take, notTake);
	}

	/*
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(n)
	 * */	
	private static int rodCuttingProblemRecurrsion(int index,int n, int[] price) {

		if(index==0)
		{
			return n*price[0];
		}

		int notTake=0+rodCuttingProblemRecurrsion(index-1,n,price);
		int take=Integer.MIN_VALUE;
		int rodLength=index+1;
		if(rodLength<=n)
		{
			take=price[index]+rodCuttingProblemRecurrsion(index,n-rodLength,price);
		}

		return Math.max(notTake, take);
	}
}
