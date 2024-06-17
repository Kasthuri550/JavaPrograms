package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringAtMostKDistinctCharacters {

	public static void main(String[] args) {
		
		String s="aabacbebebe";
		int k=3;
		
		longestSubstringKDistinctCharsBrute(s,k);
		longestSubstringKDistinctCharsOptimal(s, k);

	}

	private static void longestSubstringKDistinctCharsOptimal(String s, int k) {
		
		int n=s.length(),right=0,left=0,maxLen=Integer.MIN_VALUE;
		
		Map<Character,Integer> map=new HashMap<>();
		
		while(right<n)
		{
			map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
			
			while(map.size()>k)
			{
				map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
				if(map.get(s.charAt(left))==0)
				{
					map.remove(s.charAt(left));
				}
				left++;
			}
			if(map.size()<=k)
			{
				maxLen=Math.max(maxLen, right-left+1);
			}
			right++;
		}
		
		System.out.println(maxLen);
		
	}

	private static void longestSubstringKDistinctCharsBrute(String s, int k) {
		
		int n=s.length(),maxLen=0;
		
		for(int i=0;i<n;i++)
		{
			Set<Character> hashSet=new HashSet<>();
			for(int j=i;j<n;j++)
			{
				hashSet.add(s.charAt(j));
				if(hashSet.size()<=k)
				{
					maxLen=Math.max(maxLen, j-i+1);
				}
				else
				{
					break;
				}
			}
		}
		System.out.println(maxLen);
	}
}
