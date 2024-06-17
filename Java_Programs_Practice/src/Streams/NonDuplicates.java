package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonDuplicates {

	public static void main(String[] args) {

		List<Integer> elements=Arrays.asList(78,45,12,12,10,3,78,3,1,1);
		List<Integer> collectList = elements.stream()
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry->entry.getValue()==1)
				.map(entry->entry.getKey())
				.collect(Collectors.toList());
		
		System.out.println(collectList);
	}
}
