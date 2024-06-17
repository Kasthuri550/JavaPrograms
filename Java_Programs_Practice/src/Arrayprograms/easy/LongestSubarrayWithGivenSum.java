package Arrayprograms.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithGivenSum {

	public static void main(String[] args) {
		
		int[] a = { -1, 1, 1};
		int k=1;
		
		longestSubarraySumBetter(a,k);
		longestSubarraySumOptimal(a, k);
	}

	private static void longestSubarraySumOptimal(int[] a, int k) {
		
		int n=a.length,left=0,right=0,sum=a[0],max=Integer.MIN_VALUE;
		
		while(right<n)
		{
			while(a[left]<=a[right] && sum>k)
			{
				sum-=a[left];
				left++;
			}
			if(sum==k)
			{
				max=Math.max(max,right-left+1);
			}
			right++;
			if(right<n)
			{
				sum+=a[right];
			}
		}
		
		System.out.println(max);
		
	}

	private static void longestSubarraySumBetter(int[] a, int k) {
		
		int n=a.length,sum=0;
		int max=Integer.MIN_VALUE;
		
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			sum+=a[i];
			
			if(sum==k)
			{
				max=Math.max(max,i+1);
			}
			
			int rem=sum-k;
			
			if(map.containsKey(rem))
			{
				max=Math.max(max,i-map.get(rem));
			}
			
			if(!map.containsKey(sum))
			{
				map.put(sum,i);
			}
		}
		
		System.out.println(max);
	}
}
