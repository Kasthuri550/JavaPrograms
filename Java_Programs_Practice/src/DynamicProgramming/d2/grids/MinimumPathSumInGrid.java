package DynamicProgramming.d2.grids;

import java.util.Arrays;

public class MinimumPathSumInGrid {

	public static void main(String[] args) {

		int grid[][] ={{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}},n=grid.length,m=grid[0].length;

		System.out.println(minimumPathSumInGridRecursion(n-1,m-1,grid));
		System.out.println(minimumPathSumInGridMemoization(n, m, grid));
		System.out.println(minimumPathSumInGridTabulation(n, m, grid));
		System.out.println(minimumPathSumInGridSpaceOptimized(n, m, grid));

	}

	/*
	 * Time Complexity: O((m*n))
	 * Space Complexity: O(m)
	 * */
	private static int minimumPathSumInGridSpaceOptimized(int n, int m, int[][] grid) {

		int prev[]=new int[m];

		for(int i=0;i<n;i++)
		{
			int curr[]=new int[m];

			for(int j=0;j<m;j++)
			{
				if(i==0 && j==0)
				{
					curr[j]=grid[i][j];
				}
				else
				{
					int up=grid[i][j];

					if(i>0)
					{
						up+=prev[j];
					}
					else
					{
						up+=(int)1e9;
					}

					int left=grid[i][j];

					if(j>0)
					{
						left+=curr[j-1];
					}
					else
					{
						left+=(int)1e9;
					}

					curr[j]=Math.min(up, left);
				}
			}

			prev=curr;
		}

		return prev[m-1];
	}

	/*
	 * Time Complexity: O((m*n))
	 * Space Complexity: O(m+n)
	 * */
	private static int minimumPathSumInGridTabulation(int n, int m, int[][] grid) {

		int dp[][]=new int[n][m];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(i==0 && j==0)
				{
					dp[i][j]=grid[i][j];
				}
				else
				{
					int up=grid[i][j];

					if(i>0)
					{
						up+=dp[i-1][j];
					}
					else
					{
						up+=(int)1e9;
					}

					int left=grid[i][j];

					if(j>0)
					{
						left+=dp[i][j-1];
					}
					else
					{
						left+=(int)1e9;
					}

					dp[i][j]=Math.min(up, left);
				}
			}
		}

		return dp[n-1][m-1];
	}

	/*
	 * Time Complexity: O((m*n))
	 * Space Complexity: O(m+n)
	 * */
	private static int minimumPathSumInGridMemoization(int n, int m, int[][] grid) {

		int dp[][]=new int[n][m];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return minimumPathSumInGridMemo(n-1, m-1, grid,dp);
	}

	private static int minimumPathSumInGridMemo(int i, int j, int[][] grid, int[][] dp) {

		if(i==0 && j==0) return grid[0][0];
		if(i<0 || j<0) return (int)1e9;

		if(dp[i][j]!=-1) return dp[i][j];

		int up=grid[i][j]+minimumPathSumInGridMemo(i-1, j, grid,dp);
		int left=grid[i][j]+minimumPathSumInGridMemo(i, j-1, grid,dp);

		return dp[i][j]=Math.min(up, left);
	}

	/*
	 * Time Complexity: O(2^(m+n))
	 * Space Complexity: O(m+n)
	 * */
	private static int minimumPathSumInGridRecursion(int i, int j, int[][] grid) {

		if(i==0 && j==0) return grid[0][0];
		if(i<0 || j<0) return (int)1e9;

		int up=grid[i][j]+minimumPathSumInGridRecursion(i-1, j, grid);
		int left=grid[i][j]+minimumPathSumInGridRecursion(i, j-1, grid);

		return Math.min(up, left);
	}
}
