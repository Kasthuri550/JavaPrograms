package Arrayprograms.medium;

public class StockBuyAndSell {

	public static void main(String[] args) {
		
		 int arr[] = {7,1,5,3,6,4};
		 
		 stockBuyAndSellBrute(arr);
		 stockBuyAndSellOptimal(arr);

	}

	private static void stockBuyAndSellOptimal(int[] arr) {
		
		int n=arr.length,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			min=Math.min(min,arr[i]);
			max=Math.max(max,arr[i]-min);
		}
		
		System.out.println(max);
		
	}

	private static void stockBuyAndSellBrute(int[] arr) {
		
		int n=arr.length;
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]<arr[j])
				{
					max=Math.max(arr[j]-arr[i], max);
				}
			}
		}
		
		System.out.println(max);
		
	}
}
