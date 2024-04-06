package Streams;

import java.util.Arrays;
import java.util.List;

import javax.naming.NameNotFoundException;

public class Stream3 {

	public static void main(String[] args) {
		
		List<String> list1 = Arrays.asList("Java","Angular","React JS","Python");
		String firstElement1 = list1.stream()
				.filter(str -> str.startsWith("R"))
				.findAny()
				.get();
		System.out.println(firstElement1);
		
		List<String> list2 = Arrays.asList("Java","Angular","React JS","Python");
		String firstElement2 = list2.stream()
				 					.filter(str -> str.contains("A"))
				 					.findFirst()
				 					.orElse(show());
		System.out.println(firstElement2);
		
		List<String> list3 = Arrays.asList("Java","Angular","React JS","Python");
		String firstElement3 = list3.stream()
				 					.filter(str -> str.contains("A"))
				 					.findFirst()
				 					.orElseGet(()->show());
		System.out.println(firstElement3);
		
		List<String> list4= Arrays.asList("Java","Angular","React JS","Python");
		list4.stream().filter(str -> str.contains("Y"))
				 					.findFirst()
				 					.orElseThrow(()->new NotFoundException("Not Found"));
		
		System.out.println();
		
	}

	private static String show() {
		
		System.out.println("Show Called");
		return "Hello";
	}
}
