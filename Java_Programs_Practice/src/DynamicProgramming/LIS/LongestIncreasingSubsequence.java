package DynamicProgramming.LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		int n = 6, a[] = {5,8,3,7,9,1};

				System.out.println(longestIncreasingSubsequenceRecurrsion(0,-1,a,n));
				System.out.println(longestIncreasingSubsequenceMemoization(0,-1,a,n));
		System.out.println(longestIncreasingSubsequenceTabulation(a,n));
		System.out.println(longestIncreasingSubsequenceSpaceOptimized(a, n));
	}

	private static int longestIncreasingSubsequenceSpaceOptimized(int[] a, int n) {

		int next[]=new int[n+1],curr[]=new int[n+1];

		for(int index=n-1;index>=0;index--)
		{
			for(int prevIndex=index-1;prevIndex>=-1;prevIndex--)
			{
				int maxLength=0+next[prevIndex+1];
				if(prevIndex==-1 || a[index]>a[prevIndex])
					maxLength=Math.max(maxLength,1+next[index+1]);

				curr[prevIndex+1]=maxLength;
			}
			
			next=curr;
		}

		return next[-1+1];
	}

	private static int longestIncreasingSubsequenceTabulation(int[] a, int n) {

		int dp[][]=new int[n+1][n+1];

		for(int index=n-1;index>=0;index--)
		{
			for(int prevIndex=index-1;prevIndex>=-1;prevIndex--)
			{
				int maxLength=0+dp[index+1][prevIndex+1];
				if(prevIndex==-1 || a[index]>a[prevIndex])
					maxLength=Math.max(maxLength,1+dp[index+1][index+1]);

				dp[index][prevIndex+1]=maxLength;
			}
		}

		return dp[0][-1+1];
	}

	private static int longestIncreasingSubsequenceMemoization(int index, int prev_index, int[] a, int n) {

		int dp[][]=new int[n][n+1];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return longestIncreasingSubsequenceMemo(index, prev_index, a, n,dp);
	}

	private static int longestIncreasingSubsequenceMemo(int index, int prev_index, int[] a, int n, int[][] dp) {

		if(index==n)
			return 0;

		if(dp[index][prev_index+1]!=-1) return dp[index][prev_index+1];

		int maxLength=0+longestIncreasingSubsequenceMemo(index+1, prev_index, a, n,dp);
		if(prev_index==-1 || a[index]>a[prev_index])
			maxLength=Math.max(maxLength, 1+longestIncreasingSubsequenceMemo(index+1,index,a,n,dp));

		return dp[index][prev_index+1]=maxLength;
	}

	private static int longestIncreasingSubsequenceRecurrsion(int index, int prev_index, int[] a,int n) {

		if(index==n)
			return 0;

		int maxLength=0+longestIncreasingSubsequenceRecurrsion(index+1,prev_index,a,n);

		if(prev_index==-1 || a[index]>a[prev_index])
			maxLength=Math.max(maxLength,1+longestIncreasingSubsequenceRecurrsion(index+1,index,a,n));


		return maxLength;
	}
}
