package Streams;

import java.util.Arrays;
import java.util.List;

public class Average {

	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(2,2,4,5,1,9,8,7,1,9);
		double average = list.stream().mapToInt(Integer::valueOf).average().getAsDouble();
		System.out.println(average);

	}
}
