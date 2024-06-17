package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountElements {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		
		Map<String, Long> collectList = names.stream().collect(Collectors.groupingBy(Function.identity(),TreeMap<String,Long>::new,Collectors.counting()));
		System.out.println(collectList);
	}
}
