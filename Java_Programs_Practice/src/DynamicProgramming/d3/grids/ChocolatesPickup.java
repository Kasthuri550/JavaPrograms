package DynamicProgramming.d3.grids;

import java.util.Arrays;

public class ChocolatesPickup {

	public static void main(String[] args) {

		int n = 4, m = 3, grid[][] = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};

		System.out.println(chocolatesPickupRecursion(0,0,m-1,n,m,grid));
		System.out.println(chocolatesPickupMemoization(0, 0,m-1, n, m, grid));
		System.out.println(chocolatesPickupTabulation(n,m,grid));
		System.out.println(chocolatesPickupSpaceOptimized(n, m, grid));
	}

	/*
	 * Time Complexity: O(n*m^2)
	 * Space Complexity: O(m^2)
	 * */
	private static int chocolatesPickupSpaceOptimized(int n, int m, int[][] grid) {

		int front[][]=new int[m][m];
		int curr[][]=new int[m][m];

		for(int j1=0;j1<m;j1++)
		{
			for(int j2=0;j2<m;j2++)
			{
				if(j1==j2)
					front[j1][j2]=grid[n-1][j1];
				else
					front[j1][j2]=grid[n-1][j1]+grid[n-1][j2];
			}
		}


		for(int i=n-2;i>=0;i--)
		{
			for(int j1=0;j1<m;j1++)
			{
				for(int j2=0;j2<m;j2++)
				{
					int max=Integer.MIN_VALUE;

					for(int dj1=-1;dj1<=1;dj1++)
					{
						for(int dj2=-1;dj2<=1;dj2++)
						{
							int value;

							if(j1==j2)
								value=grid[i][j1];
							else
								value=grid[i][j1]+grid[i][j2];

							if((j1+dj1<0 || j1+dj1>=m) || (j2+dj2<0 ||j2+dj2>=m))
								value+=(int)-1e9;
							else
								value+=front[j1+dj1][j2+dj2];

							max=Math.max(max, value);
						}
					}

					curr[j1][j2]=max;
				}
			}

			for(int k=0;k<m;k++)
			{
				front[k]=curr[k].clone();
			}
		}
		return front[0][m-1];
	}

	/*
	 * Time Complexity: O(n*m^2)
	 * Space Complexity: O(n*m^2)
	 * */
	private static int chocolatesPickupTabulation(int n, int m, int[][] grid) {

		int dp[][][]=new int[n][m][m];

		for(int j1=0;j1<m;j1++)
		{
			for(int j2=0;j2<m;j2++)
			{
				if(j1==j2)
					dp[n-1][j1][j2]=grid[n-1][j1];
				else
					dp[n-1][j1][j2]=grid[n-1][j1]+grid[n-1][j2];
			}
		}


		for(int i=n-2;i>=0;i--)
		{
			for(int j1=0;j1<m;j1++)
			{
				for(int j2=0;j2<m;j2++)
				{
					int max=Integer.MIN_VALUE;

					for(int dj1=-1;dj1<=1;dj1++)
					{
						for(int dj2=-1;dj2<=1;dj2++)
						{
							int value;

							if(j1==j2)
								value=grid[i][j1];
							else
								value=grid[i][j1]+grid[i][j2];

							if((j1+dj1<0 || j1+dj1>=m) || (j2+dj2<0 ||j2+dj2>=m))
								value+=(int)-1e9;
							else
								value+=dp[i+1][j1+dj1][j2+dj2];

							max=Math.max(max, value);
						}
					}

					dp[i][j1][j2]=max;
				}
			}
		}
		return dp[0][0][m-1];
	}

	/*
	 * Time Complexity: O(n*m^2)
	 * Space Complexity: O(n*m^2)
	 * */
	private static int chocolatesPickupMemoization(int i, int j1, int j2, int n, int m, int[][] grid) {

		int dp[][][]=new int[n][m][m];

		for(int row1[][]:dp)
		{
			for(int row2[]:row1)
			{
				Arrays.fill(row2,-1);
			}
		}

		return chocolatesPickupMemo(i,j1,j2,n,m,grid,dp);
	}

	private static int chocolatesPickupMemo(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp) {

		if(j1<0 || j1>=m || j2<0 || j2>=m) return (int)-1e9;

		if(i==n-1)
		{
			if(j1==j2)
				return grid[i][j1];
			else
				return grid[i][j1]+grid[i][j2];
		}

		int max=Integer.MIN_VALUE;

		for(int dj1=-1;dj1<=1;dj1++)
		{
			for(int dj2=-1;dj2<=1;dj2++)
			{
				int value;

				if(j1==j2)
					value=grid[i][j1]+chocolatesPickupMemo(i+1,j1+dj1,j2+dj2, n, m, grid, dp);
				else
					value=grid[i][j1]+grid[i][j2]+chocolatesPickupMemo(i+1,j1+dj1,j2+dj2, n, m, grid, dp);

				max=Math.max(max, value);
			}
		}

		return dp[i][j1][j2]=max;
	}

	/*
	 * Time Complexity: O(9^n)
	 * Space Complexity: O(n)
	 * */
	private static int chocolatesPickupRecursion(int i, int j1,int j2,int n,int m, int[][] grid) {

		if(j1<0 || j1>=m || j2<0 || j2>=m) return (int)-1e9;

		if(i==n-1)
		{
			if(j1==j2)
				return grid[i][j1];
			else
				return grid[i][j1]+grid[i][j2];
		}

		int max=Integer.MIN_VALUE;

		for(int dj1=-1;dj1<=1;dj1++)
		{
			for(int dj2=-1;dj2<=1;dj2++)
			{
				int value;
				if(j1==j2)
					value=grid[i][j1]+chocolatesPickupRecursion(i+1,j1+dj1,j2+dj2, n, m, grid);
				else
					value=grid[i][j1]+grid[i][j2]+chocolatesPickupRecursion(i+1,j1+dj1,j2+dj2, n, m, grid);

				max=Math.max(max, value);
			}
		}

		return max;
	}
}
