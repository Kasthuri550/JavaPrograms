package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {

	public static void main(String[] args) {

		List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,4,2,9);
		
		List<Integer> list=numbers.stream()
		       .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		       .entrySet()
		       .stream()
		       .filter(value->value.getValue()>1)
		       .map(key->key.getKey())
		       .collect(Collectors.toList());
		
		System.out.println(list);
	}
}
