package Arrayprograms.medium;

public class MinimumDeletionsToMakePalindrome {

	public static void main(String[] args) {

		String S = "aebcbda";

		System.out.println(minimumNumberOfDeletions(S));
	}

	private static int minimumNumberOfDeletions(String s) {
		
		int n=s.length();
		
		int dp[][]=new int[n][n];
		
		for(int l=2;l<=n;l++)
		{
			for(int i=0;i<n-l+1;i++)
			{
				int j=i+l-1;
				
				if(s.charAt(i)==s.charAt(j))
				{
					dp[i][j]=dp[i+1][j-1];
				}
				else
				{
					dp[i][j]=Math.min(dp[i][j-1], dp[i+1][j])+1;
				}
			}
		}
		
		return dp[0][n-1];
	}
}
