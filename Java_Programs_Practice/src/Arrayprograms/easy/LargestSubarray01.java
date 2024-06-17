package Arrayprograms.easy;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarray01 {

	public static void main(String[] args) {
		
		int A[] = {0,0,1,0,0};
		
		largestSubarrayEqual01Brute(A);
		largestSubarrayEqual01Better(A);
		largestSubarrayEqual01Optimal(A);

	}

	private static void largestSubarrayEqual01Optimal(int[] a) {
		
		int n=a.length,sum=0,max=0;
		
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			sum+=(a[i]==0)?-1:1;
			
			if(sum==0)
			{
				max=i+1;
			}
			
			if(map.containsKey(sum))
			{
				int previousIndex=map.get(sum);
				max=Math.max(max,i-previousIndex);
			}
			else
			{
				map.put(sum,i);
			}
		}
		
		System.out.println(max);
		
	}

	private static void largestSubarrayEqual01Better(int[] a) {
		
		int n=a.length,max=0;
		
		int prefixSum0[]=new int[n+1];
		int prefixSum1[]=new int[n+1];
		
		for(int i=0;i<n;i++)
		{
			prefixSum0[i+1]=prefixSum0[i]+(a[i]==0?1:0);
			prefixSum1[i+1]=prefixSum1[i]+(a[i]==1?1:0);
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int count0=prefixSum0[j+1]-prefixSum0[i];
				int count1=prefixSum1[j+1]-prefixSum1[i];
				
				if(count0==count1)
				{
					max=Math.max(max,j-i+1);
				}
			}
		}
		
		System.out.println(max);
		
	}

	private static void largestSubarrayEqual01Brute(int[] a) {
		
		int n=a.length,max=0;
		
		for(int i=0;i<n;i++)
		{
			int count0=0,count1=0;
			for(int j=i;j<n;j++)
			{
				if(a[j]==0)
				{
					count0++;
				}
				else
				{
					count1++;
				}
				
				if(count0==count1)
				{
					max=Math.max(max,j-i+1);
				}
			}
		}
		
		System.out.println(max);
		
	}
}
