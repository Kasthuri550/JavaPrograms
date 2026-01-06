package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoveZeroElementToEnd {

	public static void main(String[] args) {

		List<Integer> numbers=Arrays.asList(1,0,-3,0,5,-2,0,8,0,-4);
		
		List<Integer> result=Stream.concat(numbers.stream().filter(n->n!=0),
				numbers.stream().filter(n->n==0)).collect(Collectors.toList());
		
		System.out.println(result);
	}
}
