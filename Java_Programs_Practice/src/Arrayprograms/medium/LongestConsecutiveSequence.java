package Arrayprograms.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int[] arr = {100, 200, 1, 2, 3, 4};

		//		longestSuccessiveBrute(arr);
		longestSuccessiveBetter(arr);
		longestSuccessiveOptimal(arr);

	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * */
	private static void longestSuccessiveOptimal(int[] arr) {

		int n=arr.length,longest=Integer.MIN_VALUE;

		Set<Integer> set=new HashSet<>();

		for(int i=0;i<n;i++)
		{
			set.add(arr[i]);
		}

		for(int i=0;i<n;i++)
		{
			if(!set.contains(arr[i]-1))
			{
				int count=1;
				int element=arr[i];
				while(set.contains(element+1))
				{
					count++;
					element++;
				}
				longest=Math.max(longest,count);
			}

		}

		System.out.println(longest);

	}

	/*
	 * Time Complexity: O(nlogn)
	 * Space Complexity: O(1)
	 * */
	private static void longestSuccessiveBetter(int[] arr) {

		Arrays.sort(arr);
		int n=arr.length,lastSmaller=Integer.MIN_VALUE,longest=Integer.MIN_VALUE;
		int count=0;


		for(int i=0;i<n;i++)
		{
			if(arr[i]-1==lastSmaller)
			{
				count++;
				lastSmaller=arr[i];
			}
			else if(arr[i]!=lastSmaller)
			{
				count=1;
				lastSmaller=arr[i];
			}

			longest=Math.max(longest,count);
		}

		System.out.println(longest);

	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * */
	private static void longestSuccessiveBrute(int[] arr) {

		int n=arr.length,longest=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			int element=arr[i];
			int count=1;
			while(linearSearch(arr,element+1)==true)
			{
				element++;
				count++;
			}

			longest=Math.max(longest,count);			
		}

		System.out.println(longest);
	}

	private static boolean linearSearch(int[] arr, int element) {

		int n=arr.length;

		for(int i=0;i<n;i++)
		{
			if(arr[i]==element)
			{
				return true;
			}
		}
		return false;
	}
}
