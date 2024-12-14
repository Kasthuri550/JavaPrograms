package ArrayPractice;

import java.util.Arrays;

public class SmallestSubarrayWithSumGreaterThanGivenValue {

	public static void main(String[] args) {
		
		int arr[] = {1, 4, 45, 6, 10, 19}, x = 51;
		
		System.out.println(smallestSubarray(arr,x));

	}

	private static int smallestSubarray(int[] arr, int x) {
		
		int start=0,n=arr.length,sum=0,min=Integer.MAX_VALUE,minStart=0,minEnd=0;
		
		for(int end=0;end<n;end++)
		{
			sum+=arr[end];
			
			while(sum>x)
			{
				if(end-start+1<min)
				{
					min=end-start+1;
					minStart=start;
					minEnd=end;
				}
				
				sum-=arr[start];
				start++;
			}
			
		}
		
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr,minStart,minEnd+1)));
		return min==Integer.MAX_VALUE?0:min;
	}
}
