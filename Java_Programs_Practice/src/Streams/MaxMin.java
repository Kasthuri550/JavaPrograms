package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxMin {

	public static void main(String[] args) {

		List<Integer> list=Arrays.asList(34,19,23,10,94,32);
		
		Integer max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(max);
		
		Integer min = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(min);
	}

}
