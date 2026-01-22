package DynamicProgramming.subsequences;

public class SubsetSumEqualToTarget {

	public static void main(String[] args) {

		int N = 6,arr[] = {3, 34, 4, 12, 5, 2},sum = 9;

		System.out.println(subsetSumEqualToTargetRecurrsion(arr,sum,N-1));
		System.out.println(subsetSumEqualToTargetMemoization(arr,sum, N-1));
		System.out.println(subsetSumEqualToTargetTabulation(arr, sum,N));
		System.out.println(subsetSumEqualToTargetSpaceOptimized(arr, sum, N));
	}

	/*
	 * Time Complexity: O(n*sum)
	 * Space Complexity: O(sum)
	 * */
	private static boolean subsetSumEqualToTargetSpaceOptimized(int[] arr, int sum, int n) {

		boolean prev[]=new boolean[sum+1];

		prev[0]=true;

		if(arr[0]<=sum)
		{
			prev[arr[0]]=true;
		}

		for(int i=1;i<n;i++)
		{
			boolean curr[]=new boolean[sum+1];
			curr[0]=true;
			for(int j=1;j<=sum;j++)
			{
				boolean notTake=prev[j];
				boolean take=false;

				if(arr[i]<=j)
				{
					take=prev[j-arr[i]];
				}

				curr[j]=notTake||take;
			}	

			prev=curr.clone();
		}

		return prev[sum];
	}

	/*
	 * Time Complexity: O(n*sum)
	 * Space Complexity: O(n*sum)
	 * */
	private static boolean subsetSumEqualToTargetTabulation(int[] arr, int sum, int n) {

		boolean dp[][]=new boolean[n][sum+1];

		for(int i=0;i<n;i++)
		{
			dp[i][0]=true;
		}

		if(arr[0]<=sum)
		{
			dp[0][arr[0]]=true;
		}

		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=sum;j++)
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
		return dp[n-1][sum];
	}

	/*
	 * Time Complexity: O(n*sum)
	 * Space Complexity: O(n*sum)+O(n)
	 * */
	private static boolean subsetSumEqualToTargetMemoization(int[] arr, int sum, int n) {

		Boolean dp[][]=new Boolean[n+1][sum+1];

		//		for(int row[]:dp)
		//		{
		//			Arrays.fill(row,-1);
		//		}

		return subsetSumEqualToTargetMemo(arr, sum, n,dp);
	}

	private static boolean subsetSumEqualToTargetMemo(int[] arr, int sum, int n, Boolean[][] dp) {

		if(sum==0) return true;

		if(n==0) return arr[0]==sum;

		if(dp[n][sum]!=null) return dp[n][sum];

		boolean notTake=subsetSumEqualToTargetMemoization(arr, sum, n-1);
		boolean take=false;

		if(arr[n]<=sum)
		{
			take=subsetSumEqualToTargetMemoization(arr, sum-arr[n], n-1);
		}

		return dp[n][sum]=notTake||take;
	}

	/*
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(n)
	 * */
	private static boolean subsetSumEqualToTargetRecurrsion(int[] arr, int sum, int n) {

		if(sum==0) return true;

		if(n==0) return arr[0]==sum;

		boolean notTake=subsetSumEqualToTargetRecurrsion(arr, sum, n-1);
		boolean take=false;
		if(arr[n]<=sum)
		{
			take=subsetSumEqualToTargetRecurrsion(arr, sum-arr[n], n-1);
		}

		return notTake || take;
	}
}
