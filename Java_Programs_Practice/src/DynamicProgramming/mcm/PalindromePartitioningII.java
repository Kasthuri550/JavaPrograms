package DynamicProgramming.mcm;

import java.util.Arrays;

public class PalindromePartitioningII {

	public static void main(String[] args) {
		
		String str = "ababbbabbababa";
		int n=str.length();
		
		System.out.println(palindromePartitioningIIRecursion(0,n,str)-1);
		System.out.println(palindromePartitioningIIMemoization(n, str)-1);
		System.out.println(palindromePartitioningIITabulation(n, str)-1);

	}

	private static int palindromePartitioningIITabulation(int n, String str) {

		int dp[]=new int[n+1];
		
		for(int i=n-1;i>=0;i--)
		{
			int min=Integer.MAX_VALUE;
			
			for(int j=i;j<n;j++)
			{
				if(isPalindrome(i, j, str))
				{
					int cost=1+dp[j+1];
					min=Math.min(min,cost);
				}
			}
			
			dp[i]=min;
		}
		
		return dp[0];
	}

	private static int palindromePartitioningIIMemoization(int n, String str) {

		int dp[]=new int[n];
		
		Arrays.fill(dp,-1);
		
		return palindromePartitioningIIMemo(0,n,str,dp);
	}

	private static int palindromePartitioningIIMemo(int i, int n, String str, int[] dp) {
		
		if(i==n) return 0;
		
		if(dp[i]!=-1) return dp[i];
		
		int min=Integer.MAX_VALUE;
		
		for(int j=i;j<n;j++)
		{
			if(isPalindrome(i, j, str))
			{
				int cost=1+palindromePartitioningIIMemo(j+1, n, str, dp);
				min=Math.min(min,cost);
			}
		}
		
		return dp[i]=min;
	}

	private static int palindromePartitioningIIRecursion(int i, int n, String str) {
		
		if(i==n) return 0;
		
		int minCost=Integer.MAX_VALUE;
		
		for(int j=i;j<n;j++)
		{
			if(isPalindrome(i,j,str))
			{
				int cost=1+palindromePartitioningIIRecursion(j+1, n, str);
				minCost=Math.min(minCost, cost);
			}
		}
		
		return minCost;
		
	}

	private static boolean isPalindrome(int i, int j, String str) {

		while(i<j)
		{
			if(str.charAt(i)!=str.charAt(j)) return false;
			i++;
			j--;
		}
		
		return true;
	}
}
