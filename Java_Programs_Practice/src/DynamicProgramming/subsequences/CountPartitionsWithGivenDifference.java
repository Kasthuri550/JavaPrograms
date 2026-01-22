package DynamicProgramming.subsequences;

import java.util.Arrays;

public class CountPartitionsWithGivenDifference {

	public static void main(String[] args) {

		int n = 4,d = 3,arr[] =  { 5, 2, 6, 4};

		System.out.println(countPartitionsWithGivenDifferenceRecurrsion(arr,n,d));
		System.out.println(countPartitionsWithGivenDifferenceMemoization(arr, n, d));
		System.out.println(countPartitionsWithGivenDifferenceTabulation(arr, n, d));
		System.out.println(countPartitionsWithGivenDifferenceSpaceOptimized(arr, n, d));
	}

	/*
	 * Time Complexity: O(n*target)
	 * Space Complexity: O(target)
	 * */
	private static int countPartitionsWithGivenDifferenceSpaceOptimized(int[] arr, int n, int d) {

		int totalSum=0;

		for(int i=0;i<n;i++)
		{
			totalSum+=arr[i];
		}

		if((totalSum-d)<0 && (totalSum-d)%2==1) return 0;

		return countPartitionsSpaceOptimized(arr,n-1,(totalSum-d)/2);
	}

	private static int countPartitionsSpaceOptimized(int[] arr, int n, int target) {

		int prev[]=new int[target+1];
		int curr[]=new int[target+1];

		if(arr[0]==0)
			prev[0]=2;
		else
			prev[0]=1;

		if(arr[0]!=0 && arr[0]<=target) prev[arr[0]]=1;

		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=target;j++)
			{
				int notTaken=prev[j];
				int taken=0;

				if(arr[i]<=j)
				{
					taken=prev[j-arr[i]];
				}

				curr[j]=taken+notTaken;
			}
			prev=curr.clone();
		}
		return prev[target];
	}

	/*
	 * Time Complexity: O(n*target)
	 * Space Complexity: O(n*target)
	 * */
	private static int countPartitionsWithGivenDifferenceTabulation(int[] arr, int n, int d) {

		int totalSum=0;

		for(int i=0;i<n;i++)
		{
			totalSum+=arr[i];
		}

		if((totalSum-d)<0 && (totalSum-d)%2==1) return 0;

		return countPartitionsTabulation(arr, n-1,(totalSum-d)/2);	
	}

	private static int countPartitionsTabulation(int[] arr, int n, int target) {

		int dp[][]=new int[n][target+1];

		if(arr[0]==0)
			dp[0][0]=2;
		else
			dp[0][0]=1;

		if(arr[0]!=0 && arr[0]<=target)dp[0][arr[0]]=1;

		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=target;j++)
			{
				int notTaken=dp[i-1][j];
				int taken=0;

				if(arr[i]<=j)
				{
					taken=dp[i-1][j-arr[i]];
				}

				dp[i][j]=taken+notTaken;
			}
		}

		return dp[n-1][target];
	}

	/*
	 * Time Complexity: O(n*target)
	 * Space Complexity: O(n*target)
	 * */
	private static int countPartitionsWithGivenDifferenceMemoization(int[] arr, int n, int d) {

		int totalSum=0;

		for(int i=0;i<n;i++)
		{
			totalSum+=arr[i];
		}

		if((totalSum-d)<0 && (totalSum-d)%2==1) return 0;

		return countPartitionsMemoDp(arr, n-1, (totalSum-d)/2);	

	}

	private static int countPartitionsMemoDp(int[] arr, int n, int target) {

		int dp[][]=new int[n+1][target+1];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return countPartitionsMemo(arr,n,target,dp);
	}

	private static int countPartitionsMemo(int[] arr, int n, int target, int[][] dp) {

		if(n==0)
		{
			if(target==0 && arr[0]==0) return 2;

			if(target==0 || arr[0]==target) return 1;

			return 0;
		}

		if(dp[n][target]!=-1) return dp[n][target];

		int notTaken=countPartitionsMemo(arr, n-1, target,dp);
		int taken=0;

		if(arr[n]<=target)  
		{
			taken=countPartitionsMemo(arr,n-1, target-arr[n],dp);
		}

		return dp[n][target]=notTaken+taken;
	}

	/*
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(n)
	 * */
	private static int countPartitionsWithGivenDifferenceRecurrsion(int[] arr, int n, int d) {

		int totalSum=0;

		for(int i=0;i<n;i++)
		{
			totalSum+=arr[i];
		}

		if((totalSum-d)<0 && (totalSum-d)%2==1) return 0;

		return countPartitionsRecurrsion(arr, n-1, (totalSum-d)/2);	
	}

	private static int countPartitionsRecurrsion(int[] arr, int n, int target) {

		if(n==0)
		{
			if(target==0 && arr[0]==0) return 2;

			if(target==0 || arr[0]==target) return 1;

			return 0;
		}

		int notTaken=countPartitionsRecurrsion(arr, n-1, target);
		int taken=0;

		if(arr[n]<=target)  
		{
			taken=countPartitionsRecurrsion(arr,n-1, target-arr[n]);
		}

		return notTaken+taken;
	}
}
