package DynamicProgramming.mcm;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {

	public static void main(String[] args) {

		int n = 7,k = 3,arr[] = {1,15,7,9,2,5,10};

		System.out.println(partitionArrayForMaximumSumRecursion(0,n,k,arr));
		System.out.println(partitionArrayForMaximumSumMemoization(0, n, k, arr));
		System.out.println(partitionArrayForMaximumSumTabulation(n, k, arr));
	}

	/*
	 * Time Complexity: O(k*n)
	 * Space Complexity: O(n)
	 * */
	private static int partitionArrayForMaximumSumTabulation(int n, int k, int[] arr) {

		int dp[]=new int[n+1];

		for(int i=n-1;i>=0;i--)
		{
			if(i==n) continue;

			int len=0,max=Integer.MIN_VALUE,maxAns=Integer.MIN_VALUE;

			for(int j=i;j<Math.min(i+k,n);j++)
			{
				len++;
				max=Math.max(max,arr[j]);
				int sum=len*max+dp[j+1];
				maxAns=Math.max(maxAns, sum);

			}
			dp[i]=maxAns;
		}

		return dp[0];
	}

	private static int partitionArrayForMaximumSumMemoization(int i, int n, int k, int[] arr) {

		int dp[]=new int[n];

		Arrays.fill(dp,-1);

		return partitionArrayForMaximumSumMemo(i, n, k, arr,dp);
	}

	/*
	 * Time Complexity: O(k*n)
	 * Space Complexity: O(n)
	 * */
	private static int partitionArrayForMaximumSumMemo(int i, int n, int k, int[] arr,int dp[]) {

		if(i==n)  return 0;

		if(dp[i]!=-1) return dp[i];

		int len=0,max=Integer.MIN_VALUE,maxAns=Integer.MIN_VALUE;

		for(int j=i;j<Math.min(i+k,n);j++)
		{
			len++;	
			max=Math.max(max,arr[j]);
			int sum=len*max+partitionArrayForMaximumSumMemo(j+1,n, k, arr,dp);
			maxAns=Math.max(maxAns, sum);
		}
		return dp[i]=maxAns;
	}

	/*
	 * Time Complexity: O(k^n) (exponential)
	 * Space Complexity: O(n)
	 * */
	private static int partitionArrayForMaximumSumRecursion(int i, int n, int k, int[] arr) {

		if(i==n) return 0;

		int len=0,max=Integer.MIN_VALUE,maxAns=Integer.MIN_VALUE;

		for(int j=i;j<Math.min(i+k,n);j++)
		{
			len++;
			max=Math.max(max,arr[j]);
			int sum=len*max+partitionArrayForMaximumSumRecursion(j+1,n, k, arr);
			maxAns=Math.max(maxAns, sum);
		}

		return maxAns;
	}
}
