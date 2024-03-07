package Stringprograms;

import java.util.Arrays;

public class LongestCommonSubsequences {

	public static void main(String[] args) {
		
		 String s = "AGGTAB";
	     String t = "GXTXAYB";
	     
	     System.out.println(fillArrays(s,t));
	}

	private static int fillArrays(String s, String t) {
		
		int n=s.length();
		int m=t.length();
		
		int dp[][]=new int[n][m];
		
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		
		
		return lcs(n-1,m-1,s,t,dp);
	}

	private static int lcs(int i, int j, String s, String t, int[][] dp) {
		
		
		if(i<0||j<0)
		{
			return 0;
		}
		
		if(dp[i][j]!=-1)
		{
			return dp[i][j];
		}
		
		if(s.charAt(i)==t.charAt(j))
		{
			return dp[i][j]=1+lcs(i-1,j-1,s,t,dp);
		}
		
		return Math.max(lcs(i-1,j,s,t,dp), lcs(i,j-1,s,t,dp));
		
	}

}
