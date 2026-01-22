package DynamicProgramming.stocks;

import java.util.Arrays;

public class BuyAndSellStockII {

	public static void main(String[] args) {

		long[] arr = {7, 1, 5, 3, 6, 4};
		int n=arr.length;

		System.out.println(buyAndSellStockIIBrute(0,0,n,arr));
		System.out.println(buyAndSellStockIIMemo(0,0,n, arr));
		System.out.println(buyAndSellStockIITabulation(n, arr));
		System.out.println(buyAndSellStockIISpaceOptimized(n, arr));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static long buyAndSellStockIISpaceOptimized(int n, long[] arr) {

		long front[]=new long[2];
		long curr[]=new long[2];

		long profit=0;

		for(int index=n-1;index>=0;index--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				if(buy==0)
				{
					profit=Math.max(0+front[0],-arr[index]+front[1]);
				}

				if(buy==1)
				{
					profit=Math.max(0+front[1],arr[index]+front[0]);
				}

				curr[buy]=profit;				
			}

			front=curr.clone();
		}
		return curr[0];
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static int buyAndSellStockIITabulation(int n, long[] arr) {

		int dp[][]=new int[n+1][2];

		long profit=0;

		for(int index=n-1;index>=0;index--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				if(buy==0)
				{
					profit=Math.max(0+dp[index+1][0],-arr[index]+dp[index+1][1]);
				}

				if(buy==1)
				{
					profit=Math.max(0+dp[index+1][1],arr[index]+dp[index+1][0]);
				}

				dp[index][buy]=(int) profit;				
			}
		}
		return dp[0][0];
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static long buyAndSellStockIIMemo(int index, int buy, int n, long[] arr) {

		int dp[][]=new int[n][2];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return buyAndSellStockIIMemoization(index, buy, n, arr,dp);
	}

	private static long buyAndSellStockIIMemoization(int index, int buy, int n, long[] arr, int[][] dp) {


		if(n==index) return 0;

		if(dp[index][buy]!=-1) return dp[index][buy];

		long profit=0;

		if(buy==0)
		{
			profit=Math.max(0+buyAndSellStockIIMemoization(index+1,0, n, arr,dp),
					-arr[index]+buyAndSellStockIIMemoization(index+1,1,n, arr,dp));
		}

		if(buy==1)
		{
			profit=Math.max(0+buyAndSellStockIIMemoization(index+1,1, n, arr,dp),
					arr[index]+buyAndSellStockIIMemoization(index,0, n, arr, dp));
		}

		dp[index][buy]=(int) profit;

		return dp[index][buy];
	}

	/*
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(n)
	 * */
	private static long buyAndSellStockIIBrute(int index, int buy, int n, long[] arr) {

		if(index==n) return 0;

		long profit=0;

		if(buy==0)
		{
			profit=Math.max(0+buyAndSellStockIIBrute(index+1,0, n, arr),
					-arr[index]+buyAndSellStockIIBrute(index+1,1, n, arr));
		}

		if(buy==1)
		{
			profit=Math.max(0+buyAndSellStockIIBrute(index+1,1, n, arr),
					arr[index]+buyAndSellStockIIBrute(index+1,0, n, arr));
		}

		return profit;
	}
}
