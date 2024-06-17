package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenOdd {

	public static void main(String[] args) {

		List<Integer> list=Arrays.asList(2,2,4,5,1,9,8,7,1,9);
		
		List<Integer> even = list.stream().filter(e->e%2==0).collect(Collectors.toList());
		System.out.println(even);
		
		List<Integer> odd=list.stream().filter(e->e%2==1).collect(Collectors.toList());
		System.out.println(odd);
	}

}
