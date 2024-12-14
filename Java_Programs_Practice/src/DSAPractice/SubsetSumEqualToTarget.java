package DSAPractice;

public class SubsetSumEqualToTarget {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4 };
		int k = 4;
		int n = arr.length;

		//		System.out.println(subsetSumToTargetBrute(n-1,arr,k));
		System.out.println(subsetSumToTargetMemo(n,arr,k));
		System.out.println(subsetSumToTargetTabulation(n, arr,k));
		System.out.println(subsetSumToTargetSpaceOptimized(n, arr,k));

	}

	private static boolean subsetSumToTargetSpaceOptimized(int n, int[] arr, int target) {

		boolean prev[]=new boolean[target+1];

		prev[0]=true;

		if(arr[0]<=target)
		{
			prev[arr[0]]=true;
		}

		for(int i=1;i<n;i++)
		{
			boolean curr[]=new boolean[target+1];
			curr[0]=true;
			for(int j=1;j<=target;j++)
			{
				boolean notTake=prev[j];
				boolean take=false;

				if(arr[i]<=j)
				{
					take=prev[j-arr[i]];
				}

				curr[j]=notTake||take;
			}
			
			prev=curr;
		}

		return prev[target];
	}

	private static boolean subsetSumToTargetTabulation(int n, int[] arr, int target) {

		boolean dp[][]=new boolean[n][target+1];

		for(int i=0;i<n;i++)
		{
			dp[i][0]=true;
		}

		if(arr[0]<=target)
		{
			dp[0][arr[0]]=true;
		}

		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=target;j++)
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

		return dp[n-1][target];
	}

	private static boolean subsetSumToTargetMemo(int n, int[] arr, int target) {

		Boolean dp[][]=new Boolean[n][target+1];


		return subsetSumToTargetMemoization(n-1,arr,target,dp);
	}

	private static boolean subsetSumToTargetMemoization(int n, int[] arr, int target, Boolean[][] dp) {

		if(target==0) return true;
		if(n==0) return arr[0]==target;

		if(dp[n][target]!=null) return dp[n][target];

		boolean notTake=subsetSumToTargetMemoization(n-1, arr, target, dp);
		boolean take=false;
		if(arr[n]<=target)
		{
			take=subsetSumToTargetMemoization(n-1, arr,target-arr[n], dp);
		}

		dp[n][target]=notTake||take;

		return dp[n][target];
	}

	private static boolean subsetSumToTargetBrute(int n, int[] arr, int target) {

		if(target==0) return true;
		if(n==0) return arr[0] == target;

		boolean notTake=subsetSumToTargetBrute(n-1,arr, target);
		boolean take=false;

		if(arr[n]<=target)
		{
			take=subsetSumToTargetBrute(n-1,arr,target-arr[n]);
		}


		return take||notTake;
	}
}
