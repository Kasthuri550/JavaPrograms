package Arrayprograms.medium;

import java.util.Arrays;

public class MinimizeMaximumDifferenceBetweenHeights {
	
	public static void main(String[] args) {
		
		int arr[] = {1, 5, 8, 10},k=2;
		
		minimizeDifference(arr,k);
		
	}

	private static void minimizeDifference(int[] arr, int k) {
		
		int n=arr.length;
		
		Arrays.sort(arr);
		int smallest=arr[0]+k;
		int largest=arr[n-1]-k;
		int result=arr[n-1]-arr[0];
		int min,max;
		
		for(int i=0;i<n-1;i++)
		{
			min=Math.min(smallest,arr[i+1]-k);
			max=Math.max(largest, arr[i]+k);
			
			if(min < 0)
				continue;
			
			result=Math.min(result,max-min);	
		}
		
		System.out.println(result);
		
	}
}
