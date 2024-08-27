package DynamicProgramming.stocks;

import java.util.Arrays;

public class BuyAndStockSellIV {

	public static void main(String[] args) {
		
		int K = 2, N = 6,A[] = {10, 22, 5, 75, 65, 80};
		
//		System.out.println(buyAndStockSellIVRecursion(0,0,K,N,A));
//		System.out.println(buyAndStockSellIVMemoization(K,N,A));
		System.out.println(buyAndStockSellIVTabulation(K,N,A));
		System.out.println(buyAndStockSellIVSpaceOptimized(K, N, A));

	}

	private static int buyAndStockSellIVSpaceOptimized(int k, int n, int[] a) {
		
		int front[]=new int[2*k+1];
		
		for(int index=n-1;index>=0;index--)
		{
			int curr[]=new int[2*k+1];
			for(int transaction=0;transaction<2*k;transaction++)
			{
				int profit=Integer.MIN_VALUE;
				
				if(transaction%2==0)
				{
					profit=Math.max(0+front[transaction],-a[index]+front[transaction+1]);
				}
				else
				{
					profit=Math.max(0+front[transaction],a[index]+front[transaction+1]);
				}
				
				curr[transaction]=profit;
			}
			
			front=curr;
		}
		
		return front[0];
	}

	private static int buyAndStockSellIVTabulation(int k, int n, int[] a) {
		
		int dp[][]=new int[n+1][2*k+1];
		
		for(int index=n-1;index>=0;index--)
		{
			for(int transaction=0;transaction<2*k;transaction++)
			{
				int profit=Integer.MIN_VALUE;
				
				if(transaction%2==0)
				{
					profit=Math.max(0+dp[index+1][transaction],-a[index]+dp[index+1][transaction+1]);
				}
				else
				{
					profit=Math.max(0+dp[index+1][transaction],a[index]+dp[index+1][transaction+1]);
				}
				
				dp[index][transaction]=profit;
			}
		}
		
		return dp[0][0];
	}

	private static int buyAndStockSellIVMemoization(int k, int n, int[] a) {
		
		int dp[][]=new int[n][2*k];
		
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		return buyAndStockSellIVMemo(0,0,k,n,a,dp);
	}

	private static int buyAndStockSellIVMemo(int index, int transaction, int k, int n, int[] a, int[][] dp) {
		
		if(index==n || transaction==2*k) return 0;
		
		if(dp[index][transaction]!=-1) return dp[index][transaction];
		
		int profit=Integer.MIN_VALUE;
		
		if(transaction%2==0)
		{
			profit=Math.max(0+buyAndStockSellIVMemo(index+1, transaction, k, n, a, dp),
					-a[index]+buyAndStockSellIVMemo(index+1, transaction+1, k, n, a, dp));
		}
		else
		{
			profit=Math.max(0+buyAndStockSellIVMemo(index+1, transaction, k, n, a, dp),
					a[index]+buyAndStockSellIVMemo(index+1, transaction+1, k, n, a, dp));
		}
		
		return dp[index][transaction]=profit;
	}

	private static int buyAndStockSellIVRecursion(int index, int transaction, int k, int n, int[] a) {
		
		if(index==n || transaction==2*k) return 0;
		int profit=Integer.MIN_VALUE;
		
		if(transaction%2==0)
		{
			profit=Math.max(0+buyAndStockSellIVRecursion(index+1, transaction, k, n, a),
					-a[index]+buyAndStockSellIVRecursion(index+1, transaction+1, k, n, a));
		}
		else
		{
			profit=Math.max(0+buyAndStockSellIVRecursion(index+1, transaction, k, n, a),
					a[index]+buyAndStockSellIVRecursion(index+1, transaction+1, k, n, a));
					
		}
		
		return profit;
	}
}
