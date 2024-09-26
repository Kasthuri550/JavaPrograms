package DynamicProgramming.strings;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		
		String s1 = "acd";
        String s2 = "ced";
        
        System.out.println(lcsBrute(s1.length()-1,s2.length()-1,s1,s2));
        System.out.println(lcsMemoization(s1.length(),s2.length(), s1, s2));
        System.out.println(lcsTabulation(s1.length(),s2.length(),s1,s2));
        System.out.println(lcsSpaceOptimized(s1.length(),s2.length(),s1,s2));
		
	}

	private static int lcsSpaceOptimized(int m, int n, String s1, String s2) {
		
		int prev[]=new int[n+1];
		int curr[]=new int[n+1];
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
					curr[j]=1+prev[j-1];
				else
					curr[j]=Math.max(prev[j],curr[j-1]);
			}
			
			prev=curr;
		}
		return prev[n];
	}

	private static int lcsTabulation(int m, int n, String s1, String s2) {
		
		int dp[][]=new int[m+1][n+1];
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		
		return dp[m][n];
	}

	private static int lcsMemoization(int m, int n, String s1, String s2) {
		
		
		int dp[][]=new int[m][n];
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		
		return lcsMemoHelper(m-1,n-1,s1,s2,dp);
	}

	private static int lcsMemoHelper(int m, int n, String s1, String s2, int[][] dp) {
		
		if(m<0 || n<0) return 0;
		
		if(dp[m][n]!=-1) return dp[m][n];
		
		if(s1.charAt(m)==s2.charAt(n))
			return dp[m][n]=1+lcsMemoHelper(m-1, n-1, s1, s2, dp);
		
		return dp[m][n]=Math.max(lcsMemoHelper(m-1, n, s1, s2, dp),lcsMemoHelper(m, n-1, s1, s2, dp));
	}

	private static int lcsBrute(int m, int n, String s1, String s2) {
		
		if(m<0 || n<0) return 0;
		
		if(s1.charAt(m)==s2.charAt(n))
			return 1+lcsBrute(m-1, n-1, s1, s2);
		
		return Math.max(lcsBrute(m-1, n, s1, s2),lcsBrute(m, n-1, s1, s2));
	}
}
