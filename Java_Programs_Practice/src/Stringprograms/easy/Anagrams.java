package Stringprograms.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		
		String s = "anagra", t = "nagaram";
		
//		anagramsBrute(s,t);
//		anagramsBetter(s,t);
		anagramsOptimal(s, t);

	}

	private static void anagramsOptimal(String s, String t) {
		
		if(s.length()!=t.length())
		{
			System.out.println("Not Anagram");
			return;
		}
		
		int frequency[]=new int[26];
		
		for(char c:s.toCharArray())
		{
			frequency[c-'a']++;
		}
		
		for(char c:t.toCharArray())
		{
			frequency[c-'a']--;
		}
		
		for(int count:frequency)
		{
			if(count!=0)
			{
				System.out.println("Not Anagram");
				return;
			}
		}
		
		System.out.println("Anagram");
	}

	private static void anagramsBetter(String s, String t) {
		
		if(s.length()!=t.length())
		{
			System.out.println("Not Anagram");
			return;
		}
		
		Map<Character,Integer> frequencyMap=new HashMap<Character, Integer>();
		
		for(char c:s.toCharArray())
		{
			frequencyMap.put(c,frequencyMap.getOrDefault(c,0)+1);
		}
		
		for(char c:t.toCharArray())
		{
			frequencyMap.put(c,frequencyMap.getOrDefault(c,0)-1);
		}
		
		for(int value:frequencyMap.values())
		{
			if(value!=0)
			{
				System.out.println("Not Anagram");
				return;
			}
		}
		
		System.out.println("Anagram");
	}

	private static void anagramsBrute(String s, String t) {
		
		if(s.length()!=t.length())
		{
			System.out.println("Not Anagram");
			return;
		}
		
		char[] arr1 = s.toCharArray();
		char[] arr2=t.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		if(Arrays.equals(arr1, arr2))
		{
			System.out.println("Anagram");
		}
		else
		{
			System.out.println("Not Anagram");
		}
		
	}

}
