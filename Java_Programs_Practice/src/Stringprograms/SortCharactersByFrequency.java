package Stringprograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		
		String s = "ccccaaa";
		sortChar1(s);
		sortChar2(s);
	}

	private static void sortChar2(String s) {
		
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		
		for(int i=0;i<s.length();i++)
		{
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		}
		
		PriorityQueue<Character> pq=new PriorityQueue<Character>((x,y) -> map.get(y)-map.get(x));
		pq.addAll(map.keySet());
		
		StringBuilder sb=new StringBuilder();
		while(!pq.isEmpty())
		{
			char ch=pq.poll();
			int count=map.get(ch);
			while(count>0)
			{
				sb.append(ch);
				count--;
			}
		}
		
		System.out.println(sb.toString());
	}

	private static void sortChar1(String s) {
		
		int n=s.length();
		Character c[]=new Character[n];
		int frequency[]=new int[256];
		
		for(int i=0;i<n;i++)
		{
			c[i]=s.charAt(i);
			frequency[c[i]]++;
		}
		
		Arrays.sort(c,(x,y) -> frequency[x]==frequency[y]?Integer.compare(x, y):Integer.compare(frequency[y],frequency[x]));
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<c.length;i++)
		{
			sb.append(c[i]);
		}
		
		System.out.println(sb.toString());
		
	}

}
