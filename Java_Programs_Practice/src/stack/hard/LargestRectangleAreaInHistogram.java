package stack.hard;

import java.util.Stack;

public class LargestRectangleAreaInHistogram {

	public static void main(String[] args) {

		int[] histo = {2,1,5,6,2,3};

		System.out.println(largestRectangleAreaInHistogramBrute(histo));
		System.out.println(largestRectangleAreaInHistogramOptimal1(histo));
		System.out.println(largestRectangleAreaInHistogramOptimal2(histo));
	}

	/*
	 * Time Complexity: O(n)+O(n)
	 * Space Complexity: O(n)
	 * */	
	private static int largestRectangleAreaInHistogramOptimal2(int[] height) {

		int n=height.length,maxArea=Integer.MIN_VALUE;
		Stack<Integer> stack=new Stack<>();

		for(int i=0;i<=n;i++)
		{
			while(!stack.isEmpty() && (i==n || height[stack.peek()]>=(i<n?height[i]:0)))
			{
				int h=height[stack.pop()];
				int width;

				width=stack.isEmpty()?i:i-stack.peek()-1;

				int area=width*h;
				maxArea=Math.max(maxArea,area);
			}

			stack.push(i);
		}

		return maxArea;
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(3n)
	 * */	
	private static int largestRectangleAreaInHistogramOptimal1(int[] height) {

		int n=height.length;
		int leftSmall[]=new int[n];
		int rightSmall[]=new int[n];
		Stack<Integer> stack=new Stack<>();
		int maxArea=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			while(!stack.isEmpty() && height[stack.peek()]>=height[i])
			{
				stack.pop();
			}

			leftSmall[i]=stack.isEmpty()?0:stack.peek()+1;

			stack.push(i);
		}

		stack.clear();
		
		for(int i=n-1;i>=0;i--) 
		{
			while(!stack.isEmpty() && height[stack.peek()]>=height[i])
			{
				stack.pop();
			}

			rightSmall[i]=stack.isEmpty()?n-1:stack.peek()-1;

			stack.push(i);
		}

		for(int i=0;i<n;i++)
		{
			int width=rightSmall[i]-leftSmall[i]+1;
			maxArea=Math.max(maxArea,width*height[i]);
		}

		return maxArea;
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */	
	private static int largestRectangleAreaInHistogramBrute(int[] histo) {

		int n=histo.length,maxArea=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			int minHeight=Integer.MAX_VALUE;
			for(int j=i;j<n;j++)
			{
				minHeight=Math.min(minHeight,histo[j]);
				int area=minHeight*(j-i+1);
				maxArea=Math.max(maxArea,area);
			}
		}

		return maxArea;
	}
}
