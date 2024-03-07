package Stringprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class PrintCharactersDescendingFrequency {

	public static void main(String[] args) {
		
		String str="banana";
		
		frequency(str);
		
		frequency1(str);

	}

	private static void frequency1(String str) {
		
		int n=str.length();
		
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		
		for(int i=0;i<n;i++)
		{
			map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
		}
		
		PriorityQueue<Character> pq=new PriorityQueue<Character>((a,b) -> map.get(b)-map.get(a));
		pq.addAll(map.keySet());
		
		StringBuilder sb=new StringBuilder();
		
		while(!pq.isEmpty())
		{
			char ch=pq.poll();
			int count=map.get(ch);
			for(int i=0;i<count;i++)
			{
				sb.append(ch);
			}
		}
		
		System.out.println(sb.toString());
	}

	private static void frequency(String str) {
		
		int n=str.length();
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		
		for(int i=0;i<n;i++)
		{
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
		}
		
		ArrayList<Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		System.out.println(list);
	}
}
