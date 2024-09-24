package DynamicProgramming.subsequences;

import java.util.Arrays;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		
		int N = 2,W = 3,val[] = {1, 1},wt[] = {2, 1};
		
		System.out.println(unboundedKnapsackRecurrsion(N-1,W,wt,val));		
		System.out.println(unboundedKnapsackMemoization(N, W, wt, val));
		System.out.println(unboundedKnapsackTabulation(N, W, wt, val));
		System.out.println(unboundedKnapsackSpaceOptimized(N, W, wt, val));
		System.out.println(unboundedKnapsackSpaceOptimized2(N, W, wt, val));
	}

	private static int unboundedKnapsackSpaceOptimized2(int n, int w, int[] wt, int[] val) {
		
		int prev[]=new int[w+1];
				
		for(int target=wt[0];target<=w;target++)
		{
			prev[target]=(int)(target/wt[0])*val[0];
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=w;j++)
			{
				int notTake=prev[j];
				int take=0;
				if(wt[i]<=j)
				{
					take=val[i]+prev[j-wt[i]];
				}
				
				prev[j]=Math.max(notTake, take);
			}
		}
		return prev[w];
	}

	private static int unboundedKnapsackSpaceOptimized(int n, int w, int[] wt, int[] val) {
		
		int prev[]=new int[w+1];
		int curr[]=new int[w+1];
		
		for(int target=wt[0];target<=w;target++)
		{
			prev[target]=(int)(target/wt[0])*val[0];
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=w;j++)
			{
				int notTake=prev[j];
				int take=0;
				if(wt[i]<=j)
				{
					take=val[i]+curr[j-wt[i]];
				}
				
				curr[j]=Math.max(notTake, take);
			}
			
			prev=curr.clone();
		}
		return prev[w];
	}

	private static int unboundedKnapsackTabulation(int n, int w, int[] wt, int[] val) {
		
		int dp[][]=new int[n][w+1];
		
		for(int target=wt[0];target<=w;target++)
		{
			dp[0][target]=(int)(target/wt[0])*val[0];
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=w;j++)
			{
				int notTake=0+dp[i-1][j];
				int take=0;
				
				if(wt[i]<=j)
				{
					take=val[i]+dp[i][j-wt[i]];
				}
				
				dp[i][j]=Math.max(notTake, take);
			}
		}
		
		return dp[n-1][w];
	}

	private static int unboundedKnapsackMemoization(int n, int w, int[] wt, int[] val) {
		
		int dp[][]=new int[n][w+1];
		
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		return unboundedKnapsackMemo(n-1, w, wt, val,dp);
	}

	private static int unboundedKnapsackMemo(int n, int w, int[] wt, int[] val, int[][] dp) {
		
		if(n==0)
		{
			return (int)(w/wt[0])*val[0];
		}
		
		if(dp[n][w]!=-1) return dp[n][w];
		
		int notTake=0+unboundedKnapsackMemo(n-1, w, wt, val, dp);
		int take=0;
		if(wt[n]<=w)
		{
			take=val[n]+unboundedKnapsackMemo(n, w-wt[n], wt, val, dp);
		}
		
		return dp[n][w]=Math.max(notTake, take);
	}

	private static int unboundedKnapsackRecurrsion(int n, int w, int[] wt, int[] val) {
		
		if(n==0)
		{
			return (int)(w/wt[0])*val[0];
		}
		int notTake=0+unboundedKnapsackRecurrsion(n-1, w, wt, val);
		int take=0;
		if(wt[n]<=w)
		{
			take=val[n]+unboundedKnapsackRecurrsion(n, w-wt[n], wt, val);
		}
		return Math.max(notTake, take);
	}
}
