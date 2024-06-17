package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondHighestAndLowest {

	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(2,2,4,5,1,9,8,7,1,9);
				
		Integer secondHigh = list.stream()
			.sorted(Collections.reverseOrder())
			.distinct()
			.skip(1)
			.findFirst()
			.get();
		
		System.out.println(secondHigh);
		
		Integer secondLowest = list.stream()
			.sorted()
			.distinct()
			.skip(1)
			.findFirst()
			.get();
		System.out.println(secondLowest);
	}
}
