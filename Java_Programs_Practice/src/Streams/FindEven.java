package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindEven {

	public static void main(String[] args) {

		List<Integer> elements=Arrays.asList(89,34,21,22,78,56,24);
		elements.stream().filter(ele->ele%2==0).forEach(System.out::println);
	}
}
