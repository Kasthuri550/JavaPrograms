package DynamicProgramming.d1;

import java.util.Arrays;

public class ClimbingStars {

	public static void main(String[] args) {
		
		int n = 4;
		
//		System.out.println(climbingStairsRecursion(n));
//		System.out.println(climbingStairsMemoization(n));
//		System.out.println(climbingStairsTabulation(n));
		System.out.println(climbingStairsSpaceOptimized(n));

	}

	private static int climbingStairsSpaceOptimized(int n) {
		
		int prev1=1,prev2=1;
		
		for(int i=2;i<=n;i++)
		{
			int curr=prev1+prev2;
			prev1=prev2;
			prev2=curr;
		}
		
		return prev2;
	}

	private static int climbingStairsTabulation(int n) {
		
		int dp[]=new int[n+1];
				
		dp[0]=1;
		dp[1]=1;
		
		for(int i=2;i<=n;i++)
		{
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		return dp[n];
	}

	private static int climbingStairsMemoization(int n) {
		
		int dp[]=new int[n+1];
		
		Arrays.fill(dp, -1);
		
		return climbingStairsMemo(n,dp);
	}

	private static int climbingStairsMemo(int n, int[] dp) {
		
		if(n<=1) return 1;
		
		if(dp[n]!=-1) return dp[n];
		
		int climb1=climbingStairsMemo(n-1, dp);
		int climb2=climbingStairsMemo(n-2, dp);
		
		return dp[n]=climb1+climb2;
	}

	private static int climbingStairsRecursion(int n) {
		
		if(n<=1) return 1;
		
		int climb1=climbingStairsRecursion(n-1);
		int climb2=climbingStairsRecursion(n-2);
		
		return climb1+climb2;
		
	}

}
