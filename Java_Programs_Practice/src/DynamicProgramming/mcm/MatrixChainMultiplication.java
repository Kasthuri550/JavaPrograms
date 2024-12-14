package DynamicProgramming.mcm;

import java.util.Arrays;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		
		int N = 5,arr[] = {40, 20, 30, 10, 30};
		
		System.out.println(matrixChainMultiplicationRecursion(1,N-1,arr));
		System.out.println(matrixChainMultiplicationMemoization(N,arr));
		System.out.println(matrixChainMultiplicationTabulation(N, arr));

	}

	private static int matrixChainMultiplicationTabulation(int n, int[] arr) {

		int dp[][]=new int[n][n];
		
//		for(int i=1;i<n;i++)
//		{
//			dp[i][i]=0;
//		}
		for(int i=n-1;i>=1;i--)
		{
			for(int j=i+1;j<n;j++)
			{
				int min=Integer.MAX_VALUE;
				for(int k=i;k<j;k++)
				{
					int steps=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
					
					if(steps<min)
						min=steps;
					
					dp[i][j]=min;
				}
			}
		}
		return dp[1][n-1];
	}

	private static int matrixChainMultiplicationMemoization(int N,int[] arr) {

		int dp[][]=new int[N][N];
		
		for(int row[]:dp)
		{
			Arrays.fill(row,-1);
		}
		
		return matrixChainMultiplicationMemo(1,N-1,arr,dp);
	}

	private static int matrixChainMultiplicationMemo(int i, int j, int[] arr, int[][] dp) {
		
		if(i==j) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		int min=Integer.MAX_VALUE;
		
		for(int k=i;k<j;k++)
		{
			int steps=arr[i-1]*arr[k]*arr[j]+matrixChainMultiplicationMemo(i,k, arr, dp)+
					matrixChainMultiplicationMemo(k+1, j, arr, dp);
			if(steps<min)
				min=steps;
		}
		
		return dp[i][j]=min;
	}

	private static int matrixChainMultiplicationRecursion(int i, int j, int[] arr) {
		
		if(i==j) return 0;
		
		int min=Integer.MAX_VALUE;
		
		for(int k=i;k<j;k++)
		{
			int steps=arr[i-1]*arr[k]*arr[j]+matrixChainMultiplicationRecursion(i,k, arr)+
					matrixChainMultiplicationRecursion(k+1, j, arr);
			if(steps<min)
				min=steps;
		}
		
		return min;
	}
}
