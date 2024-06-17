package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LimitSkip {

	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(6,9,7,4,3,0,2,1);
		
		List<Integer> collectList = list.stream().limit(5).collect(Collectors.toList());
		System.out.println(collectList);
		
		Optional<Integer> sumList = list.stream().limit(5).reduce((n1,n2)->n1+n2);
		System.out.println(sumList.get());
		
		List<Integer> collect = list.stream().limit(list.size()-5).collect(Collectors.toList());
		System.out.println(collect);
		
		List<Integer> skipList = list.stream().skip(5).collect(Collectors.toList());
		System.out.println(skipList);
		
		List<Integer> skipEle = list.stream().skip(list.size()-5).collect(Collectors.toList());
		System.out.println(skipEle);
		
		Optional<Integer> reduce = list.stream().skip(list.size()-5).reduce((n1,n2)->n1+n2);
		System.out.println(reduce.get());
	}
}
