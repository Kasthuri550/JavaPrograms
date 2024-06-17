package Arrayprograms.easy;

public class MinimumCostClimbingChairs {

	public static void main(String[] args) {
		
		int arr[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		
		System.out.println(minCostClimbChairs(arr));

	}

	private static int minCostClimbChairs(int[] arr) {
		
		int n=arr.length;
		
		int first=arr[0];
		int second=arr[1];
		
		if(n==2)
		{
			return Math.min(first, second);
		}
		
		for(int i=2;i<n;i++)
		{
			int current=arr[i]+Math.min(first, second);
			first=second;
			second=current;
		}
		
		return Math.min(first, second);
	}
}
