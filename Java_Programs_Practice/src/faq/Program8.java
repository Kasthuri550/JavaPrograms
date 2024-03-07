package faq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Program8 {

	public static void main(String[] args) {
		
		List<String> words=Arrays.asList("i","have","a","sentence","with","technical","words");
		
		Map<Integer, List<String>> collect = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect);
        approach1(words);
	}

	private static void approach1(List<String> words) {
		
		Map<Integer,List<String>> collect=new HashMap<Integer, List<String>>();
		
		for(String word:words)
		{
			int length=word.length();
			if(!collect.containsKey(length))
			{
				collect.put(length,new ArrayList<>());
			}
			collect.get(length).add(word);
		}
		
		System.out.println(collect);
		
	}

}
