package DynamicProgramming.d2.grids;

import java.util.Arrays;

public class GridUniquePaths {

	public static void main(String[] args) 
	{
		int m = 3, n = 7;

		System.out.println(gridUniquePathsRecursion(m-1,n-1));
		System.out.println(gridUniquePathsMemoization(m,n));
		System.out.println(gridUniquePathsTabulation(m, n));
		System.out.println(gridUniquePathsSpaceOptimized(m, n));
	}

	/*
	 * Time Complexity: O((m*n))
	 * Space Complexity: O(n)
	 * */
	private static int gridUniquePathsSpaceOptimized(int m, int n) {

		int prev[]=new int[n],curr[]=new int[n];

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==0 && j==0)
				{
					curr[j]=1;
					continue;
				}
				int up=0,left=0;

				if(i>0) up=prev[j];
				if(j>0) left=curr[j-1];

				curr[j]=up+left;
			}

			prev=curr.clone();
		}

		return prev[n-1];
	}

	/*
	 * Time Complexity: O((m*n))
	 * Space Complexity: O(m+n)
	 * */
	private static int gridUniquePathsTabulation(int m, int n) {

		int dp[][]=new int[m][n];


		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==0 && j==0)
				{
					dp[i][j]=1;
					continue;
				}

				int up=0,left=0;

				if(i>0) up=dp[i-1][j];
				if(j>0) left=dp[i][j-1];

				dp[i][j]=up+left;
			}
		}

		return dp[m-1][n-1];
	}

	/*
	 * Time Complexity: O((m*n))
	 * Space Complexity: O(m+n)
	 * */
	private static int gridUniquePathsMemoization(int m, int n) {

		int dp[][]=new int[m][n];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return gridUniquePathsMemo(m-1, n-1,dp);
	}

	private static int gridUniquePathsMemo(int i, int j,int dp[][]) {

		if(i==0 && j==0) return 1;
		if(i<0 || j<0) return 0;

		if(dp[i][j]!=-1) return dp[i][j];

		int up=gridUniquePathsMemo(i-1, j,dp);
		int left=gridUniquePathsMemo(i, j-1,dp);

		return dp[i][j]=up+left;
	}

	/*
	 * Time Complexity: O(2^(m+n))
	 * Space Complexity: O(m+n)
	 * */	
	private static int gridUniquePathsRecursion(int i, int j) {

		if(i==0 && j==0)
			return 1;
		if(i<0 || j<0) 
			return 0;

		int up=gridUniquePathsRecursion(i-1, j);
		int left=gridUniquePathsRecursion(i, j-1);

		return up+left;
	}
}
