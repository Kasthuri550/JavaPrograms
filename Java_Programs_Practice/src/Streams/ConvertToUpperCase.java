package Streams;

import java.util.Arrays;
import java.util.List;

public class ConvertToUpperCase {

	public static void main(String[] args) {
		
		List<String> names=Arrays.asList("kasthuri","abby","arun","kumar");
		
		names.stream().map(name->name.toUpperCase()).forEach(System.out::println);

	}
}
