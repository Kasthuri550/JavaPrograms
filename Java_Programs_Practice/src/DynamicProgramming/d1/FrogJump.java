package DynamicProgramming.d1;

import java.util.Arrays;

public class FrogJump {

	public static void main(String[] args) {

		int n = 4,height[] = {10,20,30,10};
		
//		System.out.println(frogJumpRecursion(n-1,height));
//		System.out.println(frogJumpMemoization(n-1, height));
		System.out.println(frogJumpTabulation(n, height));
		System.out.println(frogJumpSpaceOptimized(n, height));
	}

	private static int frogJumpSpaceOptimized(int n, int[] height) {
		
		int prev1=0,prev2=0;
		
		for(int i=1;i<n;i++)
		{
			int climb1=prev1+Math.abs(height[i]-height[i-1]);
			int climb2=Integer.MAX_VALUE;
			
			if(i>1)
				climb2=prev2+Math.abs(height[i]-height[i-2]);
			
			int curr=Math.min(climb1, climb2);
			prev2=prev1;
			prev1=curr;
		}
		
		return prev1;
	}

	private static int frogJumpTabulation(int index, int[] height) {
		
		int n=index,dp[]=new int[n+1];
		
		dp[0]=0;
		
		for(int i=1;i<n;i++)
		{
			int climb1=dp[i-1]+Math.abs(height[i]-height[i-1]);
			int climb2=Integer.MAX_VALUE;
			if(i>1)
				climb2=dp[i-2]+Math.abs(height[i]-height[i-2]);
			
			dp[i]=Math.min(climb1, climb2);
		}
		
		return dp[n-1];
	}

	private static int frogJumpMemoization(int index, int[] height) {
		
		int dp[]=new int[index+1];
		
		Arrays.fill(dp,-1);
		
		return frogJumpMemo(index,height,dp);
	}

	private static int frogJumpMemo(int index, int[] height, int[] dp) {
		
		if(index==0) return 0;
		
		if(dp[index]!=-1) return dp[index];
				
		int climb1=frogJumpMemo(index-1, height, dp)+Math.abs(height[index]-height[index-1]);
		int climb2=Integer.MAX_VALUE;
		if(index>1)
			climb2=frogJumpMemo(index-2, height, dp)+Math.abs(height[index]-height[index-2]);
		
		return dp[index]=Math.min(climb1, climb2);
	}

	private static int frogJumpRecursion(int index, int[] height) {
		
		if(index==0) return 0;
		
		int climb1=frogJumpRecursion(index-1,height)+Math.abs(height[index]-height[index-1]);
		int climb2=Integer.MAX_VALUE;
		if(index>1)
			climb2=frogJumpRecursion(index-2,height)+Math.abs(height[index]-height[index-2]);
		
		return Math.min(climb1, climb2);
	}
}
