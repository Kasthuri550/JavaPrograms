package Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondLargestAndSecondLowestNumber {

	public static void main(String[] args) {

		List<Integer> elements=Arrays.asList(78,45,12,12,10,3,78,3,1,1,1);
		
		int min=elements.stream().sorted().distinct().skip(1).findFirst().get();
		System.out.println(min);
		
		int max=elements.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
		System.out.println(max);
	}
}
