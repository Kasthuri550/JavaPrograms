package Stringprograms.medium;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {

	public static void main(String[] args) {
		
		String s = "anagram", t = "nagaram";
		
		System.out.println(checkAnagramI(s,t));
		System.out.println(checkAnagramII(s, t));
		System.out.println(checkAnagramIII(s, t));

	}

	private static boolean checkAnagramIII(String s, String t) {
		
		
		if(s.length()!=t.length())
		{
			return false;
		}
		char chars1[]=s.toCharArray();
		char chars2[]=t.toCharArray();
		
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		
		
		return Arrays.equals(chars1, chars2);
	}

	private static boolean checkAnagramII(String s, String t) {
		
		int freq[]=new int[26];
		
		for(int i=0;i<s.length();i++)
		{
			freq[s.charAt(i)-'a']++;
		}
		
		for(int j=0;j<t.length();j++)
		{
			freq[t.charAt(j)-'a']--;
		}
		
		for(int value:freq)
		{
			if(value!=0)
			{
				return false;
			}
		}
		return true;
	}

	private static boolean checkAnagramI(String s, String t) {
		
		HashMap<Character,Integer> freqMap=new HashMap<>();
		
		if(s.length()!=t.length())
		{
			return false;
		}
		
		for(int i=0;i<s.length();i++)
		{
			freqMap.put(s.charAt(i),freqMap.getOrDefault(s.charAt(i),0)+1);
		}
		
		for(int j=0;j<t.length();j++)
		{
			freqMap.put(t.charAt(j),freqMap.getOrDefault(t.charAt(j),0)-1);
		}
		
		for(int value:freqMap.values())
		{
			if(value!=0)
			{
				return false;
			}
		}
		
		return true;		
	}
}
