package Stringprograms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestAndSmallestNumber {

	public static void main(String[] args) {
		
		String nums[]= {"34","4","12","90","233"};
		
		largest(nums);
		smallest(nums);

	}

	private static void smallest(String[] nums) {
		
		Arrays.sort(nums,(num1,num2)->(num1+num2).compareTo(num2+num1));
		
		String concat = String.join("", nums);
		System.out.println(concat);
		
		List<Character> collect = "kasthuri sathyamoorthy".chars().mapToObj(c->(char)c)
		.distinct().collect(Collectors.toList());
		System.out.println(collect);
		
	}

	private static void largest(String[] nums) {
		
		Arrays.sort(nums,(num1,num2)->(num2+num1).compareTo(num1+num2));
		
		String concat = String.join("", nums);
		System.out.println(concat);
		
	}
}
