package Streams;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		
		String input = "Java articles are Awesome";
		
		Character findFirstChar = input.chars()
			 .mapToObj(c->Character.toLowerCase((char)c))
			 .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
			 .entrySet()
			 .stream()
			 .filter(entry->entry.getValue()==1)
			 .map(entry->entry.getKey())
			 .findFirst()
			 .get();
		
		System.out.println(findFirstChar);
	}
}
