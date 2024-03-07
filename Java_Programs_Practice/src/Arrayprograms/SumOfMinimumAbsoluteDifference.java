package Arrayprograms;

import java.util.Arrays;

public class SumOfMinimumAbsoluteDifference {

	public static void main(String[] args) {
		
		int arr[] = {2, 4, 5, 3};
        int n = arr.length;
        
        System.out.println(sumOfMinAbsDifferences1(arr,n));
        System.out.println(sumOfMinAbsDifferences2(arr,n));
	}

	private static int sumOfMinAbsDifferences2(int[] arr, int n) {
		
		int sum=0;
		
		Arrays.sort(arr);
		sum+=Math.abs(arr[0]-arr[1]);
		sum+=Math.abs(arr[n-1]-arr[n-2]);
		
		for(int i=1;i<n-1;i++)
		{
			sum+=Math.min(Math.abs(arr[i]-arr[i-1]),Math.abs(arr[i]-arr[i+1]));
		}
		
		return sum;
	}

	private static int sumOfMinAbsDifferences1(int[] arr, int n) {
		
		int result=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=0;j<n;j++)
			{
				sum+=Math.abs(arr[i]-arr[j]);
			}
			
			result=Math.min(result,sum);
		}
		
		return result;
	}

}
