package DynamicProgramming.stocks;

import java.util.Arrays;

public class BuyAndSellStocksWithCooldown {

	public static void main(String[] args) {

		int n=5,prices[]= {1,2,3,0,2};

		System.out.println(buyAndSellStocksWithCooldownRecursion(0,0,n,prices));
		System.out.println(buyAndSellStocksWithCooldownMemoization(n, prices));
		System.out.println(buyAndSellStocksWithCooldownTabulation(n, prices));
		System.out.println(buyAndSellStocksWithCooldownSpaceOptimized(n, prices));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int buyAndSellStocksWithCooldownSpaceOptimized(int n, int[] prices) {

		int front1[]=new int[2];
		int front2[]=new int[2];
		int curr[]=new int[2];

		for(int index=n-1;index>=0;index--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				int profit=0;

				if(buy==0)
				{
					profit=Math.max(0+front1[0],-prices[index]+front1[1]);
				}
				if(buy==1)
				{
					profit=Math.max(0+front1[1],prices[index]+front2[0]);
				}

				curr[buy]=profit;
			}

			front2=front1.clone();
			front1=curr.clone();
		}
		return front1[0];
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static int buyAndSellStocksWithCooldownTabulation(int n, int[] prices) {

		int dp[][]=new int[n+2][2];

		for(int index=n-1;index>=0;index--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				int profit=Integer.MIN_VALUE;

				if(buy==0)
				{
					profit=Math.max(0+dp[index+1][0],-prices[index]+dp[index+1][1]);
				}

				if(buy==1)
				{
					profit=Math.max(0+dp[index+1][1],prices[index]+dp[index+2][0]);
				}

				dp[index][buy]=profit;
			}
		}
		return dp[0][0];
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static int buyAndSellStocksWithCooldownMemoization(int n, int[] prices) {

		int dp[][]=new int[n][2];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		return buyAndSellStocksWithCooldownMemo(0, 0,n,prices,dp);
	}

	private static int buyAndSellStocksWithCooldownMemo(int index, int buy, int n, int[] prices,int dp[][]) {

		if(index>=n) return 0;

		if(dp[index][buy]!=-1) return dp[index][buy];

		int profit=Integer.MIN_VALUE;

		if(buy==0)
		{
			profit=Math.max(0+buyAndSellStocksWithCooldownMemo(index+1,0, n, prices, dp),
					-prices[index]+buyAndSellStocksWithCooldownMemo(index+1,1, n, prices, dp));
		}

		if(buy==1)
		{
			profit=Math.max(0+buyAndSellStocksWithCooldownMemo(index+1,1, n, prices, dp),
					prices[index]+buyAndSellStocksWithCooldownMemo(index+2,0, n, prices, dp));
		}

		return dp[index][buy]=profit;
	}

	/*
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(n)
	 * */
	private static int buyAndSellStocksWithCooldownRecursion(int index, int buy, int n, int[] prices) {

		if(index>=n) return 0;

		int profit=Integer.MIN_VALUE;

		if(buy==0)
		{
			profit=Math.max(0+buyAndSellStocksWithCooldownRecursion(index+1,0, n, prices),
					-prices[index]+buyAndSellStocksWithCooldownRecursion(index+1,1, n, prices));
		}

		if(buy==1)
		{
			profit=Math.max(0+buyAndSellStocksWithCooldownRecursion(index+1, 1, n, prices),
					prices[index]+buyAndSellStocksWithCooldownRecursion(index+2,0, n, prices));
		}
		return profit;
	}
}
