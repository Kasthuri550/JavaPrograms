package Arrayprograms;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraySumEqualsK {

	public static void main(String[] args) {
		
		int[] arr = {3, 1, 2, 4};
		int k=6;
		
//		subarraySum1(arr,k);
//		subarraySum2(arr,k);
		subarraySum3(arr,k);
	}

	private static void subarraySum3(int[] arr, int k) {
		
		int n=arr.length,sum=0,count=0;
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		map.put(0,1);
		
		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
			
			int rem=sum-k;
			
			count+=map.getOrDefault(rem,0);
			
			map.put(sum,map.getOrDefault(sum,0)+1);
		}
		
		System.out.println(count);
	}

	private static void subarraySum2(int[] arr, int x) {
		
		int n=arr.length,count=0;
		
		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum+=arr[j];
				
				if(sum == x)
				{
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

	private static void subarraySum1(int[] arr, int x) {
		
		int n=arr.length,count=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				
				for(int k=i;k<=j;k++)
				{
					sum+=arr[k];
				}
				
				if(sum == x)
				{
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
