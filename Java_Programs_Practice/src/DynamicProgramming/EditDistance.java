package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {

		String s1="horse",s2="ros";

//		System.out.println(editDistanceRecurrsion(s1.length()-1,s2.length()-1,s1,s2));
//		System.out.println(editDistanceMemo(s1.length()-1,s2.length()-1, s1, s2));
//		System.out.println(editDistanceTabulation(s1.length(), s2.length(), s1, s2));
		System.out.println(editDistanceSpaceOptimized(s1.length()-1, s2.length()-1, s1, s2));
	}

	private static int editDistanceSpaceOptimized(int m, int n, String s1, String s2) {
		
		int prev[]=new int[m+1];
		int cur[]=new int[n+1];
		
		for(int j=0;j<=m;j++)
		{
			prev[j]=j;
		}
		
		for(int i=1;i<=m;i++)
		{
			cur[0]=i;
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					cur[j]=prev[j-1];
				}
				else
				{
					cur[j]=1+Math.min(prev[j],Math.min(cur[j-1],prev[j-1]));
				}
			}
			
			prev=cur.clone();
		}
		
		return prev[n];
	}

	private static int editDistanceTabulation(int m, int n, String s1, String s2) {
		
		int dp[][]=new int[m+1][n+1];
		
		for(int i=0;i<=m;i++)
		{
			dp[i][0]=i;
		}
		
		for(int j=0;j<=n;j++)
		{
			dp[0][j]=j;
		}
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=dp[i-1][j-1];
				}
				else
				{
					dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1]));
				}
			}
		}
		
		return dp[m][n];
	}

	private static int editDistanceMemo(int i, int j, String s1, String s2) {
		
		int dp[][]=new int[i+1][j+1];
		
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		
		return edm(i, j, s1, s2,dp);
	}

	private static int edm(int i, int j, String s1, String s2,int dp[][]) {
		
		if(i<0) return j+1;
		
		if(j<0) return i+1;

		if(dp[i][j]!=-1) return dp[i][j];
		
		if(s1.charAt(i)==s2.charAt(j)) 
		{
			dp[i][j]=editDistanceMemo(i-1, j-1, s1, s2);	
		}
		else
		{
			dp[i][j]=1+Math.min(editDistanceMemo(i-1, j, s1, s2),
				Math.min(editDistanceMemo(i, j-1, s1, s2),editDistanceMemo(i-1, j-1, s1, s2)));
		}
		
		return dp[i][j];
	}

	private static int editDistanceRecurrsion(int i, int j, String s1, String s2) {

		if(i<0) return j+1;

		if(j<0) return i+1;

		if(s1.charAt(i)==s2.charAt(j))
			return editDistanceRecurrsion(i-1, j-1, s1, s2);

		return 1+Math.min(editDistanceRecurrsion(i, j-1, s1, s2),
				Math.min(editDistanceRecurrsion(i-1, j, s1, s2),editDistanceRecurrsion(i-1, j-1, s1, s2)));		
	}
}
