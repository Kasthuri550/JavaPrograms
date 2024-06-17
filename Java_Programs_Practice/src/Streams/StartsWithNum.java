package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StartsWithNum {

	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(23,45,78,91,12,93,29,-21);
		
		List<Integer> collectList = list.stream()
		    .map(ele->ele+"")
		    .filter(ele->ele.startsWith("2")||ele.startsWith("-2"))
		    .map(Integer::valueOf)
		    .collect(Collectors.toList());

		System.out.println(collectList);
	}

}
