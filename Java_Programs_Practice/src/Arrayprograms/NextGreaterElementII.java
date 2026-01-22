package Arrayprograms;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

	public static void main(String[] args) {

		int[] nums = {1,2,3,4,3};

		nextGreaterBrute(nums);
		nextGreaterOptimal(nums);
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity:O(n)
	 * */
	private static void nextGreaterBrute(int[] nums) {

		int n=nums.length;
		int nge[]=new int[n];

		Arrays.fill(nge, -1);

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<i+n;j++)
			{
				int index=j%n;

				if(nums[index]>nums[i])
				{
					nge[i]=nums[index];
					break;
				}
			}
		}
		System.out.println(Arrays.toString(nge));

	}

	/*
	 * Time Complexity: O(2n)
	 * Space Complexity:O(n)
	 * */
	private static void nextGreaterOptimal(int[] nums) {

		int n=nums.length;
		Stack<Integer> stack=new Stack<Integer>();
		int nge[]=new int[n];

		for(int i=2*n-1;i>=0;i--)
		{
			while(!stack.isEmpty() && stack.peek()<=nums[i%n])
			{
				stack.pop();
			}
			if(i<n)
			{
				nge[i]=stack.isEmpty()?-1:stack.peek();
			}

			stack.push(nums[i%n]);	
		}

		System.out.println(Arrays.toString(nge));
	}

}
