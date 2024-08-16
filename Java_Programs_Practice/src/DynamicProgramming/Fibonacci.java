package DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {

	public static void main(String[] args) {
		
		int n=5;
		int dp[]=new int[n+1];
		
//		Arrays.fill(dp,-1);
		
//		System.out.println(fibonacciRecursion(n));
		
//		System.out.println(fibonacciMemoization(n,dp));
		
		System.out.println(fibonacciTabulation(n, dp));
		
		System.out.println(fibonacciSpaceOptimized(n));

	}

	private static int fibonacciSpaceOptimized(int n) {
		
		int prev1=1,prev2=0;
		
		for(int i=2;i<=n;i++)
		{
			int curr=prev1+prev2;
			prev2=prev1;
			prev1=curr;
		}
		return prev1;
	}

	private static int fibonacciTabulation(int n, int[] dp) {
		
		dp[0]=0;
		dp[1]=1;
		
		for(int i=2;i<=n;i++)
		{
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		return dp[n];
	}

	private static int fibonacciMemoization(int n,int dp[]) {
		
		if(n<=1) return n;
		
		if(dp[n]!=-1) return dp[n];
		
		return dp[n]=fibonacciMemoization(n-1, dp)+fibonacciMemoization(n-2,dp);
	}

	private static long fibonacciRecursion(int n) {
		
		if(n<=1)
			return n;
		
		return fibonacciRecursion(n-1)+fibonacciRecursion(n-2);		
	}
}
