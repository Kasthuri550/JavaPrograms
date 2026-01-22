package DynamicProgramming.squares;

import java.util.Stack;

public class LargestRectangleAreaInHistogram {

	public static void main(String[] args) {

		int N =6, heights[] = {2,1,5,6,2,3};

		System.out.println(largestRectangleAreaBrute(N, heights));
		System.out.println(largestRectangleAreaBetter(N, heights));
		System.out.println(largestRectangleAreaOptimal(N, heights));
	}

	/*
	 * Time Complexity:O(n)
	 * Space Complexity: O(n)
	 * */
	public static int largestRectangleAreaOptimal(int n, int[] heights) {

		Stack<Integer> stack=new Stack<>();
		int maxArea=Integer.MIN_VALUE;

		for(int i=0;i<=n;i++)
		{
			while(!stack.isEmpty() && (i==n || heights[stack.peek()]>=(i<n?heights[i]:0)))
			{
				int h=heights[stack.pop()];

				int width;

				if(stack.isEmpty())
					width=i;
				else
					width=i-stack.peek()-1;

				maxArea=Math.max(maxArea,width*h);
			}

			stack.push(i);
		}

		return maxArea;
	}

	/*
	 * Time Complexity:O(n)
	 * Space Complexity: O(n)
	 * */
	public static int largestRectangleAreaBetter(int n, int[] heights) {

		Stack<Integer> stack=new Stack<>();
		int leftSmall[]=new int[n];
		int rightSmall[]=new int[n];

		for(int i=0;i<n;i++)
		{
			while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
			{
				stack.pop();
			}

			leftSmall[i]=stack.isEmpty()?0:stack.peek()+1;

			stack.push(i);
		}

		stack.clear();

		for(int i=n-1;i>=0;i--)
		{
			while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
			{
				stack.pop();
			}

			rightSmall[i]=stack.isEmpty()?n-1:stack.peek()-1;

			stack.push(i);
		}

		int maxArea=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			int width=rightSmall[i]-leftSmall[i]+1;
			maxArea=Math.max(maxArea, width*heights[i]);
		}

		return maxArea;
	}

	/*
	 * Time Complexity:O(N^2)
	 * Space Complexity: O(1)
	 * */	
	public static int largestRectangleAreaBrute(int N,int heights[])
	{
		int maxArea=Integer.MIN_VALUE;

		for(int i=0;i<N;i++)
		{
			int minHeight=Integer.MAX_VALUE;

			for(int j=i;j<N;j++)
			{
				minHeight=Math.min(minHeight,heights[j]);

				int area=minHeight*(j-i+1);

				maxArea=Math.max(maxArea,area);
			}
		}

		return maxArea;
	}
}
