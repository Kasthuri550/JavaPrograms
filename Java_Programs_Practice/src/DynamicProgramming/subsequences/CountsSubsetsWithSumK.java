package DynamicProgramming.subsequences;

import java.util.Arrays;

public class CountsSubsetsWithSumK {

	public static void main(String[] args) {

		int arr[] = {1, 2, 2, 3};
		int sum = 3;

		System.out.println(countsSubsetsWithSumKRecurrsion(arr,arr.length-1,sum));
		System.out.println(countsSubsetsWithSumKMemoization(arr,arr.length-1, sum));
		System.out.println(countsSubsetsWithSumKTabulation(arr,arr.length, sum));
		System.out.println(countsSubsetsWithSumKSpaceOptimized(arr,arr.length-1, sum));
	}

	/*
	 * Time Complexity: O(n*sum)
	 * Space Complexity: O(sum)
	 * */
	private static int countsSubsetsWithSumKSpaceOptimized(int[] arr, int n, int sum) {

		int prev[]=new int[sum+1];
		int curr[]=new int[sum+1];

		prev[0]=1;

		if(arr[0]<=sum) prev[arr[0]]=1;

		for(int i=1;i<n;i++)
		{
			curr[0]=1;
			for(int j=1;j<=sum;j++)
			{
				int notTaken=prev[j];
				int taken=0;

				if(arr[i]<=j)
				{
					taken=prev[j-arr[i]];
				}

				curr[j]=notTaken+taken;
			}
			prev=curr.clone();
		}

		return prev[sum];
	}

	/*
	 * Time Complexity: O(n*sum)
	 * Space Complexity: O(n*sum)
	 * */
	private static int countsSubsetsWithSumKTabulation(int[] arr, int n, int sum) {

		int dp[][]=new int[n][sum+1];

		for(int i=0;i<n;i++)
		{
			dp[i][0]=1;
		}

		if(arr[0]<=sum) dp[0][arr[0]]=1;

		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				int notTake=dp[i-1][j];
				int take=0;

				if(arr[i]<=j)
				{
					take=dp[i-1][j-arr[i]];
				}

				dp[i][j]=take+notTake;
			}
		}

		return dp[n-1][sum];
	}

	/*
	 * Time Complexity: O(n*sum)
	 * Space Complexity: O(n*sum)
	 * */
	private static int countsSubsetsWithSumKMemoization(int[] arr, int n, int sum) {

		int dp[][]=new int[n+1][sum+1];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return countsSubsetsWithSumKMemo(arr,n,sum,dp);
	}

	private static int countsSubsetsWithSumKMemo(int[] arr, int n, int sum, int[][] dp) {

		if(sum==0) return 1;

		if(n==0) return (arr[0]==sum)?1:0;

		if(dp[n][sum]!=-1) return dp[n][sum];

		int notTake=countsSubsetsWithSumKMemo(arr, n-1, sum, dp);
		int take=0;
		if(arr[n]<=sum)
		{
			take=countsSubsetsWithSumKMemo(arr, n-1, sum-arr[n], dp);
		}

		return dp[n][sum]=take+notTake;
	}

	/*
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(n)
	 * */	
	private static int countsSubsetsWithSumKRecurrsion(int[] arr, int n, int sum) {

		if(sum==0) return 1;

		if(n==0) return (arr[0]==sum)?1:0;

		int notTake=countsSubsetsWithSumKRecurrsion(arr,n-1,sum);
		int take=0;
		if(arr[n]<=sum)
		{
			take=countsSubsetsWithSumKRecurrsion(arr, n-1,sum-arr[n]);
		}

		return take+notTake;
	}
}
