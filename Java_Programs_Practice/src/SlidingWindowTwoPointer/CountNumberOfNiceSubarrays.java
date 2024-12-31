package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {

	public static void main(String[] args) {

		int n = 5,nums[] = {1,1,2,1,1},k = 3;

		System.out.println(countNumberOfNiceSubarraysBrute(nums,n,k));
		System.out.println(countNumberOfNiceSubarraysBetter(nums, n, k));
		System.out.println(countNumberOfNiceSubarraysOptimalI(nums, n, k));
		System.out.println(countNumberOfNiceSubarraysOptimalII(nums, n, k)-countNumberOfNiceSubarraysOptimalII(nums, n, k-1));

	}

	/*
	 * Time Complexity: O(2n)
	 * Space Complexity: O(1)
	 */	
	private static int countNumberOfNiceSubarraysOptimalII(int[] nums, int n, int k) {

		int sum=0,left=0,right=0,count=0;

		while(right<n)
		{
			sum=sum+nums[right]%2;

			while(sum>k)
			{
				sum=sum-nums[left]%2;
				left++;
			}

			count+=(right-left+1);

			right++;
		}

		return count;
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */	
	private static int countNumberOfNiceSubarraysOptimalI(int[] nums, int n, int k) {

		int prefixSum=0,count=0;

		Map<Integer,Integer> map=new HashMap<>();
		map.put(0, 1);

		for(int i=0;i<n;i++)
		{
			prefixSum=prefixSum+nums[i]%2;

			int remove=prefixSum-k;
			count+=map.getOrDefault(remove,0);
			map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
		}

		return count;
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 */	
	private static int countNumberOfNiceSubarraysBetter(int[] nums, int n, int k) {

		int count=0;

		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum=sum+nums[j]%2;

				if(sum==k)
					count++;
			}
		}

		return count;
	}

	/*
	 * Time Complexity: O(n^3)
	 * Space Complexity: O(1)
	 */	
	private static int countNumberOfNiceSubarraysBrute(int[] nums, int n, int k) {

		int count=0;

		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int r=i;r<=j;r++)
				{
					sum=sum+nums[r]%2;
				}

				if(sum==k)
					count++;
			}
		}
		return count;
	}
}
