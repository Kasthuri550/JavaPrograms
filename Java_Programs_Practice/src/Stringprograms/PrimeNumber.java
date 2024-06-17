package Stringprograms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {

	public static void main(String[] args) {
		
		 List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 17, 19, 20);
		 
		 List<Integer> collectList = numbers.stream()
		 		.filter(PrimeNumber::isPrime)
		 		.collect(Collectors.toList());
		 System.out.println(collectList);
	}
	
	private static boolean isPrime(int number)
	{
		if(number<=1) return false;
		
		return IntStream.rangeClosed(2,(int)Math.sqrt(number))
						.allMatch(n->number%n!=0);
	}
}
