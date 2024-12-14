package Streams;

import java.util.stream.Stream;

public class CountCharacter {

	public static void main(String[] args) {

		String name="Kasthuri Arun Kumar";

		approach1(name);

		approach2(name);


	}

	private static void approach2(String name) {
		
//		char charArray[]=name.toCharArray();
//		Stream.of(charArray).filter(c-> c=='a').count();
	}

	private static void approach1(String name) {
		
		long count=name.chars().mapToObj(c->(char)c).filter(c->c=='a').count();
		System.out.println(count);
	}
}
