package Streams.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import Streams.Person;

public class Practice6 {

	public static void main(String[] args) {
		
//		Find sum of all elements in a List using streams
		
		List<Integer> list=Arrays.asList(5,3,2,9,1,6,2,3,6);
		int sum1=list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum1);
		int sum2=list.stream().reduce((a,b)->a+b).get();
		System.out.println(sum2);
		
//      Find max element
		
		int max=list.stream().max(Comparator.naturalOrder()).get();
		System.out.println(max);
		
//	    Count number of strings that start with a specific character
		
		List<String> fruits=Arrays.asList("cherry","banana","coconut","berry","cantaloupe");
		long count=fruits.stream().filter(fruit->fruit.startsWith("c")).count();
		System.out.println(count);
		
//		Convert to Uppercase
		
		List<String> fruitsList = fruits.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(fruitsList);
		
//		Filter out even numbers and count it
		
		long evenCount = list.stream().filter(num->num%2==0).count();
		System.out.println(evenCount);
		
//		Find the average of a list of floating point numbers
		
		List<Double> floatNums=Arrays.asList(1.2,1.4,1.5,1.7);
		double average = floatNums.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
		System.out.println(average);
		
//		Concatenate all the Strings
		
		String concatenatedString=fruits.stream().collect(Collectors.joining());
		System.out.println(concatenatedString);
		
//		To remove duplicate elements
		
		list.stream().distinct().forEach(System.out::println);
		List<Integer> collectList = list.stream().filter(e->Collections.frequency(list,e)==1).collect(Collectors.toList());
		System.out.println(collectList);
		
//		Sort objects based on specific attribute
		
		List<Person> people=Arrays.asList(new Person("Kasthuri",26),new Person("Alice",21),
				new Person("Anna",29),
				new Person("Bob",30),
				new Person("Barbie",56),
				new Person("Charlie",20));
		
//		Collections.sort(people);
//		System.out.println(people);
		
//		Collections.sort(people,Comparator.comparing(Person::getAge));
//		System.out.println(people);
		
//		Collections.sort(people,(p1,p2)->p1.getAge()-p2.getAge());
//		Collections.sort(people,(p1,p2)->p1.getName().compareTo(p2.getName()));
//		Collections.sort(people,(p1,p2)->{return -1;});
//		Collections.sort(people,(p1,p2)->{return 1;});
//		Collections.sort(people,(p1,p2)->{return 0;});
//		System.out.println(people);
		
//		people.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
		
//		people.stream().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(System.out::println);
		
//		people.stream().sorted((p1,p2)->p1.getAge()-p2.getAge()).forEach(System.out::println);
		
//		people.stream().sorted((p1,p2)->-(p1.getAge()-p2.getAge())).forEach(System.out::println);
		
//		people.stream().sorted((p1,p2)->p2.getAge()-p1.getAge()).forEach(System.out::println);
		
//		All elements in a list satisfy given condition
		
		System.out.println(list.stream().allMatch(e->e%2==0));
		System.out.println(list.stream().anyMatch(e->e%2==0));
		System.out.println(list.stream().noneMatch(e->e%10==0));
		
	}
}
