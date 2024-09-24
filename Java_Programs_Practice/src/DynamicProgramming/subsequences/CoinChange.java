package DynamicProgramming.subsequences;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		
		int N = 3, sum = 4,coins[] = {1,2,3};
		
		System.out.println(coinChangeRecurrsion(coins,N-1,sum));
		System.out.println(coinChangeMemoization(coins,N, sum));
		System.out.println(coinChangeTabulation(coins,N,sum));
		System.out.println(coinChangeSpaceOptimized(coins,N,sum));
	}

	private static int coinChangeSpaceOptimized(int[] coins, int n, int sum) {
		
		int prev[]=new int[sum+1];
		int curr[]=new int[sum+1];
		
		for(int target=0;target<=sum;target++)
		{
			prev[target]=target%coins[0]==0?1:0;
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=sum;j++)
			{
				int notTake=prev[j];
				int take=0;
				
				if(coins[i]<=j)
				{
					take=curr[j-coins[i]];
				}
				
				curr[j]=notTake+take;
			}
			
			prev=curr.clone();
		}
		return prev[sum];
	}

	private static int coinChangeTabulation(int[] coins, int n, int sum) {
		
		int dp[][]=new int[n][sum+1];
		
		for(int target=0;target<=sum;target++)
		{
			dp[0][target]=target%coins[0]==0?1:0;
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=sum;j++)
			{
				int notTake=dp[i-1][j];
				int take=0;
				if(coins[i]<=j)
				{
					take=dp[i][j-coins[i]];
				}
				dp[i][j]=notTake+take;
			}	
		}
		
		return dp[n-1][sum];
	}

	private static int coinChangeMemoization(int[] coins, int n, int sum) {
		
		int dp[][]=new int[n][sum+1];
		
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		
		return coinChangeMemo(coins, n-1, sum,dp);
	}

	private static int coinChangeMemo(int[] coins, int n, int sum,int dp[][]) {
		
		if(n==0)
		{
			return sum%coins[0]==0?1:0;
		}
		
		if(dp[n][sum]!=-1) return dp[n][sum];
		
		int notTake=coinChangeMemo(coins, n-1, sum,dp);
		int take=0;
		if(coins[n]<=sum)
		{
			take=coinChangeMemo(coins,n, sum-coins[n],dp);
		}
		return dp[n][sum]=notTake+take;
	}

	private static int coinChangeRecurrsion(int[] coins, int n, int sum) {
		
		if(n==0)
		{
			return sum%coins[0]==0?1:0;
		}
		
		int notTake=coinChangeRecurrsion(coins, n-1, sum);
		int take=0;
		if(coins[n]<=sum)
		{
			
			take=coinChangeRecurrsion(coins,n, sum-coins[n]);
		}
		
		return notTake+take;
	}
}
