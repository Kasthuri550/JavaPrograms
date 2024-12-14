package DynamicProgramming.strings;

import java.util.Arrays;

public class WildcardPatternMatching {

	public static void main(String[] args) {

		String pattern = "ba*a?", str = "baaabab";

		int m=pattern.length(),n=str.length();

		//		System.out.println(wildCardPatternMatchingBrute(m-1,n-1,pattern,str));
		//		System.out.println(wildCardPatternMatchingMemo(m, n, pattern, str));
		System.out.println(wildCardPatternMatchingTabulataion(m, n, pattern, str));
		System.out.println(wildCardPatternMatchingSpaceOptimized(m, n, pattern, str));

	}

	private static int wildCardPatternMatchingSpaceOptimized(int m, int n, String pattern, String str) {

		int prev[]=new int[n+1];
		int curr[]=new int[n+1];
		
		prev[0]=1;

		for (int j = 1; j <= n; j++) {
			prev[j] = 0;
		}
		for(int i=1;i<=m;i++)
		{
			curr[0]=isAllStars(pattern,i);
		}
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(pattern.charAt(i-1)==str.charAt(j-1) || pattern.charAt(i-1)=='?') 
				{
					curr[j]=prev[j-1];
				}
				else 
				{
					if(pattern.charAt(i-1)=='*')
					{
						curr[j]= prev[j]|curr[j-1];
					}
					else
					{
						curr[j]=0;
					}
				}
			}
			
			prev=curr.clone();
		}

		return prev[n];
	}

	private static int wildCardPatternMatchingTabulataion(int m, int n, String pattern, String str) {

		int dp[][]=new int[m+1][n+1];

		dp[0][0]=1;

		for (int j = 1; j <= n; j++) {
			dp[0][j] = 0;
		}
		for(int i=1;i<=m;i++)
		{
			dp[i][0]=isAllStars(pattern,i);
		}

		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(pattern.charAt(i-1)==str.charAt(j-1) || pattern.charAt(i-1)=='?') 
				{
					dp[i][j]=dp[i-1][j-1];
				}
				else 
				{
					if(pattern.charAt(i-1)=='*')
					{
						dp[i][j]= dp[i-1][j]|dp[i][j-1];
					}
					else
					{
						dp[i][j]=0;
					}
				}
			}
		}

		return dp[m][n];
	}

	private static int isAllStars(String pattern, int i) {

		for(int j=1;j<=i;j++)
		{
			if(pattern.charAt(j-1)!='*') return 0;
		}
		return 1;
	}

	private static int wildCardPatternMatchingMemo(int m, int n, String pattern, String str) {

		int dp[][]=new int[m][n];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return wildCardPatternMatchingMemoization(m-1,n-1,pattern,str,dp);
	}

	private static int wildCardPatternMatchingMemoization(int m, int n, String pattern, String str,int dp[][]) {

		if(m<0 && n<0) return 1;

		if(m<0 && n>=0) return 0;

		if(m>=0 && n<0) 
		{
			for(int i=0;i<=m;i++)
			{
				if(pattern.charAt(i)!='*') return 0;
			}

			return 1;
		}

		if(dp[m][n]!=-1) return dp[m][n];

		if(pattern.charAt(m)==str.charAt(n) || pattern.charAt(m)=='?') 
			return dp[m][n]=wildCardPatternMatchingMemoization(m-1,n-1, pattern, str, dp);

		if(pattern.charAt(m)=='*')
			return dp[m][n]= wildCardPatternMatchingMemoization(m-1, n, pattern, str, dp)| 
			wildCardPatternMatchingMemoization(m, n-1, pattern, str, dp);

		return dp[m][n]=0;
	}

	private static int wildCardPatternMatchingBrute(int m, int n, String pattern, String str) {

		if(m<0 && n<0) return 1;

		if(m<0 && n>=0) return 0;

		if(m>=0 && n<0)
		{
			for(int i=0;i<=m;i++)
			{
				if(pattern.charAt(i)!='*') return 0;

			}

			return 1;
		}


		if(pattern.charAt(m)==str.charAt(n) || pattern.charAt(m)=='?')
			return wildCardPatternMatchingBrute(m-1, n-1, pattern, str);

		if(pattern.charAt(m)=='*')
			return wildCardPatternMatchingBrute(m-1, n, pattern, str)|
					wildCardPatternMatchingBrute(m, n-1, pattern, str);

		return 0;
	}
}
