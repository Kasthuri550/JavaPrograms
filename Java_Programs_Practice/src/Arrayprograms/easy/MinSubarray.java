package Arrayprograms.easy;

import java.util.Arrays;
import java.util.HashMap;

public class MinSubarray {

	public static void main(String[] args) {
		
		int[] nums = {-1,1, 4, 6, 2, 4, 3};
		int target =10;
		
//		System.out.println(minSubarrayBrute(nums,target));
//		System.out.println(minSubarrayBetter(nums, target));
//		System.out.println(minSubarrayOptimal1(nums, target));
//		System.out.println(minSubarrayOptimal2(nums, target));
		
	}

	private static int minSubarrayOptimal2(int[] nums, int target) {

		int n=nums.length,sum=0,start=0,minLength=Integer.MAX_VALUE,subArrayStart=-1,subArrayEnd=-1;
		
		for(int end=0;end<n;end++)
		{
			sum=sum+nums[end];
			
			while(sum>target)
			{
				sum=sum-nums[start];
				start++;
			}
			
			if(sum==target && (end-start+1)<minLength)
			{
				minLength=end-start+1;
				subArrayStart=start;
				subArrayEnd=end;
			}
		}
		
		int[] subarray = Arrays.copyOfRange(nums,subArrayStart,subArrayEnd+1);
		
		System.out.println(Arrays.toString(subarray));
		return minLength==Integer.MAX_VALUE?0:minLength;
	}

	private static int minSubarrayOptimal1(int[] nums, int target) {

		int n=nums.length,sum=0,minLength=Integer.MAX_VALUE,start=-1,end=-1;
		
		 HashMap<Integer, Integer> hashMap = new HashMap<>();
	        
		 for(int i=0;i<n;i++)
		 {
			 sum=sum+nums[i];
			 
			 if(sum==target && i+1<minLength)
			 {
				 minLength=i+1;
				 start=0;
				 end=i;
			 }
			 
			 int rem=sum-target;
			 
			 if(hashMap.containsKey(rem))
			 {
				 int startIndex=hashMap.get(rem)+1;
				 
				 if(i-startIndex+1 <minLength)
				 {
					 minLength=i-startIndex+1;
					 start=startIndex;
					 end=i;
				 }
			 }
			 
			 hashMap.putIfAbsent(sum,i);
		 }
	      
		int[] subarray = Arrays.copyOfRange(nums,start,end+1);
		System.out.println(Arrays.toString(subarray));
		
		return minLength==Integer.MAX_VALUE?0:minLength;
	}

	private static int minSubarrayBetter(int[] nums, int target) {
		
		int n=nums.length,minLength=Integer.MAX_VALUE,start=-1,end=-1;
		
		for(int i=0;i<n;i++)
		{ 
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum=sum+nums[j];
				
				if(sum==target && j-i+1<minLength)
				{
					minLength=j-i+1;
					start=i;
					end=j;
				}
			}
		}
		
		int[] subarray = Arrays.copyOfRange(nums,start,end+1);
		
		System.out.println(Arrays.toString(subarray));
		
		return minLength==Integer.MAX_VALUE?0:minLength;
	}

	private static int minSubarrayBrute(int[] nums, int target) {

		int n=nums.length,minLength=Integer.MAX_VALUE,start=-1,end=-1;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<=j;k++)
				{
					sum=sum+nums[k];
				}
				
				if(sum==target && j-i+1<minLength)
				{
					minLength=j-i+1;
					start=i;
					end=j;
				}
			}
		}
		
		int[] subarray = Arrays.copyOfRange(nums,start,end+1);
		System.out.println(Arrays.toString(subarray));
		
		return minLength==Integer.MAX_VALUE?0:minLength;
	}
}
