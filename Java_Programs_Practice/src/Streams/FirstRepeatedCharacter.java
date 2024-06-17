package Streams;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedCharacter {

	public static void main(String[] args) {
		
		String input = "Java articles are Awesome";
		
		Character firstChar = input.chars()
			 .mapToObj(c->Character.toLowerCase((char)c))
			 .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
			 .entrySet()
			 .stream()
			 .filter(entry->entry.getValue()>1)
			 .map(entry->entry.getKey())
			 .findFirst()
			 .get();
		
		System.out.println(firstChar);
	}
}
