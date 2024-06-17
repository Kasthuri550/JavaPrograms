package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		String s="geeksforgeeks";
		
		longestSubstringBrute(s);
		longestSubstringOptimal(s);
	}

	private static void longestSubstringOptimal(String s) {
		
		int n=s.length();
		
		int left=0,right=0,maxLen=Integer.MIN_VALUE;
		
		Map<Character,Integer> map=new HashMap<>();
		
		while(right<n)
		{
			if(map.containsKey(s.charAt(right)))
			{
				left=Math.max(map.get(s.charAt(right))+1,left);
			}
			maxLen=Integer.max(maxLen, right-left+1);
			map.put(s.charAt(right),right);
			right++;
		}
		
		System.out.println(maxLen);
	}

	private static void longestSubstringBrute(String s) {
		
		int n=s.length(),maxLen=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			Set<Character> hashSet=new HashSet<>();
			for(int j=i;j<n;j++)
			{
				if(hashSet.contains(s.charAt(j)))
				{
					maxLen=Math.max(maxLen,j-i);
					break;
				}
				hashSet.add(s.charAt(j));
			}
		}
		
		System.out.println(maxLen);
	}
}
