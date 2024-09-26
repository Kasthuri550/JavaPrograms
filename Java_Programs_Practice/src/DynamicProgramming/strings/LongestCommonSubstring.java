package DynamicProgramming.strings;

import java.util.Arrays;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		
		String s1 = "abcjklp";
        String s2 = "acjkp";
        
        System.out.println(lcsBrute(s1,s2,s1.length(),s2.length()));
//        System.out.println(lcsMemo(s1,s2,s1.length(),s2.length()));
//        System.out.println(lcsTabulation(s1,s2,s1.length(),s2.length()));
        System.out.println(lcsSpaceOptimized(s1,s2,s1.length(),s2.length()));
	}

	private static int lcsSpaceOptimized(String s1, String s2, int m, int n) {
		
		int prev[]=new int[m+1];
		int curr[]=new int[n+1];
		int max=0;
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					curr[j]=1+prev[j-1];
					max=Math.max(max, curr[j]);
				}
				else
				{
					curr[j]=0;
				}
			}
			
			prev=curr.clone();
		}
		return max;
	}

	private static int lcsTabulation(String s1, String s2, int m, int n) {
		
		int dp[][]=new int[m+1][n+1],result=0;
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=1+dp[i-1][j-1];
					result=Math.max(result, dp[i][j]);
				}
				else
				{
					dp[i][j]=0;
				}
			}
		}
		
		return result;
	}

	private static int lcsBrute(String s1, String s2, int m, int n) {
		
		if(m==0 || n==0) return 0;
		
		int longestSubstring=0;		
		
		if(s1.charAt(m-1)==s2.charAt(n-1))
			longestSubstring=Math.max(longestSubstring,1+lcsBrute(s1, s2, m-1, n-1));
			
		return longestSubstring;
	}
}
