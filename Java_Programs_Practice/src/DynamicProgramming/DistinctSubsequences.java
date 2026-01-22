package DynamicProgramming;

import java.util.Arrays;

public class DistinctSubsequences {

	public static void main(String[] args) {

		String s1="babgbag",s2="bag";

		//		System.out.println(distinctSubsequencesRecurrsive(s1.length()-1,s2.length()-1,s1,s2));
		System.out.println(distinctSubsequencesMemo(s1.length()-1,s2.length()-1,s1,s2));
		//		System.out.println(distinctSubsequencesTabulation(s1.length(),s2.length(),s1,s2));
		//		System.out.println(distinctSubsequencesSpaceOptimized(s1.length(),s2.length(), s1, s2));
		//		System.out.println(distinctSubsequencesSpaceOptimizedMore(s1.length(),s2.length(), s1, s2));

	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(n)
	 * */
	private static int distinctSubsequencesSpaceOptimizedMore(int m, int n, String s1, String s2) {

		int prev[]=new int[n+1];

		prev[0]=1;

		for(int i=1;i<=m;i++)
		{
			for(int j=n;j>=1;j--)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					prev[j]=prev[j-1]+prev[j];
				}
				else
				{
					prev[j]=prev[j];
				}
			}
		}
		return prev[n];
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(n)
	 * */
	private static int distinctSubsequencesSpaceOptimized(int m, int n, String s1, String s2) {

		int prev[]=new int[m+1];
		int cur[]=new int[n+1];

		prev[0]=cur[0]=1;

		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					cur[j]=prev[j-1]+prev[j];
				}
				else
				{
					cur[j]=prev[j];
				}
			}

			prev=cur.clone();
		}
		return prev[n];
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 * */
	private static int distinctSubsequencesTabulation(int m, int n, String s1, String s2) {

		int dp[][]=new int[m+1][n+1];

		return dst(m,n,s1,s2,dp);
	}

	private static int dst(int m, int n, String s1, String s2, int[][] dp) {

		for(int i=0;i<=m;i++)
		{
			dp[i][0]=1;
		}

		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			}
		}

		return dp[m][n];
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 * */
	private static int distinctSubsequencesMemo(int m, int n, String s1, String s2) {

		int dp[][]=new int[m+1][n+1];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return dsm(m,n,s1,s2,dp);
	}

	private static int dsm(int m, int n, String s1, String s2, int[][] dp) {

		if(n<0) return 1;

		if(m<0) return 0;

		if(dp[m][n]!=-1)
			return dp[m][n];

		if(s1.charAt(m)==s2.charAt(n))
		{
			dp[m][n]=dsm(m-1, n-1, s1, s2, dp)+dsm(m-1, n, s1, s2, dp);
		}
		else
		{
			dp[m][n]=dsm(m-1, n, s1, s2, dp);		
		}

		return dp[m][n];
	}

	/*
	 * Time Complexity: O(2^m)
	 * Space Complexity: O(m)
	 * */
	private static int distinctSubsequencesRecurrsive(int i, int j, String s1, String s2) {

		if(j<0) return 1;

		if(i<0) return 0;

		if(s1.charAt(i)==s2.charAt(j))
		{
			return distinctSubsequencesRecurrsive(i-1, j-1, s1, s2)+distinctSubsequencesRecurrsive(i-1, j, s1, s2);
		}

		return distinctSubsequencesRecurrsive(i-1, j, s1, s2);
	}
}
