package stack;

import java.util.Stack;

public class SumOfSubarrayRanges {

	public static void main(String[] args) {
		
		int arr[ ] = {1, 2, 3};
		
		sumOfSubarrayRangesBrute(arr,arr.length);
		sumOfSubarrayRangesBetter(arr,arr.length);
		sumOfSubarrayRangesOptimal(arr,arr.length);

	}

	private static void sumOfSubarrayRangesOptimal(int[] arr, int n) {
		
		long result=0;
		
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<=n;i++)
		{
			while(!stack.isEmpty() && arr[stack.peek()]>(i==n?Integer.MIN_VALUE:arr[i]))
			{
				int j=stack.pop();
				int k=stack.empty()?-1:stack.peek();
				result-=arr[j]*(i-j)*(j-k);
			}
			
			stack.push(i);
		}
		
		stack.clear();
		
		for(int i=0;i<=n;i++)
		{
			while(!stack.isEmpty() && arr[stack.peek()]<(i==n?Integer.MAX_VALUE:arr[i]))
			{
				int j=stack.pop();
				int k=stack.empty()?-1:stack.peek();
				result+=arr[j]*(i-j)*(j-k);
			}
			
			stack.push(i);
		}
		System.out.println(result);
		
	}

	private static void sumOfSubarrayRangesBetter(int[] arr, int n) {
		
		long result=0;
		
		for(int i=0;i<n;i++)
		{
			int min=arr[i],max=arr[i];
			for(int j=i;j<n;j++)
			{
				
				min=Math.min(min, arr[j]);
				max=Math.max(max, arr[j]);
				result+=max-min;
			}
		}
		
		System.out.println(result);
		
	}

	private static void sumOfSubarrayRangesBrute(int[] arr, int n) {
		
		long result=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int min=arr[j],max=arr[j];
				for(int k=i;k<=j;k++)
				{
					min=Math.min(min,arr[k]);
					max=Math.max(max,arr[k]);
				}
				result+=max-min;
			}
		}
		
		System.out.println(result);
		
	}
}
