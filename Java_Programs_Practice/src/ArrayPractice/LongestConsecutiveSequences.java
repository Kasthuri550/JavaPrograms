package ArrayPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequences {

	public static void main(String[] args) {
		
		int[] a = {100, 200, 1, 2, 3, 4};
		
		System.out.println(longestConsecutiveSequencesBrute(a));
		System.out.println(longestConsecutiveSequencesBetter(a));
		System.out.println(longestConsecutiveSequencesOptimal(a));

	}

	private static int longestConsecutiveSequencesOptimal(int[] a) {
		
		int n=a.length,longest=1;
		Set<Integer> set=new HashSet<>();
		for(int i=0;i<n;i++)
		{
			set.add(a[i]);
		}
		
		for(int it:set)
		{
			if(!set.contains(it-1))
			{
				int x=it,count=1;
				
				while(set.contains(x+1))
				{
					x++;
					count++;
				}
				
				longest=Math.max(longest,count);
			}
		}
		return longest;
	}

	private static int longestConsecutiveSequencesBetter(int[] a) {
		
		int n=a.length,lastSmaller=Integer.MIN_VALUE,count=0,longest=1;
		Arrays.sort(a);
		
		for(int i=0;i<n;i++)
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
			
			longest=Math.max(longest,count);
		}
		
		return longest;
	}

	private static int longestConsecutiveSequencesBrute(int[] a) {
		
		int n=a.length,longest=1;
		
		for(int i=0;i<n;i++)
		{
			int x=a[i],count=1;
			
			while(linearSearch(a,x+1))
			{
				x++;
				count++;
			}
			
			longest=Math.max(longest,count);
		}
		
		return longest;
	}

	private static boolean linearSearch(int[] a, int e) {
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==e) return true;
		}
		
		return false;
	}
}
