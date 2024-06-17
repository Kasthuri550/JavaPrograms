package Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateElements {

	public static void main(String[] args) {
		
		List<Integer> elements=Arrays.asList(78,45,12,12,10,3,78,3,1,1,1);
		
		ApproachI(elements);
		ApproachII(elements);
		approachIII(elements);
	}

	private static void approachIII(List<Integer> elements) {
		
		Set<Integer> collectSet = elements.stream()
				.filter(e->Collections.frequency(elements,e)>1)
				.collect(Collectors.toSet());
		
		System.out.println(collectSet);
		
	}

	private static void ApproachII(List<Integer> elements) {
		
		List<Integer> collectList = elements.stream()
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry->entry.getValue()>1)
				.map(entry->entry.getKey())
				.collect(Collectors.toList());
		System.out.println(collectList);
	}

	private static void ApproachI(List<Integer> elements) {
		Set<Integer> set=new HashSet<Integer>();
		
		Set<Integer> collect = elements.stream().filter(ele -> !set.add(ele)).collect(Collectors.toSet());
		System.out.println(collect);
	}
}
