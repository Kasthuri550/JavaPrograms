package DynamicProgramming.squares;

public class MaximalSquare {

	public static void main(String[] args) {

		char matrix[][] = {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
		};

		System.out.println(maximalSquare(matrix));
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 * */	
	private static int maximalSquare(char[][] matrix) {

		int m=matrix.length,n=matrix[0].length,maxSide=Integer.MIN_VALUE;

		int dp[][]=new int[m][n];

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(matrix[i][j]=='1')
				{
					if(i==0 || j==0)
					{
						dp[i][j]=1;
					}
					else
					{
						dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
					}

					maxSide=Math.max(maxSide,dp[i][j]);
				}
				else
				{
					dp[i][j]=0;
				}
			}
		}

		return maxSide*maxSide;
	}
}
