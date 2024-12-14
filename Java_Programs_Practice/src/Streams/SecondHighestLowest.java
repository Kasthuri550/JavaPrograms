package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighestLowest {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(5,4,2,1,7,9,6,3,3);

		int secondLowest = list.stream().sorted().distinct().skip(1).findFirst().get();
		System.out.println(secondLowest);
		
		int secondHighest=list.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().get();
		System.out.println(secondHighest);
		
	}

}
