package Streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingMapValues {

	public static void main(String[] args) {
		
		Map<String,Integer> map=new HashMap<>();
		map.put("A", 20);
		map.put("B", 50);
		map.put("E", 10);
		map.put("C", 11);
		map.put("R", 30);
		map.put("P", 40);
		
		Map<String,Integer> hashMap=map.entrySet().stream()
		.sorted(Map.Entry.comparingByValue())
		.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,
				LinkedHashMap::new));
		System.out.println(hashMap);

	}
}
