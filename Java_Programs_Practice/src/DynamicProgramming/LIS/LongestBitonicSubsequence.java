package DynamicProgramming.LIS;

import java.util.Arrays;

public class LongestBitonicSubsequence {

	public static void main(String[] args) {

		int n = 5, nums[] = {1, 2, 5, 3, 2};

		System.out.println(longestBitonicSubsequence(n,nums));

	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n)
	 * */
	private static int longestBitonicSubsequence(int n, int[] nums) {

		int dp1[]=new int[n];

		Arrays.fill(dp1, 1);

		for(int index=0;index<n;index++)
		{
			for(int prevIndex=0;prevIndex<index;prevIndex++)
			{
				if(nums[prevIndex]<nums[index] && 1+dp1[prevIndex]>dp1[index])
				{
					dp1[index]=1+dp1[prevIndex];
				}
			}
		}

		int dp2[]=new int[n],max=0;

		Arrays.fill(dp2, 1);

		for(int index=n-1;index>=0;index--)
		{
			for(int prevIndex=n-1;prevIndex>=index;prevIndex--)
			{
				if(nums[prevIndex]<nums[index] && 1+dp2[prevIndex]>dp2[index])
				{
					dp2[index]=1+dp2[prevIndex];
				}
			}

			max=Math.max(max, dp1[index]+dp2[index]-1);
		}

		return max;
	}
}
