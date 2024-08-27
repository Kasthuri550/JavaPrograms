package DynamicProgramming.stocks;

import java.util.Arrays;

public class BuyAndSellStocksIII {

	public static void main(String[] args) {
		
		int n = 6,prices[] = {10,22,5,75,65,80};
		
//		System.out.println(buyAndSellStocksIIIRecursion(0,0,2,n,prices));
//		System.out.println(buyAndSellStocksIIIMemoization(n, prices));
		System.out.println(buyAndSellStocksIIITabulation(n, prices));
		System.out.println(buyAndSellStocksIIISpaceOptimized(n, prices));

	}

	private static int buyAndSellStocksIIISpaceOptimized(int n, int[] prices) {
		
		int front[][]=new int[2][3];
		int curr[][]=new int[2][3];
		
		int profit=Integer.MIN_VALUE;
		
		for(int index=n-1;index>=0;index--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				for(int cap=1;cap<=2;cap++)
				{
					if(buy==0)
					{
						profit=Math.max(0+front[0][cap],-prices[index]+front[1][cap]);
					}
					
					if(buy==1)
					{
						profit=Math.max(0+front[1][cap],prices[index]+front[0][cap-1]);
					}
					
					curr[buy][cap]=profit;
				}
			}
			
			for(int k=0;k<=1;k++)
			{
				front[k]=curr[k].clone();
			}
		}
		
		return front[0][2];
	}

	private static int buyAndSellStocksIIITabulation(int n, int[] prices) {
		
		int dp[][][]=new int[n+1][2][3];
		
		int profit=Integer.MIN_VALUE;
		
		for(int index=n-1;index>=0;index--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				for(int cap=1;cap<=2;cap++)
				{
					if(buy==0)
					{
						profit=Math.max(0+dp[index+1][0][cap],-prices[index]+dp[index+1][1][cap]);
					}
					
					if(buy==1)
					{
						profit=Math.max(0+dp[index+1][1][cap],prices[index]+dp[index+1][0][cap-1]);
					}
					
					dp[index][buy][cap]=profit;
				}
			}
		}
		return dp[0][0][2];
	}

	private static int buyAndSellStocksIIIMemoization(int n, int[] prices) {
		
		int dp[][][]=new int[n][2][3];
		
		for(int row1[][]:dp)
		{
			for(int row2[]:row1)
			{
				Arrays.fill(row2,-1);
			}
		}
		
		return buyAndSellStockIIIMemo(0,0,2, n, prices,dp);
	}

	private static int buyAndSellStockIIIMemo(int index, int buy, int cap, int n, int[] prices, int[][][] dp) {
		
		if(index==n || cap==0) return 0;
		
		if(dp[index][buy][cap]!=-1) return dp[index][buy][cap];
		
		int profit=Integer.MIN_VALUE;
		
		if(buy==0)
		{
			profit=Math.max(0+buyAndSellStockIIIMemo(index+1,0, cap, n, prices, dp),
					-prices[index]+buyAndSellStockIIIMemo(index+1,1, cap, n, prices, dp));
		}
		
		if(buy==1)
		{
			profit=Math.max(0+buyAndSellStockIIIMemo(index+1,1, cap, n, prices, dp),
					prices[index]+buyAndSellStockIIIMemo(index+1,0, cap-1, n, prices, dp));
		}
		
		return dp[index][buy][cap]=profit;
	}

	private static int buyAndSellStocksIIIRecursion(int index, int buy, int cap, int n, int[] prices) {
		
		if(index==n || cap==0) return 0;
		
		int profit=Integer.MIN_VALUE;
		
		if(buy==0)
		{
			profit=Math.max(0+buyAndSellStocksIIIRecursion(index+1,0, cap, n, prices),
					-prices[index]+buyAndSellStocksIIIRecursion(index+1,1, cap, n, prices));
		}
		
		if(buy==1)
		{
			profit=Math.max(0+buyAndSellStocksIIIRecursion(index+1,1,cap,n, prices),
					prices[index]+buyAndSellStocksIIIRecursion(index+1,0, cap-1, n, prices));
		}
		
		return profit;
	}
}
