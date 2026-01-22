package DynamicProgramming.mcm;

import java.util.Arrays;

public class MinimumCostToCutAStick {

	public static void main(String[] args) {

		int  n = 7, cuts[] = {1,3,4,5},c=cuts.length;

		int newCuts[]=new int[c+2];

		newCuts[0]=0;
		newCuts[c+1]=n;

		for(int it=0;it<c;it++)
		{
			newCuts[it+1]=cuts[it];
		}

		Arrays.sort(newCuts);

		System.out.println(minimumCostToCutAStickRecursion(1,c,newCuts));
		System.out.println(minimumCostToCutAStickMemoization(c, newCuts));
		System.out.println(minimumCostToCutAStickTabulation(c, newCuts));

	}
	/*
	 * Time Complexity: O(c^3)
	 * Space Complexity: O(c^2)
	 * */
	private static int minimumCostToCutAStickTabulation(int n, int[] cuts) {

		int dp[][]=new int[n+2][n+2];

		for(int i=n;i>=1;i--)
		{
			for(int j=i;j<=n;j++)
			{
				if(i>j) continue;

				int min=Integer.MAX_VALUE;
				for(int k=i;k<=j;k++)
				{
					int cost=cuts[j+1]-cuts[i-1]+dp[i][k-1]+dp[k+1][j];
					min=Math.min(min,cost);
				}
				dp[i][j]=min;
			}
		}

		return dp[1][n];
	}

	private static int minimumCostToCutAStickMemoization(int c, int[] newCuts) {

		int dp[][]=new int[c+1][c+1];

		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}

		return minimumCostToCutAStickMemo(1,c,newCuts,dp);
	}

	/*
	 * Time Complexity: O(c^3)
	 * Space Complexity: O(c^2)+O(c) ~ O(c^2)
	 * */
	private static int minimumCostToCutAStickMemo(int i, int j, int[] cuts,int dp[][]) {

		if(i>j) return 0;

		if(dp[i][j]!=-1) return dp[i][j];

		int min=Integer.MAX_VALUE;

		for(int ind=i;ind<=j;ind++)
		{
			int cost=cuts[j+1]-cuts[i-1]+minimumCostToCutAStickMemo(i,ind-1,cuts,dp)+minimumCostToCutAStickMemo(ind+1,j,cuts,dp);
			min=Math.min(min,cost);
		}

		return dp[i][j]=min;
	}
	/*
	 * Time Complexity: O(2^c)
	 * Space Complexity: O(c)
	 * */
	private static int minimumCostToCutAStickRecursion(int i, int j,int[] cuts) {

		if(i>j) return 0;

		int min=Integer.MAX_VALUE;

		for(int ind=i;ind<=j;ind++)
		{
			int cost=cuts[j+1]-cuts[i-1]+minimumCostToCutAStickRecursion(i,ind-1,cuts)+minimumCostToCutAStickRecursion(ind+1, j,cuts);
			min=Math.min(min,cost);
		}

		return min;
	}
}
