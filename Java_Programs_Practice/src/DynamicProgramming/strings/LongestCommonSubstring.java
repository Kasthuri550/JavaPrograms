package DynamicProgramming.strings;

import java.util.Arrays;

public class LongestCommonSubstring {

	public static void main(String[] args) {

		String s1 = "abcjklp";
		String s2 = "acjkp";

		System.out.println(lcsBrute(s1,s2,s1.length()-1,s2.length()-1,0));
		System.out.println(lcsMemo(s1,s2,s1.length(),s2.length()));
		System.out.println(lcsTabulation(s1,s2,s1.length(),s2.length()));
		System.out.println(lcsSpaceOptimized(s1,s2,s1.length(),s2.length()));
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m+n)
	 * */
	private static int lcsMemo(String s1, String s2, int m, int n) {

		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		int max = 0;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				max = Math.max(max, lcsMemo(s1, s2, i, j, dp));
			}
		}

		return max;
	}

	private static int lcsMemo(String s1, String s2, int i, int j, int[][] dp) {

		if (i < 0 || j < 0)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		if (s1.charAt(i) == s2.charAt(j)) {
			dp[i][j] = 1 + lcsMemo(s1, s2, i - 1, j - 1, dp);
		} else {
			dp[i][j] = 0;   
		}

		return dp[i][j];
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(n)
	 * */
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

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m+n)
	 * */
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

	/*
	 * Time Complexity: O(2^(m+n))
	 * Space Complexity: O(m+n)
	 * */
	private static int lcsBrute(String s1, String s2, int m, int n,int count) {

		if(m<0 || n<0) return 0;

		int match=count;		

		if(s1.charAt(m)==s2.charAt(n))
			match=lcsBrute(s1, s2, m-1, n-1,count+1);

		int skipS1=lcsBrute(s1, s2, m-1, n, 0);
		int skipS2=lcsBrute(s1, s2, m, n-1, 0);

		return Math.max(match,Math.max(skipS1, skipS2));
	}
}
