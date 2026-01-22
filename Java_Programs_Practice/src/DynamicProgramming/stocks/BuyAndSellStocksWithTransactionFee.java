package DynamicProgramming.stocks;

import java.util.Arrays;

public class BuyAndSellStocksWithTransactionFee {

	public static void main(String[] args) {

		int n = 6,prices[] = {1,3,2,8,4,9},fee = 2;

		//		System.out.println(buyAndSellStocksWithTransactionFeeRecursion(0,0,n,prices,fee));
		//		System.out.println(buyAndSellStocksWithTransactionFeeMemoization(0,0, n, prices, fee));
		//		System.out.println(buyAndSellStocksWithTransactionFeeTabulation(n, prices, fee));
		//		System.out.println(buyAndSellStocksWithTransactionFeeSpaceOptimized1(n, prices, fee));
		System.out.println(buyAndSellStocksWithTransactionFeeSpaceOptimized2(n, prices, fee));

	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int buyAndSellStocksWithTransactionFeeSpaceOptimized2(int n, int[] prices, int fee) {

		int currNotBuy,frontNotBuy=0,frontBuy=0,currBuy;

		for(int index=n-1;index>=0;index--)
		{
			currNotBuy=Math.max(0+frontNotBuy,-prices[index]+frontBuy);
			currBuy=Math.max(0+frontBuy,prices[index]-fee+frontNotBuy);

			frontNotBuy=currNotBuy;
			frontBuy=currBuy;
		}

		return frontNotBuy;
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int buyAndSellStocksWithTransactionFeeSpaceOptimized1(int n, int[] prices, int fee) {

		int front[]=new int[2];
		int curr[]=new int[2];

		for(int index=n-1;index>=0;index--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				int profit=Integer.MIN_VALUE;

				if(buy==0)
				{
					profit=Math.max(0+front[0],
							-prices[index]+front[1]);
				}

				if(buy==1)
				{
					profit=Math.max(0+front[1],
							prices[index]-fee+front[0]);
				}

				curr[buy]=profit;
			}
			front=curr.clone();
		}
		return front[0];
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static int buyAndSellStocksWithTransactionFeeTabulation(int n, int[] prices, int fee) {

		int dp[][]=new int[n+1][2];

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
					profit=Math.max(0+dp[index+1][1],prices[index]+dp[index+1][0]-fee);
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
	private static int buyAndSellStocksWithTransactionFeeMemoization(int index, int buy, int n, int[] prices, int fee) {

		int dp[][]=new int[n][2];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return buyAndSellStocksWithTransactionFeeMemo(index, buy, n, prices, fee,dp);
	}

	private static int buyAndSellStocksWithTransactionFeeMemo(int index, int buy, int n, int[] prices, int fee,int dp[][]) {

		if(index==n) return 0;
		if(dp[index][buy]!=-1) return dp[index][buy];

		int profit=Integer.MIN_VALUE;

		if(buy==0)
		{
			profit=Math.max(0+buyAndSellStocksWithTransactionFeeMemoization(index+1,0, n, prices, fee),
					-prices[index]+buyAndSellStocksWithTransactionFeeMemoization(index+1,1, n, prices, fee));
		}

		if(buy==1)
		{
			profit=Math.max(0+buyAndSellStocksWithTransactionFeeMemoization(index+1,1, n, prices, fee),
					prices[index]-fee+buyAndSellStocksWithTransactionFeeMemoization(index+1,0, n, prices, fee));
		}
		return dp[index][buy]=profit;
	}

	/*
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(n)
	 * */
	private static int buyAndSellStocksWithTransactionFeeRecursion(int index, int buy, int n, int[] prices,int fee) {

		if(index==n) return 0;

		int profit=Integer.MIN_VALUE;

		if(buy==0)
		{
			profit=Math.max(0+buyAndSellStocksWithTransactionFeeRecursion(index+1,0, n, prices,fee),
					-prices[index]+buyAndSellStocksWithTransactionFeeRecursion(index+1,1, n, prices,fee));
		}

		if(buy==1)
		{
			profit=Math.max(0+buyAndSellStocksWithTransactionFeeRecursion(index+1,1, n, prices,fee),
					prices[index]-fee+buyAndSellStocksWithTransactionFeeRecursion(index+1,0, n, prices,fee));
		}
		return profit;
	}
}
