package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CubeElementsFilterGT50 {

	public static void main(String[] args) {
		
		List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
		
		List<Integer> collectList = integerList.stream()
				   .map(ele->ele*ele*ele)
				   .filter(ele->ele>50)
				   .collect(Collectors.toList());
		
		System.out.println(collectList);

	}
}
