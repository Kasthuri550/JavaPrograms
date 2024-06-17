package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperations {

	public static void main(String[] args) {
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(35);
		al.add(87);
		al.add(27);
		al.add(10);
		al.add(20);
		
		al.stream().forEach(System.out::println);
		
		List<Integer> collectList = al.stream().collect(Collectors.toList());
		
		System.out.println(collectList);
		
		Optional<Integer> total = al.stream().reduce((a,b)-> a+b);
		System.out.println(total.get());
		
		String reverse = "Kasthuri".chars().mapToObj(c->(char)c).reduce("",(a,b)->b+a,(a,b)->a+b);
		
		System.out.println(reverse);
		
		long count = al.stream().count();
		System.out.println(count);
		Object[] array = al.stream().toArray();
		System.out.println(Arrays.toString(array));
		
		Optional<Integer> min = al.stream().min((a,b)->a.compareTo(b));
		System.out.println(min.get());
		
		Optional<Integer> max = al.stream().max((x,y)->x.compareTo(y));
		System.out.println(max.get());

	}
}
