package DynamicProgramming.stocks;

import java.util.Arrays;

public class BuyAndSellStocksIIIAnotherApproach {

	public static void main(String[] args) {
		
		int n = 6,prices[] = {10,22,5,75,65,80};
		
		System.out.println(buyAndSellStockIIIRecursion(0,0,n,prices));
		System.out.println(buyAndSellStockIIIMemoization(0,0, n, prices));
		System.out.println(buyAndSellStockIIITabulation(n, prices));
		System.out.println(buyAndSellStockIIISpaceOptimized(n, prices));

	}

	private static int buyAndSellStockIIISpaceOptimized(int n, int[] prices) {
		
		int front[]=new int[5];
		
		int profit=Integer.MIN_VALUE;
		
		for(int index=n-1;index>=0;index--)
		{
			int curr[]=new int[5];
			for(int transaction=0;transaction<4;transaction++)
			{
				if(transaction%2==0)
				{
					profit=Math.max(0+front[transaction],-prices[index]+front[transaction+1]);
				}
				else
				{
					profit=Math.max(0+front[transaction],prices[index]+front[transaction+1]);
				}
				
				curr[transaction]=profit;
			}
			
			front=curr;
		}
		
		return front[0];
	}

	private static int buyAndSellStockIIITabulation(int n, int[] prices) {
		
		int dp[][]=new int[n+1][5];
		int profit=Integer.MIN_VALUE;
		
		for(int index=n-1;index>=0;index--)
		{
			for(int transaction=0;transaction<4;transaction++)
			{
				if(transaction%2==0)
				{
					profit=Math.max(0+dp[index+1][transaction],-prices[index]+dp[index+1][transaction+1]);
				}
				else
				{
					profit=Math.max(0+dp[index+1][transaction],prices[index]+dp[index+1][transaction+1]);
				}
				
				dp[index][transaction]=profit;
			}
		}
		
		return dp[0][0];
	}

	private static int buyAndSellStockIIIMemoization(int index, int transaction, int n, int[] prices) {
		
		int dp[][]=new int[n][4];
		
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		
		return buyAndSellStockIIIMemo(0, 0, n, prices,dp);
	}

	private static int buyAndSellStockIIIMemo(int index, int transaction, int n, int[] prices, int[][] dp) {

		if(index==n || transaction==4) return 0;
		if(dp[index][transaction]!=-1) return dp[index][transaction];
		
		int profit=Integer.MIN_VALUE;
		
		if(transaction%2==0)
		{
			profit=Math.max(0+buyAndSellStockIIIMemo(index+1,transaction, n, prices, dp),
					-prices[index]+buyAndSellStockIIIMemo(index+1,transaction+1, n, prices, dp));
		}
		else
		{
			profit=Math.max(0+buyAndSellStockIIIMemo(index+1, transaction, n, prices, dp),
					prices[index]+buyAndSellStockIIIMemo(index+1, transaction+1, n, prices, dp));
		}
		return dp[index][transaction]=profit;
	}

	private static int buyAndSellStockIIIRecursion(int index, int transaction, int n, int[] prices) {
		
		if(index==n || transaction==4) return 0;
		
		int profit=Integer.MIN_VALUE;
		
		if(transaction%2==0)
		{
			profit=Math.max(0+buyAndSellStockIIIRecursion(index+1, transaction, n, prices),
					-prices[index]+buyAndSellStockIIIRecursion(index+1,transaction+1, n, prices));
		}
		else
		{
			profit=Math.max(0+buyAndSellStockIIIRecursion(index+1, transaction, n, prices),
					prices[index]+buyAndSellStockIIIRecursion(index+1, transaction+1, n, prices));
		}
		return profit;
	}

}
