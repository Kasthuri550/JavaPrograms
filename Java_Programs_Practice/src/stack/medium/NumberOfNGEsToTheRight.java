package stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfNGEsToTheRight {

	public static void main(String[] args) {

		int[] arr = {3, 4, 2, 7, 5};

		countNGEBrute(arr,arr.length);
		countNGEOptimal(arr,arr.length);
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static void countNGEOptimal(int[] arr, int n) {

		Stack<Integer> stack=new Stack<>();
		int nge[]=new int[n];

		for(int i=n-1;i>=0;i--)
		{
			while(!stack.isEmpty() && stack.peek()<=arr[i])
			{
				stack.pop();
			}

			if(!stack.isEmpty())
			{
				nge[i]=stack.size()+1;
			}
			stack.push(arr[i]);
		}

		System.out.println(Arrays.toString(nge));
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n)
	 * */	
	private static void countNGEBrute(int[] arr, int n) {

		int nge[]=new int[n];

		for(int i=0;i<n;i++)
		{
			int count=0;
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]<arr[j])
				{
					count++;					
				}
			}
			nge[i]=count;
		}

		System.out.println(Arrays.toString(nge));
	}
}
