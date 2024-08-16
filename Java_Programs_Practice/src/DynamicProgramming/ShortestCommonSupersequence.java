package DynamicProgramming;

public class ShortestCommonSupersequence {

	public static void main(String[] args) {

		String X = "abcd", Y = "xycd";
		
		System.out.println(X.length()+Y.length()-scs(X,Y,X.length(),Y.length()));
	}

	private static int scs(String x, String y, int m, int n) {
		
		int dp[][]=new int[m+1][n+1];
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(x.charAt(i-1)==y.charAt(j-1))
				{
					dp[i][j]=1+dp[i-1][j-1];
				}
				else
				{
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		
		printScs(x,y,dp);
		return dp[n][m];
	}

	private static void printScs(String x, String y, int[][] dp) {
		
		int m=x.length(),n=y.length(),i=m,j=n;
		
		StringBuilder sb=new StringBuilder();
		
		while(i>0 && j>0)
		{
			if(x.charAt(i-1)==y.charAt(j-1))
			{
				sb.append(x.charAt(i-1));
				i--;
				j--;
			}
			else if(dp[i-1][j]>dp[i][j-1])
			{
				sb.append(x.charAt(i-1));
				i--;
			}
			else
			{
				sb.append(y.charAt(j-1));
				j--;
			}
		}
		
		while(i>0)
		{
			sb.append(x.charAt(i-1));
			i--;
		}
		
		while(j>0)
		{
			sb.append(y.charAt(j-1));
			j--;
		}
		
		sb=sb.reverse();
		
		System.out.println(sb.toString());
	}
}
