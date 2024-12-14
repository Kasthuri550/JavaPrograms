package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseList {

	public static void main(String[] args) {

		List<Integer> list=Arrays.asList(2,3,5,7,9);
		
		List<Integer> resultList = list.stream().sorted((a,b)->{ return -1;}).collect(Collectors.toList());
		
		System.out.println(resultList);
	}
}
