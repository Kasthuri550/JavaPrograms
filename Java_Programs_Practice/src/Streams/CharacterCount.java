package Streams;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCount {

	public static void main(String[] args) {

		String str="babca";
		
		characterCount(str);
	}

	private static void characterCount(String str) {

		String output=str.chars().mapToObj(c->(char)c).collect(
				Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
				.entrySet().stream()
				.map(entry-> entry.getKey()+""+entry.getValue()).collect(Collectors.joining());
		
		System.out.println(output);
	}

}
