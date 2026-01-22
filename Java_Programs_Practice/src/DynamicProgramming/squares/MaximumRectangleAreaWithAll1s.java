package DynamicProgramming.squares;

public class MaximumRectangleAreaWithAll1s {

	public static void main(String[] args) {

		int[][] matrix= {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};

		System.out.println(maximumRectangle(matrix));
	}

	/*
	 * Time Complexity:O(m*n)
	 * Space Complexity: O(n)
	 * */
	private static int maximumRectangle(int[][] matrix) {

		int m=matrix.length,n=matrix[0].length;
		int maxArea=Integer.MIN_VALUE;

		int heights[]=new int[n];

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(matrix[i][j]==1)
					heights[j]++;
				else
					heights[j]=0;
			}

			maxArea=Math.max(maxArea,LargestRectangleAreaInHistogram.largestRectangleAreaBrute(heights.length,heights));
		}

		return maxArea;
	}
}
