package Stringprograms.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		
		String s = "tree";
		
		sort1(s);
		sort2(s);

	}

	private static void sort2(String s) {
		
		Map<Character,Integer> frequencyMap=new HashMap<>();
		
		for(int i=0;i<s.length();i++)
		{
			frequencyMap.put(s.charAt(i),frequencyMap.getOrDefault(s.charAt(i),0)+1);
		}
		
		PriorityQueue<Character> pq=new PriorityQueue<Character>((x,y)->frequencyMap.get(y)-frequencyMap.get(x));
		pq.addAll(frequencyMap.keySet());
		
		System.out.println(pq);
		
		StringBuilder sb=new StringBuilder();
		
		while(!pq.isEmpty())
		{
			char c=pq.poll();
			int count=frequencyMap.get(c);
			while(count>0)
			{
				sb.append(c);
				count--;
			}
		}
		
		System.out.println(sb.toString());
		
	}

	private static void sort1(String s) {
		
		int n=s.length();
		Character chars[]=new Character[n];
		int frequency[]=new int[256];
		
		for(int i=0;i<n;i++)
		{
			chars[i]=s.charAt(i);
			frequency[chars[i]]++;
		}
		
		Arrays.sort(chars,(x,y)->frequency[x]==frequency[y]?
				x- y:frequency[y]-frequency[x]);
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<chars.length;i++)
		{
			sb.append(chars[i]);
		}
		
		System.out.println(sb.toString());
		
	}
}
