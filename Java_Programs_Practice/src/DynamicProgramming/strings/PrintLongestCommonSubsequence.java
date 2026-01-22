package DynamicProgramming.strings;

public class PrintLongestCommonSubsequence {

	public static void main(String[] args) {

		String s1 = "acd";
		String s2 = "ced";

		printLcs(s1,s2,s1.length(),s2.length());
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 * */	
	private static void printLcs(String s1, String s2, int m, int n) {

		int dp[][]=new int[m+1][n+1];

		for(int i=1;i<m;i++)
		{
			for(int j=1;j<n;j++)
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

		int i=m,j=n;

		StringBuilder sb=new StringBuilder();

		while(i>0 && j>0)
		{
			if(s1.charAt(i-1)==s2.charAt(j-1))
			{
				sb.insert(0,s1.charAt(i-1));
				i--;
				j--;
			}
			else if(s1.charAt(i-1)>s2.charAt(j-1))
			{
				i--;
			}
			else
			{
				j--;
			}
		}

		System.out.println(sb.toString());
	}
}
