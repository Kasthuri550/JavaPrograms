package DynamicProgramming.d1;

import java.util.Arrays;

public class FrogJumpWithKDistance {

	public static void main(String[] args) {
		
		int k = 3, arr[]= {10, 30, 40, 50, 20};
		
//		System.out.println(frogJumpWithKDistanceRecursion(arr.length-1,arr,k));
		System.out.println(frogJumpWithKDistanceMemoization(arr.length-1, arr, k));
		System.out.println(frogJumpWithKDistanceTabulation(arr.length, arr, k));

	}

	private static int frogJumpWithKDistanceTabulation(int index, int[] arr, int k) {
		
		int dp[]=new int[index];
		
		dp[0]=0;
		
		for(int i=1;i<index;i++)
		{
			int minSteps=Integer.MAX_VALUE;
			
			for(int j=1;j<=k;j++)
			{
				if(i-j>=0)
				{
					int jump=dp[i-j]+Math.abs(arr[i]-arr[i-j]);
					minSteps=Math.min(minSteps, jump);
				}
			}
			
			dp[i]=minSteps;
		}
		
		return dp[index-1];
	}

	private static int frogJumpWithKDistanceMemoization(int index, int[] arr, int k) {
		
		int dp[]=new int[arr.length+1];
		
		Arrays.fill(dp, -1);
		
		return frogJumpWithKDistanceMemo(index,arr,k,dp);
	}

	private static int frogJumpWithKDistanceMemo(int index, int[] arr, int k, int[] dp) {
		
		if(index==0) return 0;
		
		if(dp[index]!=-1) return dp[index];
		
		int minSteps=Integer.MAX_VALUE;
		
		for(int j=1;j<=k;j++)
		{
			if(index-j>=0)
			{
				int jump=frogJumpWithKDistanceMemo(index-j, arr, k, dp)+Math.abs(arr[index]-arr[index-j]);
				minSteps=Math.min(minSteps, jump);
			}
		}
		
		return dp[index]=minSteps;
	}

	private static int frogJumpWithKDistanceRecursion(int index, int[] arr, int k) {
		
		if(index==0) return 0;
		
		int minSteps=Integer.MAX_VALUE;
		
		for(int j=1;j<=k;j++)
		{
			if(index-j>=0)
			{
				int jump=frogJumpWithKDistanceRecursion(index-j, arr, k)+Math.abs(arr[index]-arr[index-j]);
				minSteps=Math.min(minSteps, jump);
			}
		}
		
		return minSteps;
	}
}
