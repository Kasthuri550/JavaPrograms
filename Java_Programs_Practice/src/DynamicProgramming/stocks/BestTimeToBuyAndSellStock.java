package DynamicProgramming.stocks;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		
		 int[] arr  ={7,1,5,3,6,4};
		 
		System.out.println(buyAndSellStock(arr,arr.length));
	}

	private static int buyAndSellStock(int[] arr, int n) {
		
		int min=arr[0],max=Integer.MIN_VALUE;
		
		for(int i=1;i<n;i++)
		{
			int cost=arr[i]-min;
			max=Math.max(max,cost);
			min=Math.min(min,arr[i]);
		}

		return max;
	}

}
