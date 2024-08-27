package DynamicProgramming.stocks;

import java.util.Arrays;

public class StockBuyAndSellII {

	public static void main(String[] args) {
		
		int n = 6,price[] = {7, 1, 5, 3, 6, 4};
		
//		System.out.println(stockBuyAndSellRecursion(0,0,n,price));
//		System.out.println(stockBuyAndSellMemoization(0,0, n, price));
//		System.out.println(stockBuyAndSellTabulation(n, price));
//		System.out.println(stockBuyAndSellSpaceOptimized1(n, price));
		System.out.println(stockBuyAndSellSpaceOptimized2(n, price));
	}

	private static int stockBuyAndSellSpaceOptimized2(int n, int[] price) {
		
		int frontNotBuy=0,frontBuy=0;
		int currNotBuy,currBuy;
		
		for(int index=n-1;index>=0;index--)
		{
			currNotBuy=Math.max(0+frontNotBuy,-price[index]+frontBuy);
			
			currBuy=Math.max(0+frontBuy,price[index]+frontNotBuy);
			
			frontNotBuy=currNotBuy;
			frontBuy=currBuy;
		}
		
		return frontNotBuy;
	}

	private static int stockBuyAndSellSpaceOptimized1(int n, int[] price) {
		
		int front[]=new int[2];
		
		int profit=Integer.MIN_VALUE;
		
		for(int index=n-1;index>=0;index--)
		{
			int curr[]=new int[2];
			for(int buy=0;buy<=1;buy++)
			{
				if(buy==0)
				{
					profit=Math.max(0+front[0],-price[index]+front[1]);
				}
				
				if(buy==1)
				{
					profit=Math.max(0+front[1],price[index]+front[0]);
				}
				
				curr[buy]=profit;
			}
			
			front=curr;
		}
		
		return front[0];
	}

	private static int stockBuyAndSellTabulation(int n, int[] price) {
		
		int dp[][]=new int[n+1][2];
		
		int profit=Integer.MIN_VALUE;
		
		dp[n][0]=dp[n][1]=0;
		
		for(int index=n-1;index>=0;index--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				if(buy==0)
				{
					profit=Math.max(0+dp[index+1][0],-price[index]+dp[index+1][1]);
				}
				
				if(buy==1)
				{
					profit=Math.max(0+dp[index+1][1],price[index]+dp[index+1][0]);
				}
				
				dp[index][buy]=profit;
			}
		}
		return dp[0][0];
	}

	private static int stockBuyAndSellMemoization(int index, int buy, int n, int[] price) {
		
		int dp[][]=new int[n][2];
		
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		
		return stockBuyAndSellMemo(index, buy, n, price,dp);
	}

	private static int stockBuyAndSellMemo(int index, int buy, int n, int[] price, int[][] dp) {
		
		if(index==n) return 0;
		
		if(dp[index][buy]!=-1) return dp[index][buy];
		
		int profit=Integer.MIN_VALUE;
		
		if(buy==0)
		{
			profit=Math.max(0+stockBuyAndSellMemoization(index+1,0, n, price),
					-price[index]+stockBuyAndSellMemoization(index+1,1, n, price));
		}
		
		if(buy==1)
		{
			profit=Math.max(0+stockBuyAndSellMemo(index+1,1, n, price, dp),
					price[index]+stockBuyAndSellMemo(index+1,0, n, price, dp));
		}
		
		return dp[index][buy]=profit;
	}

	private static int stockBuyAndSellRecursion(int index, int buy, int n, int[] price) {
		
		if(index==n) return 0;
		
		int profit=Integer.MIN_VALUE;
		
		 if (buy == 0) { 
	            profit = Math.max(0 + stockBuyAndSellRecursion(index + 1, 0, n,price),
	                    -price[index] + stockBuyAndSellRecursion(index + 1, 1, n,price));
	        }
		 		 
	        if (buy == 1) { 
	            profit = Math.max(0 + stockBuyAndSellRecursion(index + 1, 1, n,price),
	                    price[index] + stockBuyAndSellRecursion(index + 1, 0, n,price));
	        }
		
		return profit;
	}
}
