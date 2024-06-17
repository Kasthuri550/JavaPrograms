package Streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class ConcatStreams {

	public static void main(String[] args) {
		
		String strs1[]= {"kasthuri","abby"};
		String strs2[]= {"arun","kumar"};
		
		Stream<String> concat = Stream.concat(Arrays.stream(strs1),Arrays.stream(strs2));
		
		concat.forEach(str->System.out.print(str+" "));

	}
}
