package bitmanipulation.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber_II {

	public static void main(String[] args) {

		int nums[] = {0,1,0,1,0,1,99};

		System.out.println(singleNumberIIApproach1(nums));
		System.out.println(singleNumberIIApproach2(nums));
		System.out.println(singleNumberIIApproach3(nums));
		System.out.println(singleNumberIIApproach4(nums));
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int singleNumberIIApproach4(int[] nums) {

		int ones=0,twos=0,n=nums.length;

		for(int i=0;i<n;i++)
		{
			ones=(ones ^ nums[i]) & ~ twos;
			twos=(twos ^ nums[i]) & ~ ones;
		}

		return ones;
	}

	/*
	 * Time Complexity: O(n*log n)+O(n/3)
	 * Space Complexity: O(1)
	 * */
	private static int singleNumberIIApproach3(int[] nums) {

		int n=nums.length;

		Arrays.sort(nums);

		for(int i=1;i<n;i=i+3)
		{
			if(nums[i]!=nums[i-1])
			{
				return nums[i-1];
			}
		}

		return nums[n-1];
	}
	/*
	 * Time Complexity: O(n*32)
	 * Space Complexity: O(1)
	 * */
	private static int singleNumberIIApproach2(int[] nums) {

		int n=nums.length,ans=0;

		for(int bitIndex=0;bitIndex<=31;bitIndex++)
		{
			int count=0;

			for(int i=0;i<n;i++)
			{
				if((nums[i] & (1<<bitIndex))!=0)
				{
					count++;
				}
			}

			if(count%3==1)
			{
				ans=ans | (1<<bitIndex);
			}
		}

		return ans;
	}
	/*
	 * Time Complexity: O(n*log m)+O(m)
	 * Space Complexity: O(m)
	 * */
	private static int singleNumberIIApproach1(int[] nums) {

		Map<Integer,Integer> map=new HashMap<>();

		for(int arr:nums)
		{
			map.put(arr,map.getOrDefault(arr,0)+1);
		}

		for(Map.Entry<Integer,Integer> entry:map.entrySet())
		{
			if(entry.getValue()==1)
			{
				return entry.getKey();
			}
		}

		return 0;
	}
}
