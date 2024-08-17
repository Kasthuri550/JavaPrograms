package DynamicProgramming.d2;

import java.util.Arrays;
/*
	 Recursion
		Time Complexity (TC): O(3^n)
		Space Complexity (SC): O(n) (due to recursion stack)
	Memoization
		Time Complexity (TC): O(3*n)
		Space Complexity (SC): O(3*n) (for the memoization table + recursion stack)
	Tabulation
		Time Complexity (TC): O(3*n)
		Space Complexity (SC): O(3*n) (for the DP table)
	Space Optimized
		Time Complexity (TC): O(3*n)
		Space Complexity (SC): O(3) (as it only stores the previous day's results)
 
 */
public class NinjasTraining {

	public static void main(String[] args) {

		int n=3,arr[][]= {{1,2,5},{3,1,1},{3,3,3}};
		
		System.out.println(ninjaTrainingRecursion(n-1,-1,arr));
		System.out.println(ninjaTrainingMemoization(n,-1, arr));
		System.out.println(ninjaTrainingTabulation(n,arr));
		System.out.println(ninjaTrainingSpaceOptimized(n,arr));
	}

	private static int ninjaTrainingSpaceOptimized(int n,int[][] points) {
		
		int prev[]=new int[4];
		int curr[]=new int[4];
		
		prev[0]=Math.max(points[0][1],points[0][2]);
		prev[1]=Math.max(points[0][0],points[0][2]);
		prev[2]=Math.max(points[0][0],points[0][1]);
		prev[3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
		
		for(int day=1;day<n;day++)
		{
			for(int lastActivity=0;lastActivity<4;lastActivity++)
			{
				curr[lastActivity]=0;
				for(int activity=0;activity<3;activity++)
				{
					if(activity!=lastActivity)
					{
						int pointsToday=points[day][activity]+prev[activity];
						curr[lastActivity]=Math.max(curr[lastActivity],pointsToday);
					}
				}
			}
			
			prev=curr.clone();
		}
		
		return prev[3];
	}

	private static int ninjaTrainingTabulation(int n,int[][] points) {
		
		int dp[][]=new int[n][4];
		
		dp[0][0]=Math.max(points[0][1],points[0][2]);
		dp[0][1]=Math.max(points[0][0],points[0][2]);
		dp[0][2]=Math.max(points[0][0],points[0][1]);
		dp[0][3]=Math.max(points[0][2],Math.max(points[0][0],points[0][1]));
		
		for(int day=1;day<n;day++)
		{
			for(int lastActivity=0;lastActivity<4;lastActivity++)
			{
				dp[day][lastActivity]=0;
				for(int activity=0;activity<3;activity++)
				{
					if(activity!=lastActivity)
					{
						int pointsToday=points[day][activity]+dp[day-1][activity];
						dp[day][lastActivity]=Math.max(dp[day][lastActivity],pointsToday);
					}
				}
			}
		}
		
		return dp[n-1][3];
	}

	private static int ninjaTrainingMemoization(int n, int last, int[][] arr) {
		
		int dp[][]=new int[n][4];
		
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		
		
		return ninjaTrainingMemo(n-1,last,arr,dp);
	}

	private static int ninjaTrainingMemo(int day, int lastActivity, int[][] arr, int[][] dp) 
	{
		if(day==0)
		{
			int maxPoints=0;
			
			for(int activity=0;activity<3;activity++)
			{
				maxPoints=Math.max(maxPoints,arr[0][activity]);
			}
			
			return maxPoints;
		}
	
		if(dp[day][lastActivity+1]!=-1) return dp[day][lastActivity+1];
		
		int maxPoints=0;
		
		for(int activity=0;activity<3;activity++)
		{
			if(activity!=lastActivity)
			{
				int pointsToday=arr[day][activity]+ninjaTrainingMemo(day-1, activity, arr, dp);
				maxPoints=Math.max(maxPoints, pointsToday);
			}
		}
		
		return dp[day][lastActivity+1]=maxPoints;
	}

	private static int ninjaTrainingRecursion(int day, int lastActivity, int[][] points) {
		
		if(day==0)
		{
			int maxPoints=0;
			
			for(int activity=0;activity<3;activity++)
			{
				maxPoints=Math.max(maxPoints, points[0][activity]);
			}
			
			return maxPoints;
		}
		
		int maxPoints=0;
				
		for(int activity=0;activity<3;activity++)
		{
			if(activity!=lastActivity)
			{
				int pointsToday=points[day][activity]+ninjaTrainingRecursion(day-1,activity, points);
				maxPoints=Math.max(maxPoints, pointsToday);
			}
		}
		
		return maxPoints;
	}
}
