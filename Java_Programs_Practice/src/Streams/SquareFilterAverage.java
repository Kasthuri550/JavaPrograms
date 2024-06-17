package Streams;

import java.util.Arrays;
import java.util.List;

public class SquareFilterAverage {

	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(2,2,4,5,1,9,8,7,1,9);
		
		double sfa = list.stream()
			.map(e->e*e)
			.filter(e->e>5)
			.mapToInt(Integer::valueOf)
			.average()
			.getAsDouble();
		System.out.println(sfa);
	}

}
