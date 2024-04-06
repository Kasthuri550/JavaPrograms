package Streams;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {

	public static void main(String[] args) {
		
		String originalString="kasthuri sathyamoorthy";
		
		BiFunction<String, Character,String> accumulator=new BiFunction<String, Character, String>() {

			@Override
			public String apply(String t, Character u) {
				return u+t;
			}
		};
		
		BinaryOperator<String> combiner=new BinaryOperator<String>() {

			@Override
			public String apply(String t, String u) {
				return u+t;
			}
		};
		String reversedString=originalString.chars().mapToObj(c -> (char)c)
				.reduce("", accumulator, combiner);
		
		System.out.println(reversedString);
		
		String reversed=originalString.chars().mapToObj(c->(char)c)
				.reduce("",(a,b)-> b+a,(a,b)->b+a);
		
		System.out.println(reversed);
		
		String reverseStr = Stream.of(originalString).map(str -> new StringBuilder(str).reverse())
		.collect(Collectors.joining());
		
		System.out.println(reverseStr);
			
	}
}
