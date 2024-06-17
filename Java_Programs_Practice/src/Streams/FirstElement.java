package Streams;

import java.util.Arrays;
import java.util.List;

public class FirstElement {

	public static void main(String[] args) {
		
		List<Integer> elements=Arrays.asList(4,5,8,9,2,1,3,6);
		elements.stream().findFirst().ifPresent(System.out::print);
	}
}
