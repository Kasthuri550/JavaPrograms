package Arrayprograms.hard;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarraySum0 {

	public static void main(String[] args) {

		int[] a = {15,-2,2,-8,1,7,10,23};

		subarraySum0Brute(a);
		subarraySum0Better(a);
		subarraySum0Optimal1(a);
		subarraySum0Optimal2(a);
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static void subarraySum0Optimal2(int[] a) {

		int left=0,right=0,n=a.length;
		int sum=a[0],maxLen=Integer.MIN_VALUE;

		while(right<n)
		{
			while(left<=right && sum>0)
			{
				sum=sum-a[left];
				left++;
			}

			if(sum==0)
			{
				maxLen=Math.max(maxLen,right-left+1);
			}

			right++;
			if(right<n)
			{
				sum=sum+a[right];
			}
		}

		System.out.println(maxLen);
	}

	/*
	 * Time Complexity: O(nlogn)
	 * Space Complexity: O(n)
	 * */
	private static void subarraySum0Optimal1(int[] a) {

		int n=a.length,max=Integer.MIN_VALUE,sum=0;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();

		for(int i=0;i<n;i++)
		{
			sum+=a[i];

			if(sum==0)
			{
				max=i+1;
			}

			if(map.containsKey(sum))
			{
				max=Math.max(max,i-map.get(sum));
			}
			else
			{
				map.put(sum,i);
			}
		}

		System.out.println(max);
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static void subarraySum0Better(int[] a) {

		int n=a.length,max=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			int sum=0,j;
			for(j=i;j<n;j++)
			{
				sum+=a[j];

				if(sum==0)
				{
					max=Math.max(max,j-i+1);
				}
			}
		}

		System.out.println(max);
	}

	/*
	 * Time Complexity: O(n^3)
	 * Space Complexity: O(1)
	 * */
	private static void subarraySum0Brute(int[] a) {

		int n=a.length,max=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<=j;k++)
				{
					sum+=a[k];
				}

				if(sum==0)
				{
					max=Math.max(max,j-i+1);
				}
			}
		}

		System.out.println(max);
	}
}
