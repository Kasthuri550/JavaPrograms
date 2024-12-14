package DynamicProgramming.strings;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {

		String s1 = "bbabcbcab";
		
		StringBuilder sb=new StringBuilder(s1);
		String s2=sb.reverse().toString();
		
		System.out.println(lpsBrute(s1,s2,s1.length(),s2.length()));
//		System.out.println(lpsMemo(s1, s2, s1.length(), s2.length()));
//		System.out.println(lpsTabulation(s1,s2,s1.length(),s2.length()));
		System.out.println(lpsSpaceOptimized(s1,s2,s1.length(),s2.length()));
	}

	private static int lpsSpaceOptimized(String s1, String s2, int m, int n) {
		
		int prev[]=new int[m+1];
		int curr[]=new int[n+1];
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					curr[j]=1+prev[j-1];
				}
				else
				{
					curr[j]=Math.max(prev[j],curr[j-1]);
				}
			}
			
			prev=curr.clone();
		}
		return prev[m];
	}

	private static int lpsTabulation(String s1, String s2, int m, int n) {
		
		int dp[][]=new int[m+1][n+1];
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=1+dp[i-1][j-1];
				}
				else
				{
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		
		return dp[m][n];
	}

	private static int lpsMemo(String s1, String s2, int m, int n) {
		
		int dp[][]=new int[m+1][n+1];
		
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		
		return lpsHelper(s1,s2,m,n,dp);
	}

	private static int lpsHelper(String s1, String s2, int m, int n, int[][] dp) {
		
		if(m==0 || n==0) return 0;
		
		if(dp[m][n]!=-1) return dp[m][n];
		
		
		if(s1.charAt(m-1)==s2.charAt(n-1))
			return dp[m][n]=1+lpsHelper(s1, s2, m-1, n-1, dp);
		
		return dp[m][n]=Math.max(lpsHelper(s1, s2, m-1, n, dp), lpsHelper(s1, s2, m, n-1, dp));
	}

	private static int lpsBrute(String s1, String s2, int m, int n) {
		
		if(m==0 || n==0) return 0;
		
		if(s1.charAt(m-1)==s2.charAt(n-1))
		{
			return 1+lpsBrute(s1, s2, m-1, n-1);
		}
		
		return Math.max(lpsBrute(s1, s2, m-1, n),lpsBrute(s1, s2, m, n-1));
	}
}
