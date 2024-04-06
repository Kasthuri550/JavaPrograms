package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SumNumbers {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(3,4,5,2,1);
		Integer sum = nums.stream().reduce(0, (a,b)->a+b);
		System.out.println(sum);
		
	}
}
