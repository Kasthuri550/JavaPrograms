package Arrayprograms;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,3};
		nextGreater1(nums);
		nextGreater2(nums);
		nextGreater3(nums);
	}

	private static void nextGreater3(int[] nums) {
		
		int n=nums.length;
		for(int i=0;i<n-1;i++)
		{
			if(nums[i]<nums[i+1])
			{
				nums[i]=nums[i+1];
			}
			else
			{
				nums[i]=-1;
			}
		}
		nums[n-1]=-1;
		System.out.println(Arrays.toString(nums));
	}

	private static void nextGreater2(int[] nums) {
		
		int n=nums.length;
		int nge[]=new int[n];
		
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(nums[i]<nums[j])
				{
					nge[i]=nums[j];
					break;
				}
			}
		}
		System.out.println(Arrays.toString(nge));
		
	}

	private static void nextGreater1(int[] nums) {
		
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
