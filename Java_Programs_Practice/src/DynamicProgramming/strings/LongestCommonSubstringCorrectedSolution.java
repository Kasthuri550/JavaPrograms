package DynamicProgramming.strings;

import java.util.Arrays;

public class LongestCommonSubstringCorrectedSolution {

	public static void main(String[] args) {

		String s1 = "abcjklp";
        String s2 = "acjkp";
        
       System.out.println(longestCommonSubstringTabulation(s1.length(),s2.length(),s1,s2));
       System.out.println(longestCommonSubstringSpaceOptimized(s1.length(),s2.length(), s1, s2));
	}

	private static int longestCommonSubstringSpaceOptimized(int m, int n, String s1, String s2) {

		int prev[]=new int[n+1];
		int curr[]=new int[n+1];
		int result=Integer.MIN_VALUE;
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					curr[j]=1+prev[j-1];
					result=Math.max(result,curr[j]);
				}
				else
					curr[j]=0;
			}
			
			prev=curr.clone();
		}
		
		return result;
	}

	private static int longestCommonSubstringTabulation(int m, int n, String s1, String s2) {
		
		int dp[][]=new int[m+1][n+1],result=Integer.MIN_VALUE;
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=1+dp[i-1][j-1];
					result=Math.max(result,dp[i][j]);
				}
				else
					dp[i][j]=0;
			}
		}
		
//		System.out.println(Arrays.deepToString(dp));
		
		return result;
	}
}
