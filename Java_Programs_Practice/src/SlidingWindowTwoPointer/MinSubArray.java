package SlidingWindowTwoPointer;

import java.util.Arrays;
import java.util.HashMap;

public class MinSubArray {

	public static void main(String[] args) {

		int[] nums = {-1,1, 4, 6, 2, 4, 3};
		int target =-1;

		//	    System.out.println(minSubarrayBrute1(nums,target));
		//	    System.out.println(minSubarrayBrute2(nums,target));
//		System.out.println(minSubarrayBetter(nums, target));
//		System.out.println(minSubarrayOptimal(nums, target));
		System.out.println(minSubarrayWithNegativeElements(nums, target));

	}

	private static int minSubarrayWithNegativeElements(int[] nums, int target) {

//		HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
//		hashMap.put(0,-1);
//		
//		for(int i=)
//		{
//			
//		}
		
		return 0;
	}

	private static int minSubarrayOptimal(int[] nums, int target) {

		int n=nums.length,sum=0,start=0;
		int minLength=Integer.MAX_VALUE,subarrayStart=-1,subarrayEnd=-1;
		
		for(int end=0;end<n;end++)
		{
			sum=sum+nums[end];
			
			while(target<=sum)
			{
				if(minLength>end-start+1)
				{
					minLength=end-start+1;
					subarrayStart=start;
					subarrayEnd=end;
				}
				sum=sum-nums[start];
				start++;
			}
		}
		if(subarrayStart!=-1 && subarrayEnd!=-1)
		{
			int[] subarray = Arrays.copyOfRange(nums,subarrayStart,subarrayEnd+1);
			System.out.println(Arrays.toString(subarray));
		}
		
		return minLength;
	}

	private static int minSubarrayBrute2(int[] nums, int target) {

		int n=nums.length,min=Integer.MAX_VALUE,start=0,end=0;

		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<=j;k++)
				{
					sum=sum+nums[k];
				}

				if(sum>=target && j-i+1<min)
				{
					min=j-i+1;
					start=i;
					end=j;
				}
			}
		}

		int[] minSubarray = Arrays.copyOfRange(nums,start,end+1);
		System.out.println(Arrays.toString(minSubarray));

		return min;
	}

	private static int minSubarrayBetter(int[] nums, int target) {

		int n = nums.length;
	    int min = Integer.MAX_VALUE;
	    int[] prefixSum = new int[n + 1];
	    prefixSum[0] = 0;

	    for (int i = 0; i < n; i++) {
	        prefixSum[i + 1] = prefixSum[i] + nums[i];
	    }

	    System.out.println("Prefix Sum Array: " + Arrays.toString(prefixSum));

	    int start = -1;
	    int end = -1;

	    for (int i = 0; i < n; i++) {
	        int requiredSum = target + prefixSum[i];

	        int index = Arrays.binarySearch(prefixSum, requiredSum);

	        if (index < 0) {
	            index = -index - 1;
	        }

	        if (index <= n) {
	            if (index - i < min) {
	                min = index - i;
	                start = i;
	                end = index - 1; 
	            }
	        }
	    }

	    if (min != Integer.MAX_VALUE) {
	        System.out.println("Subarray: " + Arrays.toString(Arrays.copyOfRange(nums, start, end+1)));
	    }

	    return min == Integer.MAX_VALUE ? 0 : min;
	}

	private static int minSubarrayBrute1(int[] nums, int target) {

		int n=nums.length,min=Integer.MAX_VALUE,start=0,end=0;

		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum=sum+nums[j];

				if(sum>=target && j-i+1<min)
				{
					min=j-i+1;
					start=i;
					end=j;
					break;
				}
			}
		}

		int[] subarray = Arrays.copyOfRange(nums,start,end+1);
		System.out.println(Arrays.toString(subarray));

		return min==Integer.MAX_VALUE?0:min;
	}

}
