package Stringprograms.medium;

public class PrintLongestCommonSubsequence {

	public static void main(String[] args) {

		String s1= "abcde";
		String s2= "bdgek";

		System.out.println(lcs(s1,s2,s1.length(),s2.length()));

	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 * */
	private static String lcs(String s1, String s2, int n, int m) {

		int dp[][]=new int[n+1][m+1];

		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else
				{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		int i=n,j=m;

		StringBuilder sb=new StringBuilder();

		while(i>0 && j>0)
		{
			if(s1.charAt(i-1)==s2.charAt(j-1))
			{
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			}
			else if(dp[i-1][j]>dp[i][j-1])
			{
				i--;
			}
			else
			{
				j--;
			}
		}

		return sb.reverse().toString();
	}
}
