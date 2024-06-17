package Streams;

import java.util.Arrays;
import java.util.List;

public class TotalNumberOfElements {

	public static void main(String[] args) {
		
		List<Integer> elements=Arrays.asList(34,21,89,45,39,10,12);
		long count = elements.stream().count();
		System.out.println(count);
	}
}
