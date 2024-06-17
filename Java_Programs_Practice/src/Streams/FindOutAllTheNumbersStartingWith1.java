package Streams;

import java.util.Arrays;
import java.util.List;

public class FindOutAllTheNumbersStartingWith1 {

	public static void main(String[] args) {
		
		List<Integer> elements=Arrays.asList(89,34,21,22,78,56,24);
		elements.stream().map(s->s+"").filter(s->s.startsWith("2")).forEach(System.out::println);

	}
}
