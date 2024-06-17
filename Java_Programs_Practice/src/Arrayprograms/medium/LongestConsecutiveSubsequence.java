package Arrayprograms.medium;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		
		int[] arr = {100, 200, 1, 2, 3, 4};
		
		longestConsecutiveBrute(arr);
		longestConsecutiveBetter(arr);
		longestConsecutiveOptimal(arr);

	}

	private static void longestConsecutiveOptimal(int[] arr) {
		
		int n=arr.length,count=0,longest=Integer.MIN_VALUE;
		
		HashSet<Integer> set=new HashSet<Integer>();
		
		for(int i=0;i<n;i++)
		{
			set.add(arr[i]);
		}
		
		for(int ele:set)
		{
			if(!set.contains(ele-1))
			{
				count=1;
				int x=ele;
				while(set.contains(x+1))
				{
					count++;
					x++;
				}
				longest=Math.max(longest, count);
			}
		}
		
		System.out.println(longest);
		
	}

	private static void longestConsecutiveBetter(int[] arr) {
		
		int n=arr.length,lastSmaller=Integer.MAX_VALUE,count=0,longest=Integer.MIN_VALUE;
		
		Arrays.sort(arr);
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]-1 == lastSmaller)
			{
				count++;
				lastSmaller=arr[i];
			}
			else if(arr[i]!=lastSmaller)
			{
				count=1;
				lastSmaller=arr[i];
			}
			longest=Math.max(longest, count);
		}
		
		System.out.println(longest);	
	}

	private static void longestConsecutiveBrute(int[] arr) {
		
		int n=arr.length,longest=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			int count=1;
			int x=arr[i];
			
			while(linearSearch(arr,x+1)==true)
			{
				x++;
				count++;
			}
			
			longest=Math.max(longest, count);
		}
		System.out.println(longest);
	}

	private static boolean linearSearch(int[] arr, int ele) {
		
		int n=arr.length;
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]==ele)
			{
				return true;
			}
		}
		return false;
	}
}
