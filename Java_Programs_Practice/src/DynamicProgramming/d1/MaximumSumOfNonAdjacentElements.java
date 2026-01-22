package DynamicProgramming.d1;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {

	public static void main(String[] args) {

		int N = 6,Arr[] = {5, 5, 10, 100, 10, 5};

		//		System.out.println(maximumSumOfNonAdjacentElementsRecursion(N-1,Arr));
		//		System.out.println(maximumSumOfNonAdjacentElementsMemoization(N-1, Arr));
		System.out.println(maximumSumOfNonAdjacentElementsTabulation(N, Arr));
		System.out.println(maximumSumOfNonAdjacentElementsSpaceOptimized(N, Arr));
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	private static int maximumSumOfNonAdjacentElementsSpaceOptimized(int n, int[] arr) {

		int prev1=arr[0],prev2=0,curr=Integer.MIN_VALUE;

		for(int i=1;i<n;i++)
		{
			int notTake=prev1;
			int take=arr[i];
			if(i>1)
				take+=prev2;

			curr=Math.max(notTake, take);
			prev2=prev1;
			prev1=curr;
		}

		return prev1;
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	private static int maximumSumOfNonAdjacentElementsTabulation(int n, int[] arr) {

		int dp[]=new int[n+1];

		dp[0]=arr[0];

		for(int i=1;i<n;i++)
		{
			int notTake=dp[i-1];
			int take=arr[i];
			if(i>1)
				take+=dp[i-2];

			dp[i]=Math.max(notTake, take);
		}

		return dp[n-1];
	}

	private static int maximumSumOfNonAdjacentElementsMemoization(int n, int[] arr) {

		int dp[]=new int[n+1];

		Arrays.fill(dp, -1);

		return maximumSumOfNonAdjacentElementsMemo(n, arr,dp);
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	private static int maximumSumOfNonAdjacentElementsMemo(int n, int[] arr,int dp[]) {
		if(n==0) return arr[0];
		if(n<0) return 0;

		if(dp[n]!=-1) return dp[n];

		int notTake=maximumSumOfNonAdjacentElementsMemoization(n-1, arr);
		int take=arr[n]+maximumSumOfNonAdjacentElementsMemoization(n-2, arr);

		return dp[n]=Math.max(notTake, take);
	}

	/*
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(n)
	 */
	private static int maximumSumOfNonAdjacentElementsRecursion(int n, int[] arr) {

		if(n==0) return arr[0];
		if(n<0) return 0;

		int notTake=maximumSumOfNonAdjacentElementsRecursion(n-1, arr);
		int take=arr[n]+maximumSumOfNonAdjacentElementsRecursion(n-2, arr);

		return Math.max(notTake, take);
	}
}
