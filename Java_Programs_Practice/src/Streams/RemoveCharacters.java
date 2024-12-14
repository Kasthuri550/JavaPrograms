package Streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveCharacters {

	public static void main(String[] args) {
		
		String str="jksgjhgjs";
		
		String collect = Stream.of(str.split("")).filter(s->!s.equals("j")).collect(Collectors.joining());
		System.out.println(collect);
	}
}
