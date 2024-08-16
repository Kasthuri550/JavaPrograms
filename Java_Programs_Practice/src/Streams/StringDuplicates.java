package Streams;

import java.util.Map;
import java.util.stream.Collectors;

public class StringDuplicates {

	public static void main(String[] args) {
		
		String str="kasthuri sathyamoorthy";
		
		Map<Character, Long> charCount = str.chars().mapToObj(c -> (char)c)
		.collect(Collectors.groupingBy(c-> c,Collectors.counting()));
		
		charCount.entrySet()
				 .stream()
				 .filter(freq -> freq.getValue()>1)
				 .map(val->val.getKey())
				 .forEach(System.out::println);
//		charCount.forEach((character,frequency) ->{
//			
//			if(frequency>1)
//			{
//				System.out.println(character+" "+frequency);
//			}
//		});

	}
}
