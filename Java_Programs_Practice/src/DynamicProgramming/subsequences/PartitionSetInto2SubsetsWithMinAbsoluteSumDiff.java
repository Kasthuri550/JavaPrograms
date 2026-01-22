package DynamicProgramming.subsequences;

public class PartitionSetInto2SubsetsWithMinAbsoluteSumDiff {

	public static void main(String[] args) {

		int N = 4, arr[] = {1, 6, 11, 5};

		PartitionSetInto2SubsetsWithMinAbsoluteSumDiffTabulation(arr,N);
		PartitionSetInto2SubsetsWithMinAbsoluteSumDiffSpaceOptimized(arr,N);
	}

	/*
	 * Time Complexity: O(n*totalSum)
	 * Space Complexity: O(totalSum)
	 * */
	private static void PartitionSetInto2SubsetsWithMinAbsoluteSumDiffSpaceOptimized(int[] arr, int n) {

		int totalSum=0;

		for(int i=0;i<n;i++)
		{
			totalSum+=arr[i];
		}

		int k=totalSum;
		boolean prev[]=new boolean[k+1];
		boolean curr[]=new boolean[k+1];

		prev[0]=curr[0]=true;

		if(arr[0]<=k) prev[arr[0]]=true;

		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=k;j++)
			{
				boolean notTake=prev[j];
				boolean take=false;

				if(arr[i]<=j)
				{
					take=prev[j-arr[i]];
				}

				curr[j]=take||notTake;
			}

			prev=curr.clone();
		}

		int min=Integer.MAX_VALUE;

		for(int i=0;i<=k/2;i++)
		{
			if(prev[i])
			{
				min=Math.min(min,Math.abs((k-i)-i));
			}
		}

		System.out.println(min);
	}

	/*
	 * Time Complexity: O(n*totalSum)
	 * Space Complexity: O(n*totalSum)
	 * */	
	private static void PartitionSetInto2SubsetsWithMinAbsoluteSumDiffTabulation(int[] arr, int n) {

		int totalSum=0;

		for(int i=0;i<n;i++)
		{
			totalSum+=arr[i];
		}

		boolean dp[][]=new boolean[n][totalSum+1];

		for(int i=0;i<n;i++)
		{
			dp[i][0]=true;
		}

		if(arr[0]<=totalSum)dp[0][arr[0]]=true;

		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=totalSum;j++)
			{
				boolean notTake=dp[i-1][j];
				boolean take=false;

				if(arr[i]<=j)
				{
					take=dp[i-1][j-arr[i]];
				}
				dp[i][j]=notTake||take;
			}
		}

		int min=Integer.MAX_VALUE;

		for(int i=0;i<=totalSum/2;i++)
		{
			if(dp[n-1][i])
			{
				min=Math.min(min,Math.abs((totalSum-i)-i));
			}
		}

		System.out.println(min);
	}
}
