package DynamicProgramming.d2.grids;

import java.util.Arrays;

public class MinimumPathSumInTriangularGrid {

	public static void main(String[] args) {

		int n = 4,triangle[][] = {{2},{3,4},{6,5,7},{4,1,8,3}};

		System.out.println(trianglePathSumRecursion(0,0,n,triangle));
		System.out.println(trianglePathSumMemoization(0, 0, n, triangle));
		System.out.println(trianglePathSumTabulation(n, triangle));
		System.out.println(trianglePathSumSpaceOptimized(n, triangle));
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n)
	 * */
	private static int trianglePathSumSpaceOptimized(int n, int[][] triangle) {

		int front[]=new int[n];

		for(int j=0;j<n;j++)
		{
			front[j]=triangle[n-1][j];
		}

		for(int i=n-2;i>=0;i--)
		{
			int curr[]=new int[n];
			for(int j=i;j>=0;j--)
			{
				int down=triangle[i][j]+front[j];
				int diagonal=triangle[i][j]+front[j+1];

				curr[j]=Math.min(down, diagonal);
			}

			front=curr;
		}

		return front[0];
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n^2)
	 * */
	private static int trianglePathSumTabulation(int n, int[][] triangle) {

		int dp[][]=new int[n][n];

		for(int j=0;j<n;j++)
		{
			dp[n-1][j]=triangle[n-1][j];
		}

		for(int i=n-2;i>=0;i--)
		{
			for(int j=i;j>=0;j--)
			{
				int down=triangle[i][j]+dp[i+1][j];
				int diagonal=triangle[i][j]+dp[i+1][j+1];

				dp[i][j]=Math.min(down, diagonal);
			}
		}

		return dp[0][0];
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n^2)
	 * */
	private static int trianglePathSumMemoization(int i, int j, int n, int[][] triangle) {

		int dp[][]=new int[n][n];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return trianglePathSumMemo(i, j, n, triangle,dp);
	}

	private static int trianglePathSumMemo(int i, int j, int n, int[][] triangle,int dp[][]) {

		if(i==n-1)
			return triangle[i][j];

		if(dp[i][j]!=-1) return dp[i][j];

		int down=triangle[i][j]+trianglePathSumMemo(i+1, j,n, triangle,dp);
		int diagonal=triangle[i][j]+trianglePathSumMemo(i+1, j+1,n, triangle,dp);

		return dp[i][j]=Math.min(down, diagonal);
	}

	/*
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(n)
	 * */
	private static int trianglePathSumRecursion(int i, int j, int n, int[][] triangle) {

		if(i==n-1)
			return triangle[i][j];

		int down=triangle[i][j]+trianglePathSumRecursion(i+1,j,n,triangle);
		int diagonal=triangle[i][j]+trianglePathSumRecursion(i+1, j+1,n, triangle);

		return Math.min(down, diagonal);
	}
}
