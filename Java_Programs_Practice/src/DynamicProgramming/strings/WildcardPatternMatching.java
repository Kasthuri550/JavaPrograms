package DynamicProgramming.strings;

public class WildcardPatternMatching {

	public static void main(String[] args) {

		String pattern = "ba*a?", str = "baaabab";

		int m=pattern.length(),n=str.length();

		System.out.println(wildCardPatternMatchingBrute(m-1,n-1,pattern,str));
		System.out.println(wildCardPatternMatchingMemo(m, n, pattern, str));
		System.out.println(wildCardPatternMatchingTabulataion(m, n, pattern, str));
		System.out.println(wildCardPatternMatchingSpaceOptimized(m, n, pattern, str));
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(n)
	 * */
	private static boolean wildCardPatternMatchingSpaceOptimized(int m, int n, String p, String s) {

		Boolean prev[] = new Boolean[n + 1];
		Boolean curr[] = new Boolean[n + 1];

		prev[0] = true;
		curr[0]=true;

		for (int j = 1; j <= n; j++) {
			prev[j] = false;
		}

		for (int i = 1; i <= m; i++) {
			curr[0] = isAllStars(p, i);
			for (int j = 1; j <= n; j++) {
				if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
					curr[j] = prev[j - 1];
				} else {
					if (p.charAt(i - 1) == '*') {
						curr[j] = curr[j - 1] || prev[j];
					} else {
						curr[j] = false;
					}
				}
			}

			prev=curr.clone();
		}

		return prev[n];
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 * */
	private static boolean wildCardPatternMatchingTabulataion(int m, int n, String p, String s) {

		Boolean dp[][] = new Boolean[m + 1][n + 1];

		dp[0][0] = true;

		for (int j = 1; j <= n; j++) {
			dp[0][j] = false;
		}

		for (int i = 1; i <= m; i++) {
			dp[i][0] = isAllStars(p, i);
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(i - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[m][n];
	}

	private static boolean isAllStars(String p, int n) {
		for (int i = 0; i <n; i++) {
			if (p.charAt(i) != '*')
				return false;
		}

		return true;
	}

	/*
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)
	 * */
	private static boolean wildCardPatternMatchingMemo(int m, int n, String p, String s) {

		Boolean dp[][]=new Boolean[m+1][n+1];

		return wildCardMatching(p,s,m-1,n-1,dp);
	}

	private static boolean wildCardMatching(String p,String s,int m,int n,Boolean[][] dp)
	{
		if(m<0 && n<0)
			return true;

		if(m<0 && n>=0)
			return false;

		if(m>=0 && n<0)
		{
			for(int k=0;k<=m;k++)
			{
				if(p.charAt(k)!='*')
					return false;
			}

			return true;
		}

		if(dp[m][n]!=null)
			return dp[m][n];

		if(p.charAt(m)==s.charAt(n) || p.charAt(m)=='?')
			return dp[m][n]=wildCardMatching(p,s,m-1,n-1,dp);

		if(p.charAt(m)=='*')
			return dp[m][n]=wildCardMatching(p,s,m,n-1,dp) || wildCardMatching(p,s,m-1,n,dp);

		return dp[m][n]=false;
	}

	/*
	 * Time Complexity: O(2^(m+n))
	 * Space Complexity: O(m+n)
	 * */	
	private static boolean wildCardPatternMatchingBrute(int m, int n, String pattern, String str) {

		if(m<0 && n<0) return true;

		if(m<0 && n>=0) return false;

		if(m>=0 && n<0)
		{
			for(int i=0;i<=m;i++)
			{
				if(pattern.charAt(i)!='*') return false;

			}

			return true;
		}

		if(pattern.charAt(m)==str.charAt(n) || pattern.charAt(m)=='?')
			return wildCardPatternMatchingBrute(m-1, n-1, pattern, str);

		if(pattern.charAt(m)=='*')
			return wildCardPatternMatchingBrute(m-1, n, pattern, str)||
					wildCardPatternMatchingBrute(m, n-1, pattern, str);

		return false;
	}
}
