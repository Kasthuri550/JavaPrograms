package Arrayprograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		
		int[] a = {100, 200, 1, 2, 3, 4};
		
		longestSuccessive1(a,a.length);
		longestSuccessive2(a, a.length);
		longestSuccessive3(a, a.length);
	}

	private static void longestSuccessive3(int[] a, int n) {
		
		int longest=1;
		Set<Integer> set=new HashSet<Integer>();
		
		for(int i=0;i<n;i++)
		{
			set.add(a[i]);
		}
		
		for(int i=0;i<n;i++)
		{
			if(!set.contains(a[i]-1))
			{
				int count=1;
				int x=a[i];
				
				while(set.contains(x+1))
				{
					count++;
					x++;
				}
				longest=Math.max(longest,count);
			}
		}
		
		System.out.println(longest);
	}

	private static void longestSuccessive2(int[] a, int n) {
		
		int lastSmaller=Integer.MIN_VALUE,longest=1,count=0;
		
		Arrays.sort(a);
		for(int i=0;i<n;i++)
		{
			if(a[i]-1 == lastSmaller)
			{
				count++;
				lastSmaller=a[i];
			}
			else if(a[i] != lastSmaller)
			{
				count=1;
				lastSmaller=a[i];
			}
			
			longest=Math.max(longest,count);
		}
		
		System.out.println(longest);
	}

	private static void longestSuccessive1(int[] a, int n) {
		
		int longest=1;
		
		for(int i=0;i<n;i++)
		{
			int x=a[i];
			int count=1;
			while(linearSearch(a,x+1))
			{
				count++;
				x++;
			}
			longest=Math.max(longest,count);
		}
		
		System.out.println(longest);
	}

	private static boolean linearSearch(int[] a, int target) {
		
		for(int k=0;k<a.length;k++)
		{
			if(a[k]==target)
			{
				return true;
			}
		}
		return false;
	}

}
