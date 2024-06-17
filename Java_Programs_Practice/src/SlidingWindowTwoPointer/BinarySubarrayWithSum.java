package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarrayWithSum {

	public static void main(String[] args) {

		int N = 5,target = 2,arr[] = {1, 0, 1, 0, 1};

		binarySubarrayBrute(arr,N,target);
		binarySubarrayBetter(arr,N, target);
		binarySubarrayOptimalI(arr,N, target);
		int count1=binarySubarrayOptimalII(arr,N, target);
		int count2=binarySubarrayOptimalII(arr, N, target-1);
		System.out.println(count1-count2);
	}

	private static int binarySubarrayOptimalII(int[] arr, int n, int target) {
		
		int left=0,right=0,sum=0,count=0;
		
		while(right<n)
		{
			sum+=arr[right];
			
			while(sum>target)
			{
				sum-=arr[left];
				left++;
			}
			count+=(right-left+1);
			right++;
		}
		return count;
	}

	private static void binarySubarrayOptimalI(int[] arr, int n, int target) {
		
		int preSum=0,count=0;
		
		Map<Integer,Integer> map=new HashMap<>();
		map.put(0,1);
		
		for(int i=0;i<n;i++)
		{
			preSum+=arr[i];
			
			int remove=preSum-target;
			count+=map.getOrDefault(remove,0);
			map.put(preSum,map.getOrDefault(preSum,0)+1);
		}
		
		System.out.println(count);
		
	}

	private static void binarySubarrayBetter(int[] arr, int n, int target) {

		int count=0;

		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{

				sum+=arr[j];

				if(sum==target)
					count++;

			}
		}
		System.out.println(count);

	}

	private static void binarySubarrayBrute(int[] arr, int n, int target) {

		int count=0;

		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<=j;k++)
				{
					sum+=arr[k];
				}

				if(sum==target)
					count++;

			}
		}
		System.out.println(count);
	}
}
