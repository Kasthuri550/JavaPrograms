package Streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountEachCharacterString {

	public static void main(String[] args) {
		
		String s="kasthuri abby";
		
		approachI(s);
		approachII(s);

	}

	private static void approachII(String s) {
		
		LinkedHashMap<String, Long> collectMap = Arrays.stream(s.split(""))
			  .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		System.out.println(collectMap);
	}

	private static void approachI(String s) 
	{
		LinkedHashMap<Character, Long> collectMap = s.chars()
		 .mapToObj(c->(char)c)
		 .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		
		System.out.println(collectMap);
	}
}
