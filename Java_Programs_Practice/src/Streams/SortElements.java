package Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortElements {

	public static void main(String[] args) {
		
		List<Integer> elements = Arrays.asList(10,15,8,49,25,98,98,32,15);
		
		elements.stream().sorted().forEach(System.out::println);
		System.out.println("----------");
		elements.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);


	}
}
