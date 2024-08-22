package DynamicProgramming.d2.grids;

import java.util.Arrays;

public class UniquePaths2WithObstacles {

	public static void main(String[] args) {
		
		int n = 3, m = 3,grid[][] = {{1, 1, 1},{1, 0, 1},{1, 1, 1}};
		
//		System.out.println(uniquePathsWithObstaclesRecursion(n-1,m-1,grid));
//		System.out.println(uniquePathsWithObstaclesMemoization(n, m, grid));
//		System.out.println(uniquePathsWithObstaclesTabulation(n, m, grid));
		System.out.println(uniquePathsWithObstaclesSpaceOptimized(n, m, grid));

	}

	private static int uniquePathsWithObstaclesSpaceOptimized(int n, int m, int[][] grid) {
		
		int prev[]=new int[m];
		
		for(int i=0;i<n;i++)
		{
			int curr[]=new int[m];
			
			for(int j=0;j<m;j++)
			{
				if(grid[i][j]==0)
				{
					curr[j]=0;
				}
				else if(i==0 && j==0)
				{
					curr[j]=1;
				}
				else
				{
					int up=0,left=0;
					if(i>0) up=prev[j];
					if(j>0) left=curr[j-1];
					
					curr[j]=up+left;
				}
			}
			
			prev=curr;
		}
		
		return prev[m-1];
	}

	private static int uniquePathsWithObstaclesTabulation(int n, int m, int[][] grid) {
		
		int dp[][]=new int[n][m];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(grid[i][j]==0)
				{
					dp[i][j]=0;
				}
				else if(i==0 && j==0)
				{
					dp[i][j]=1;
				}
				else
				{
					int up=0;
					if(i>0) up=dp[i-1][j];
					int left=0;
					if(j>0) left=dp[i][j-1];
					
					dp[i][j]=up+left;
				}
			}
		}
		return dp[n-1][m-1];
	}

	private static int uniquePathsWithObstaclesMemoization(int n, int m, int[][] grid) {
		
		int dp[][]=new int[n][m];
		
		for(int row[]:dp)
		{
			Arrays.fill(row, -1);
		}
		
		return uniquePathsWithObstaclesMemo(n-1,m-1,grid,dp);
	}

	private static int uniquePathsWithObstaclesMemo(int i, int j, int[][] grid, int[][] dp) {
		
		if(i>=0 && j>=0 && grid[i][j]==0) return 0;
		if(i==0 && j==0) return 1;
		if(i<0 || j<0) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		int up=uniquePathsWithObstaclesMemo(i-1, j, grid, dp);
		int left=uniquePathsWithObstaclesMemo(i, j-1, grid, dp);
		
		return dp[i][j]=up+left;
	}

	private static int uniquePathsWithObstaclesRecursion(int i, int j, int[][] grid) {
		
		if(i>=0 && j>=0 && grid[i][j]==0) return 0;
		if(i==0 && j==0) return 1;
		if(i<0 || j<0) return 0;
		
		int up=uniquePathsWithObstaclesRecursion(i-1, j, grid);
		int left=uniquePathsWithObstaclesRecursion(i, j-1, grid);
		
		return up+left;
	}
}
