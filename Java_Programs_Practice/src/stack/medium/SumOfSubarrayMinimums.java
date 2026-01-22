package stack.medium;

import java.util.Stack;

public class SumOfSubarrayMinimums {

	private static final int MOD=(int)1e9+7;

	public static void main(String[] args) {

		int arr[] = {3,1,2,4};

		System.out.println(sumOfSubarrayMinimumBrute(arr,arr.length));
		System.out.println(sumOfSubarrayMinimumBetter(arr,arr.length));
		System.out.println(sumOfSubarrayMinimumOptimal(arr,arr.length));
	}

	/*
	 * Time Complexity: O(n^3)
	 * Space Complexity: O(1)
	 * */
	private static int sumOfSubarrayMinimumBrute(int[] arr, int n) {

		int sum=0;

		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int min=Integer.MAX_VALUE;

				for(int k=i;k<=j;k++)
				{
					min=Math.min(min,arr[k]);
				}

				sum=(sum+min)%MOD;
			}
		}

		return sum;
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static int sumOfSubarrayMinimumBetter(int[] arr, int n) {

		int sum=0;

		for(int i=0;i<n;i++)
		{
			int min=Integer.MAX_VALUE;

			for(int j=i;j<n;j++)
			{
				min=Math.min(min,arr[j]);
				sum=(sum+min)%MOD;
			}
		}

		return sum;
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static int sumOfSubarrayMinimumOptimal(int[] arr, int n) {

		int pse[]=findPreviousSmallerElement(arr,n);
		int nge[]=findNextSmallerElement(arr,n);
		long result=0;

		for(int i=0;i<n;i++)
		{
			result=(result+((long)arr[i]*pse[i]*nge[i]))%MOD;
		}

		return (int)result;
	}

	private static int[] findNextSmallerElement(int[] arr, int n) {

		Stack<Integer> stack=new Stack<>();
		int nse[]=new int[n];

		for(int i=n-1;i>=0;i--)
		{
			while(!stack.isEmpty() && arr[i]<=arr[stack.peek()])
			{
				stack.pop();
			}

			nse[i]=stack.isEmpty()?n-i:stack.peek()-i;
			stack.push(i);
		}

		return nse;
	}

	private static int[] findPreviousSmallerElement(int[] arr,int n) {

		Stack<Integer> stack=new Stack<>();
		int pse[]=new int[n];

		for(int i=0;i<n;i++)
		{
			while(!stack.isEmpty() && arr[i]<arr[stack.peek()])
			{
				stack.pop();
			}

			pse[i]=stack.isEmpty()?i+1:i-stack.peek();
			stack.push(i);
		}

		return pse;
	}
}
