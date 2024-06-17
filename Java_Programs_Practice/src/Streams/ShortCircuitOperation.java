package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShortCircuitOperation {

	public static void main(String[] args) {
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(20);
		al.add(35);
		al.add(87);
		al.add(71);
		al.add(63);
		
		Optional<Integer> findFirst = al.stream().findFirst();
		System.out.println(findFirst.get());
		
		Optional<Integer> findAny = al.stream().findAny();
		System.out.println(findAny.get());
		
		List<Integer> collectList = al.stream().skip(2).collect(Collectors.toList());
		
		System.out.println(collectList);
		
		List<Integer> collectLimit = al.stream().limit(2).collect(Collectors.toList());
		System.out.println(collectLimit);
		
		
		boolean allMatch = al.stream().allMatch(x->x%2==0);
		System.out.println(allMatch);
		
		boolean anyMatch = al.stream().anyMatch(x->x>50);
		System.out.println(anyMatch);
		
		boolean noneMatch = al.stream().noneMatch(x->x<100);
		System.out.println(noneMatch);
		
		al.stream().parallel().forEach(System.out::println);
		al.stream().parallel().forEachOrdered(System.out::println);
	}
}
