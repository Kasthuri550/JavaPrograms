package bitmanipulation.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber_III {

	public static void main(String[] args) {

		int nums[] = {1,2,1,3,2,5};

		System.out.println(singleNumberIIIApproach1(nums));
		System.out.println(singleNumberIIIApproach2(nums));
	}
	private static ArrayList<Integer> singleNumberIIIApproach2(int[] nums) {

		long xor=0,n=nums.length;
		
		for(int i=0;i<n;i++)
		{
			xor=xor^nums[i];
		}
		
		long rightmost=(xor^(xor-1)) & xor;
		
		int b1=0,b2=0;
				
		for(int i=0;i<n;i++)
		{
			if((nums[i] & rightmost)!=0)
			{
				b1=b1^nums[i];
			}
			else
			{
				b2=b2^nums[i];
			}
		}
		
		ArrayList<Integer> result=new ArrayList<>();
		result.add(b1);
		result.add(b2);
		
		return result;
	}
	/*
	 * Time Complexity: O(n log m)+O(m)   ->  m=n/2+1
	 * Space Complexity: O(m)
	 * */
	private static ArrayList<Integer> singleNumberIIIApproach1(int[] nums) {

		Map<Integer,Integer> map=new HashMap<>();

		ArrayList<Integer> list=new ArrayList<>();

		for(int arr:nums)
		{
			map.put(arr,map.getOrDefault(arr,0)+1);
		}

		for(Map.Entry<Integer,Integer> entry:map.entrySet())
		{
			if(entry.getValue()==1)
			{
				list.add(entry.getKey());
			}
		}

		return list;
	}
}
