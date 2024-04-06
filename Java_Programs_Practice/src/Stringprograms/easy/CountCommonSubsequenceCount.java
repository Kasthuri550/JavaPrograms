package Stringprograms.easy;

public class CountCommonSubsequenceCount {

	public static void main(String[] args) {
		
		String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        
        System.out.println(countCommonSubsequence(str1,str2));
		
	}

	private static int countCommonSubsequence(String str1, String str2) {
		
		int m=str1.length();
		int n=str2.length();
		
		int dp[][]=new int[m+1][n+1];
		
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0 || j==0)
				{
					dp[i][j]=0;
				}
				else if(str1.charAt(i-1)==str2.charAt(j-1))
				{
					dp[i][j]=1+dp[i-1][j-1];
				}
				else
				{
					dp[i][j]=dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1];
				}
			}
		}
		
		return dp[m][n];
	}
}
