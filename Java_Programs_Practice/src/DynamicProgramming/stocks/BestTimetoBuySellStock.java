package DynamicProgramming.stocks;

public class BestTimetoBuySellStock {

	public static void main(String[] args) {

		int prices[] = {7,1,5,3,6,4};

		System.out.println(bestTimeToBuyAndSellStockBrute(prices));
		System.out.println(bestTimeToBuyAndSellStockOptimal(prices));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int bestTimeToBuyAndSellStockOptimal(int[] prices) {

		int n=prices.length,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			min=Math.min(min,prices[i]);
			max=Math.max(max,prices[i]-min);
		}

		return max;
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */	
	private static int bestTimeToBuyAndSellStockBrute(int[] prices) {

		int n=prices.length;
		int profit=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(prices[i]<prices[j])
				{
					profit=Math.max(profit,prices[j]-prices[i]);
				}
			}
		}

		return profit;
	}
}
