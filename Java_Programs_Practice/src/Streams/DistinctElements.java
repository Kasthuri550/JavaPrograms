package Streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DistinctElements {

	public static void main(String[] args) {
		
		int nums[]= {3,4,4,1,1,2,9,7};
		Set<Integer> set=new HashSet<>();
		List<Integer> collectList = Arrays.stream(nums).boxed().filter(ele->set.add(ele)).collect(Collectors.toList());
		System.out.println(collectList);
		List<Integer> distinctList = Arrays.stream(nums).boxed().distinct().collect(Collectors.toList());
		System.out.println(distinctList);
	}
}
