package ArrayPractice;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		
		int[] a = {100, 200, 1, 2, 3, 4};
		
//		longestConsecutiveSequenceBrute(a);
		longestConsecutiveSequenceBetter(a);
		longestConsecutiveSequenceOptimal(a);
	}

	private static void longestConsecutiveSequenceOptimal(int[] a) {
		
		int n=a.length,longest=Integer.MIN_VALUE;
		
		HashSet<Integer> hashSet=new HashSet<Integer>();
		
		for(int i=0;i<n;i++)
		{
			hashSet.add(a[i]);
		}
		
		for(int it:hashSet)
		{
			if(!hashSet.contains(it-1))
			{
				int count=1, element=it;
				
				while(hashSet.contains(element+1))
				{
					count++;
					element++;
				}
				longest=Math.max(longest,count);
			}				
		}
		
		System.out.println(longest);
		
	}

	private static void longestConsecutiveSequenceBetter(int[] a) {
		
		int lastSmaller=Integer.MAX_VALUE,count=0,longest=Integer.MIN_VALUE;
		
		Arrays.sort(a);
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]-1==lastSmaller)
			{
				count++;
				lastSmaller=a[i];
			}
			else if(a[i]!=lastSmaller)
			{
				count=1;
				lastSmaller=a[i];
			}
			
			longest=Math.max(longest, count);
		}
		
		System.out.println(longest);
		
	}

	private static void longestConsecutiveSequenceBrute(int[] a) {
		
		int n=a.length,longest=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			int count=1,element=a[i];
			
			while(linearSearch(a,element+1))
			{
				element++;
				count++;
			}
			
			longest=Math.max(longest,count);
		}
		
		System.out.println(longest);
	}

	private static boolean linearSearch(int[] a, int num) {
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==num) return true;
		}
		return false;
	}
}
