package DynamicProgramming.mcm;

import java.util.Arrays;

public class BurstBalloons {

	public static void main(String[] args) {
		
		int N = 4,arr[] = {3, 1, 5, 8};
		
		int newArr[]=new int[N+2];
		
		newArr[0]=1;
		newArr[N+1]=1;
		
		for(int i=0;i<N;i++)
		{
			newArr[i+1]=arr[i];
		}
		
//		System.out.println(burstBalloonsRecursion(1,N,newArr));
//		System.out.println(burstBalloonsMemoization(N,newArr));
		System.out.println(burstBalloonsTabulation(N, newArr));
		
	}

	private static int burstBalloonsTabulation(int n, int[] arr) {
		
		int dp[][]=new int[n+2][n+2];
		
		for(int i=n;i>=1;i--)
		{
			for(int j=1;j<=n;j++)
			{
				if(i>j) continue;
				
				int max=Integer.MIN_VALUE;
				
				for(int ind=i;ind<=j;ind++)
				{
					int cost=arr[i-1]*arr[ind]*arr[j+1]+dp[i][ind-1]+dp[ind+1][j];
					max=Math.max(max, cost);
				}
				
				dp[i][j]=max;
			}
		}
		
		return dp[1][n];
	}

	private static int burstBalloonsMemoization(int n, int[] newArr) {
		
		int dp[][]=new int[n+2][n+2];
		
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		
		return burstBalloonsMemo(1,n,newArr,dp);
	}

	private static int burstBalloonsMemo(int i, int j, int[] arr, int[][] dp) {
		
		if(i>j) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		int max=Integer.MIN_VALUE;
		
		for(int ind=i;ind<=j;ind++)
		{
			int cost=arr[i-1]*arr[ind]*arr[j+1]+burstBalloonsMemo(i, ind-1, arr, dp)
			+burstBalloonsMemo(ind+1, j, arr, dp);
			
			max=Math.max(max,cost);
		}
		
		return dp[i][j]=max;
	}

	private static int burstBalloonsRecursion(int i, int j, int[] arr) {
		
		if(i>j) return 0;
		
		int max=Integer.MIN_VALUE;
		
		for(int ind=i;ind<=j;ind++)
		{
			int cost=arr[i-1]*arr[ind]*arr[j+1]+burstBalloonsRecursion(i,ind-1, arr)
			+burstBalloonsRecursion(ind+1, j, arr);
			
			max=Math.max(max,cost);
		}

		return max;
	}
}
