package Streams;

import java.util.Arrays;
import java.util.List;

public class MaximumElement {

	public static void main(String[] args) {
		
		List<Integer> elements=Arrays.asList(89,54,22,12,90,45);
		Integer max = elements.stream().max(Integer::compare).get();
		System.out.println(max);
	}
}
