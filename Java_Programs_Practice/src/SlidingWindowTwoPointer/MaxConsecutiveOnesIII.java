package SlidingWindowTwoPointer;

public class MaxConsecutiveOnesIII {

	public static void main(String[] args) {

		int nums[] = {1,1,1,0,0,0,1,1,1,1,0}, k = 2;

		System.out.println(maxConsecutiveOnesIIIBrute(nums,k));
		System.out.println(maxConsecutiveOnesIIIOptimal(nums, k));
		System.out.println(maxConsecutiveOnesIIIMostOptimal(nums, k));

	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	private static int maxConsecutiveOnesIIIMostOptimal(int[] nums, int k) {

		int left=0,right=0,maxLength=Integer.MIN_VALUE,n=nums.length,zeroes=0;

		while(right<n)
		{
			if(nums[right]==0)
				zeroes++;

			if(zeroes>k)
			{
				if(nums[left]==0) zeroes--;
				left++;
			}
			if(zeroes<=k)
			{
				maxLength=Math.max(maxLength,right-left+1);
			}

			right++;
		}

		return maxLength;
	}
	/*
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(1)
	 */
	private static int maxConsecutiveOnesIIIOptimal(int[] nums, int k) {

		int left=0,right=0,maxLength=Integer.MIN_VALUE,n=nums.length,zeroes=0;

		while(right<n)
		{
			if(nums[right]==0)
				zeroes++;

			while(zeroes>k)
			{
				if(nums[left]==0) zeroes--;
				left++;
			}
			if(zeroes<=k)
			{
				maxLength=Math.max(maxLength,right-left+1);
			}

			right++;
		}

		return maxLength;
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 */
	private static int maxConsecutiveOnesIIIBrute(int[] nums, int k) {

		int n=nums.length,maxLength=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			int zeros=0;
			for(int j=i;j<n;j++)
			{
				if(nums[j]==0)
					zeros++;

				if(zeros<=k)
				{
					maxLength=Math.max(maxLength,j-i+1);
				}
				else
				{
					break;
				}
			}
		}

		return maxLength;
	}
}
