package Streams.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import Streams.chapter4.Student;

public class Practice7 {

	public static void main(String[] args) {

		String sentence="Java is a programming language. Java is versatile.";

		//		Frequency of each word
		Map<String,Long> freqMap=Arrays.stream(sentence.split("\\s")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(freqMap);

		//		Find out all the numbers starting with 1

		List<Integer> nums=Arrays.asList(12,13,18,21,90,11);

		//		List<Integer> collectNumsList = nums.stream().map(String::valueOf).filter(e->e.startsWith("1")).map(Integer::valueOf).collect(Collectors.toList());
		List<Integer> collectNumsList = nums.stream().filter(e->String.valueOf(e).startsWith("1")).collect(Collectors.toList());
		System.out.println(collectNumsList);

		//		Given a list of names, group them by their first letter, and then count the number of names in each group

		String names[]= {"cherry","banana","coconut","berry","cantaloupe"};

		Map<Character,Long> freqCharMap=Arrays.stream(names).collect(Collectors.groupingBy(s->s.charAt(0),Collectors.counting()));
		System.out.println(freqCharMap);

		//		Find and print duplicate numbers in an array if it contains multiple duplicates

		int[] arr= {2,4,2,3,1,5,5,78,3,1,5};

		Map<Integer, Long> arrMap = Arrays.stream(arr).boxed().
				collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

		List<Integer> duplicateList = arrMap.entrySet().stream().filter(entry->entry.getValue()>1)
				.map(Map.Entry::getKey).collect(Collectors.toList());

		System.out.println(duplicateList);

		//		Remove duplicates from a given array

		int[] distinctArray = Arrays.stream(arr).distinct().toArray();

		System.out.println(Arrays.toString(distinctArray));

		//		Filter and print palindromes

		List<String> strings=Arrays.asList("level","hello","radar","world","deed");

		List<String> palindromeList = strings.stream().filter(str->str.equals(new StringBuilder(str).reverse().toString())).collect(Collectors.toList());
		System.out.println(palindromeList);

		//		Merge two sorted arrays into single sorted arrays

		int array1[]= {1,3,5,7};
		int array2[]= {2,4,6,8};

		int[] sortedArray = IntStream.concat(Arrays.stream(array1),Arrays.stream(array2)).sorted().toArray();
		System.out.println(Arrays.toString(sortedArray));

		//		Concat two lists and remove duplicates

		List<String> list1=Arrays.asList("apple","banana","orange");
		List<String> list2=Arrays.asList("banana","kiwi","grape");

		List<String> concatList = Stream.concat(list1.stream(),list2.stream()).distinct().collect(Collectors.toList());
		System.out.println(concatList);

		//		Student grade classification - 70 and above pass

		List<Student> students=Arrays.asList(new Student("Alice",85),
				new Student("Bob",60),
				new Student("Charlie",71),
				new Student("David", 90));

		Map<String,List<Student>> classifiedStudent=students.stream().collect(Collectors.groupingBy(student->student.getAge()>=70?"Pass":"Fail"));
		System.out.println(classifiedStudent);

		//		sort according to increasing order

		List<String> fruitsBasket=Arrays.asList("Mango","Pear","Banana","Pineapple","Kiwi");
		//		List<String> collectFruits = fruitsBasket.stream().sorted((s1,s2)->s2.length()-s1.length()).collect(Collectors.toList());
		List<String> collectFruits = fruitsBasket.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
		System.out.println(collectFruits);

		//		Partition a list of numbers into two groups: even and odd, using a custom predicate.
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Map<Boolean, List<Integer>> collectPartition = numbers1.stream().collect(Collectors.partitioningBy(num->num%2==0));
		System.out.println(collectPartition);

		// Find the squares of the first three even numbers in a list.

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> collectSquares = numbers.stream().filter(num->num%2==0).limit(3).map(number->number*number).collect(Collectors.toList());
		System.out.println(collectSquares);

		// Flatten a list of lists

		List<List<Integer>> listOfList=Arrays.asList(Arrays.asList(1,3),Arrays.asList(8,2),Arrays.asList(9,6));
		List<Integer> flattenedList = listOfList.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(flattenedList);

		// Flatten a array of array
		int[][] array = { {1, 2, 3}, {4, 5}, {6, 7, 8, 9} };

		int[] flatArray = Arrays.stream(array).flatMapToInt(Arrays::stream).toArray();
		System.out.println(Arrays.toString(flatArray));

		//		Array Intersection

		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {4, 5, 6, 7, 8};
		
		Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
		
		int[] intersectedArray = Arrays.stream(arr2).filter(set::contains).toArray();
		System.out.println(Arrays.toString(intersectedArray));
		
//		Reverse each word
		
		String input="Hello Java World";
		
		String reverseWord = Stream.of(input.split("\\s")).map(str->new StringBuilder(str).reverse().toString()).collect(Collectors.joining(" "));
		System.out.println(reverseWord);
		
//		Group by length
		
		System.out.println(fruitsBasket.stream().collect(Collectors.groupingBy(String::length)));
		
		String[] split = input.split("");
		System.out.println(Arrays.toString(split));
	}
}
