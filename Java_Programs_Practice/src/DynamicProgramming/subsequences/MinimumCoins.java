package DynamicProgramming.subsequences;

import java.util.Arrays;

public class MinimumCoins {

	public static void main(String[] args) {

		int arr[] = {1, 2, 5}, amount = 11;

		System.out.println(minimumCoinsRecurrsion(arr,arr.length-1,amount));
		System.out.println(minimumCoinsMemoization(arr,arr.length, amount));
		System.out.println(minimumCoinsTabulation(arr,arr.length, amount));
		System.out.println(minimumCoinsSpaceOptimized(arr,arr.length, amount));
	}

	/*
	 * Time Complexity: O(n*amount)
	 * Space Complexity: O(amount)
	 * */
	private static int minimumCoinsSpaceOptimized(int[] arr, int n, int amount) {

		int prev[]=new int[amount+1];
		int curr[]=new int[amount+1];

		for(int target=0;target<=amount;target++)
		{
			if(target%arr[0]==0)
				prev[target]=target/arr[0];
			else
				prev[target]=(int)1e9;
		}

		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=amount;j++)
			{
				int notTake=0+prev[j];
				int take=Integer.MAX_VALUE;
				if(arr[i]<=j)
				{
					take=1+curr[j-arr[i]];
				}

				curr[j]=Math.min(notTake, take);
			}

			prev=curr.clone();
		}

		return prev[amount];
	}

	/*
	 * Time Complexity: O(n*amount)
	 * Space Complexity: O(n*amount)
	 * */
	private static int minimumCoinsTabulation(int[] arr, int n, int amount) {

		int dp[][]=new int[n][amount+1];

		for(int target=0;target<=amount;target++)
		{
			if(target%arr[0]==0)
				dp[0][target]=target/arr[0];
			else
				dp[0][target]=(int)1e9;
		}

		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=amount;j++)
			{
				int notTake=0+dp[i-1][j];
				int take=Integer.MAX_VALUE;
				if(arr[i]<=j)
				{
					take=1+dp[i][j-arr[i]];
				}

				dp[i][j]=Math.min(notTake, take);
			}
		}

		int result = dp[n - 1][amount];
		return result >= (int) 1e9 ? -1 : result;
	}

	/*
	 * Time Complexity: O(n*amount)
	 * Space Complexity: O(n*amount)
	 * */
	private static int minimumCoinsMemoization(int[] arr, int n, int amount) {

		int dp[][]=new int[n][amount+1];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return minimumCoinsMemo(arr, n-1, amount,dp);
	}

	private static int minimumCoinsMemo(int[] arr, int n, int amount, int[][] dp) {

		if(n==0)
		{
			if(amount%arr[0]==0) return amount/arr[0];

			return (int)1e9;
		}

		if(dp[n][amount]!=-1) return dp[n][amount];

		int notTake=0+minimumCoinsMemo(arr, n-1, amount, dp);
		int take=Integer.MAX_VALUE;
		if(arr[n]<=amount)
		{
			take=1+minimumCoinsMemo(arr,n,amount-arr[n], dp);
		}

		return dp[n][amount]=Math.min(notTake, take);
	}

	/*
	 * Time Complexity: O(2^amount)
	 * Space Complexity: O(amount)
	 * */	
	private static int minimumCoinsRecurrsion(int[] arr, int n, int amount) {

		if(n==0)
		{
			if(amount%arr[0]==0) return amount/arr[0];

			return (int) 1e9;
		}

		int notTaken=0+minimumCoinsRecurrsion(arr, n-1, amount);
		int taken=Integer.MAX_VALUE;
		if(arr[n]<=amount)
		{
			taken=1+minimumCoinsRecurrsion(arr,n,amount-arr[n]);
		}

		return Math.min(notTaken, taken);
	}
}
