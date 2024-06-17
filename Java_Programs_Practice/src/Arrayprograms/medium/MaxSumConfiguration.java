package Arrayprograms.medium;

public class MaxSumConfiguration {

	public static void main(String[] args) {
		
		int arr[] = {8, 3, 1, 2};
		
		maxSum(arr);

	}

	private static void maxSum(int[] arr) {
		
		int n=arr.length,sum=0,curr_val=0;
		
		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
		}
		
		for(int i=0;i<n;i++)
		{
			curr_val+=i*arr[i];
		}
		
		int result=curr_val;
		
		for(int i=1;i<n;i++)
		{
			int next_val=curr_val-(sum-arr[i-1])+arr[i-1]*(n-1);
			curr_val=next_val;
			result=Math.max(result,curr_val);
		}
		
		System.out.println(result);
		
	}
}
