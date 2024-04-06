package Stringprograms.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilteredMapExample {

	public static void main(String[] args) {
		
		Map<Integer,String> fruitsMap=new HashMap<>();
		fruitsMap.put(1, "Apple");
		fruitsMap.put(2, "Orange");
		fruitsMap.put(3, "Lemon");
		fruitsMap.put(4, "PineApple");
		
		Map<Integer, String> resultedMap = fruitsMap.entrySet().stream()
		.filter(fruits -> fruits.getKey()>1)
		.collect(Collectors.toMap(k -> k.getKey(),v -> v.getValue()));
		System.out.println(resultedMap);
		
	}
}
