package Arrayprograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

	public static void main(String[] args) {
		
		int nums[] = {2,7,11,15}, target = 9;
//		System.out.println(twoSum1(nums,target));
//		System.out.println(twoSum2(nums, target));
		System.out.println(twoSum3(nums, target));
		System.out.println(twoSum4(nums, target));
	}

	private static String twoSum4(int[] nums, int target) {
		
		int left=0,right=nums.length-1;
		
		Arrays.sort(nums);
		
		while(left < right)
		{
			int sum=nums[left] + nums[right];
			if(sum == target)
			{
				System.out.println("["+left+", "+right+"]");
				return "Yes";
			}
			else if(sum < target)
			{
				left++;
			}
			else
			{
				right--;
			}
		}
		return "No";
	}

	private static String twoSum3(int[] nums, int target) {
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		int n=nums.length;
		
		for(int i=0;i<n;i++)
		{
			int sum=target-nums[i];
			
			if(map.containsKey(sum))
			{
				System.out.println("["+i+", "+map.get(sum)+"]");
				return "Yes";
			}
			else
			{
				map.put(nums[i],i);
			}
			
		}
		return "No";
	}

	private static String twoSum2(int[] nums, int target) {
		
		int n=nums.length;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(nums[i]+nums[j]==target)
				{
					System.out.println("["+i+", "+j+"]");
					return "Yes";
				}
			}
		}
		return "No";
	}

	private static String twoSum1(int[] nums, int target) {
		
		int n=nums.length;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i == j)
				{
					continue;
				}
				
				if(nums[i]+nums[j] == target)
				{
					System.out.println("["+i+", "+j+"]");
					return "Yes";	
				}
			}
		}
		
		return "No";
		
	}

}
