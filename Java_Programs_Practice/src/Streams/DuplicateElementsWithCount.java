package Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateElementsWithCount {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		
		names.stream()
		     .filter(ele->Collections.frequency(names,ele)>1)
		     .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		     .entrySet()
		     .stream()
		     .forEach(entry->System.out.println(entry));
		     

	}
}
