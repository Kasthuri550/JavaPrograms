package stack.hard;

import java.util.Stack;

/*
 * Time Complexity: O(n*m)
 * Space Complexity: O(n*m)
 * */
public class MaximalRectangles {

	public static void main(String[] args) {

		int[][] matrix = {
				{1, 0, 1, 0, 0},
				{1, 0, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 0, 0, 1, 0}
		};

		System.out.println(maximalRectangles(matrix));
	}

	private static int maximalRectangles(int[][] matrix) {

		int m=matrix.length,n=matrix[0].length;
		int prefix[][]=new int[m][n];

		for(int j=0;j<n;j++)
		{
			int sum=0;
			for(int i=0;i<m;i++)
			{
				sum+=matrix[i][j];

				if(matrix[i][j]==0)
				{
					prefix[i][j]=0;
					sum=0;
				}
				else
				{
					prefix[i][j]=sum;
				}
			}
		}

		int maxArea=0;

		for(int i=0;i<m;i++)
		{
			int area=largestRectangleAreaInHistogram(prefix[i]);
			maxArea=Math.max(maxArea,area);
		}

		return maxArea;
	}

	private static int largestRectangleAreaInHistogram(int[] height) {

		int n=height.length;
		Stack<Integer> stack=new Stack<>();
		int maxArea=0;

		for(int i=0;i<=n;i++)
		{
			while(!stack.isEmpty() && (i==n || (height[stack.peek()]>=(i<n?height[i]:0))))
			{
				int h=height[stack.pop()];
				int width;

				width=stack.isEmpty()?i:i-stack.peek()-1;

				int area=h*width;
				maxArea=Math.max(maxArea, area);
			}
			stack.push(i);
		}

		return maxArea;
	}
}
