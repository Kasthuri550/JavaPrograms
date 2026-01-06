package DynamicProgramming.LIS;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequences {

	public static void main(String[] args) {

		int arr[] = {1,5,4,3,2,6,7,2},n=arr.length;

		System.out.println(numberOfLIS(arr,n));

	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n)
	 * */
	private static int numberOfLIS(int[] arr, int n) {

		int dp[]=new int[n],max=1;

		Arrays.fill(dp, 1);

		int count[]=new int[n];

		Arrays.fill(count, 1);

		for(int index=0;index<n;index++)
		{
			for(int prevIndex=0;prevIndex<index;prevIndex++)
			{
				if(arr[index]>arr[prevIndex] && 1+dp[prevIndex]>dp[index])
				{
					dp[index]=1+dp[prevIndex];
					count[index]=count[prevIndex];
				}
				else if(arr[index]>arr[prevIndex] && 1+dp[prevIndex]==dp[index])
				{
					count[index]+=count[prevIndex];
				}
			}

			max=Math.max(max,dp[index]);
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.toString(count));
		int nos=0;

		for(int i=0;i<n;i++)
		{
			if(dp[i]==max)
			{
				nos=nos+count[i];
			}
		}

		return nos;
	}
}
