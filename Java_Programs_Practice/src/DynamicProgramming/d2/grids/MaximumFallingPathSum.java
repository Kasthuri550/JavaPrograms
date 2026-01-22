package DynamicProgramming.d2.grids;

import java.util.Arrays;

public class MaximumFallingPathSum {

	public static void main(String[] args) {

		//		int matrix[][] = {{1, 2, 10, 4},
		//			                {100, 3, 2, 1},
		//			                {1, 1, 20, 2},
		//			                {1, 2, 2, 1}};
		int matrix[][] = {{348, 391},{618, 193}};

		//		System.out.println(maximumFallingPathSumRecursion1(matrix));
		//		System.out.println(maximumFallingPathSumMemoization1(matrix));
		System.out.println(maximumFallingPathSumTabulation1(matrix));
		System.out.println(maximumFallingPathSumSpaceOptimized(matrix));

	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m)
	 * */
	private static int maximumFallingPathSumSpaceOptimized(int[][] matrix) {

		int n=matrix.length,m=matrix[0].length;
		int prev[]=new int[m];

		for(int j=0;j<m;j++)
		{
			prev[j]=matrix[0][j];
		}

		for(int i=1;i<n;i++)
		{
			int curr[]=new int[m];
			for(int j=0;j<m;j++)
			{
				int upward=matrix[i][j]+prev[j];
				int leftDiagonal=matrix[i][j];
				if(j-1>=0)
					leftDiagonal+=prev[j-1];
				else
					leftDiagonal+=-1e9;
				int rightDiagonal=matrix[i][j];

				if(j+1<m)
					rightDiagonal+=prev[j+1];
				else
					rightDiagonal+=-1e9;

				curr[j]=Math.max(upward, Math.max(leftDiagonal, rightDiagonal));
			}
			prev=curr;
		}

		int max=Integer.MIN_VALUE;

		for(int j=0;j<m;j++)
		{
			max=Math.max(max,prev[j]);
		}

		return max;
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 * */
	private static int maximumFallingPathSumTabulation1(int[][] matrix) {

		int n=matrix.length,m=matrix[0].length;
		int dp[][]=new int[n][m];

		for(int j=0;j<m;j++)
		{
			dp[0][j]=matrix[0][j];
		}

		for(int i=1;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				int upward=matrix[i][j]+dp[i-1][j];
				int leftDiagonal=matrix[i][j];
				if(j-1>=0) 
					leftDiagonal+=dp[i-1][j-1];
				else
					leftDiagonal+=(int)-1e9;
				int rightDiagonal=matrix[i][j];
				if(j+1<m) 
					rightDiagonal+=dp[i-1][j+1];
				else
					rightDiagonal+=(int)-1e9;

				dp[i][j]=Math.max(upward, Math.max(leftDiagonal, rightDiagonal));
			}
		}

		int max=Integer.MIN_VALUE;

		for(int j=0;j<m;j++)
		{
			max=Math.max(max,dp[n-1][j]);
		}

		return max;
	}

	private static int maximumFallingPathSumMemoization1(int[][] matrix) {

		int n=matrix.length,m=matrix[0].length;
		int dp[][]=new int[n][m];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return maximumFallingPathSumMemoization2(matrix,n,m,dp);
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 * */
	private static int maximumFallingPathSumMemoization2(int[][] matrix,int n,int m, int[][] dp) {

		int max=Integer.MIN_VALUE;

		for(int j=0;j<m;j++)
		{
			max=Math.max(max, maximumFallingPathSumMemoization3(n-1,j,m,matrix,dp));
		}

		return max;
	}

	private static int maximumFallingPathSumMemoization3(int i, int j,int m,int[][] matrix, int[][] dp) {

		if(j<0 || j>=m) return (int)-1e9;
		if(i==0) return matrix[i][j];

		if(dp[i][j]!=-1) return dp[i][j];

		int upward=matrix[i][j]+maximumFallingPathSumMemoization3(i-1, j,m,matrix, dp);
		int leftDiagonal=matrix[i][j]+maximumFallingPathSumMemoization3(i-1, j-1,m,matrix, dp);
		int rightDiagonal=matrix[i][j]+maximumFallingPathSumMemoization3(i-1, j+1,m,matrix, dp);

		return dp[i][j]=Math.max(upward,Math.max(leftDiagonal, rightDiagonal));
	}

	/*
	 * Time Complexity: O(3^n)
	 * Space Complexity: O(n)
	 * */
	private static int maximumFallingPathSumRecursion1(int[][] matrix) {

		int n=matrix.length,m=matrix[0].length,max=Integer.MIN_VALUE;

		for(int j=0;j<m;j++)
		{
			max=Math.max(max,maximumFallingPathSumRecursion2(n-1,j,matrix));		
		}

		return max;
	}

	private static int maximumFallingPathSumRecursion2(int i,int j,int matrix[][]) {

		if(j<0 || j>=matrix[0].length) return (int)-1e9;

		if(i==0) return matrix[0][j];

		int upward=matrix[i][j]+maximumFallingPathSumRecursion2(i-1, j, matrix);
		int leftDiagonal=matrix[i][j]+maximumFallingPathSumRecursion2(i-1, j-1, matrix);
		int rightDiagonal=matrix[i][j]+maximumFallingPathSumRecursion2(i-1, j+1, matrix);

		return Math.max(upward, Math.max(leftDiagonal, rightDiagonal));
	}
}
