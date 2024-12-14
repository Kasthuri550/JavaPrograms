package Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateNumbers {

	public static void main(String[] args) {


		List<Integer> elements=Arrays.asList(78,45,12,12,10,3,78,3,1,1,1);

		Set<Integer> collect = elements.stream().filter(e->Collections.frequency(elements, e)>1).collect(Collectors.toSet());
		
		System.out.println(collect);
		
		int max=elements.stream().max((a,b)->a-b).get();
		System.out.println(max);
		
		int min=elements.stream().min((a,b)->a-b).get();
		System.out.println(min);
		
	}
}
