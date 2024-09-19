package Streams.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import Streams.chapter4.Student;

public class Practice5 {

	public static void main(String[] args) {
		
//		countFrequencyOfEachWord("Java is a programming language. Java is versatile.");
//		integerStartsWith(Arrays.asList(21,33,8,25,9,39));
//		countNamesStartsWith(new String[] {"Alice","Bob","Charlie","Amy","Anna"});
//		removeDuplicates(new int[] {3,4,1,3,4,2,1});
//		findUnique(new int[] {3,4,1,3,4,2,1});
//		printPalindrome(new String[] {"hello","level","sunday","madam","radar"});
//		mergeTwoSortedArrays(new int[] {3,2,4,5,3},new int[] {890,352,1,2,34});
//		mergeTwoList(Arrays.asList("Alice","Bob","Charlie"),Arrays.asList("Amy","Anna","Alice"));
//		studentGrade();
//		sortLength(Arrays.asList("hello","level","sunday","madam","radar"));
//		partitionList();
		Flattenlist();
		flattenArray();
	}

	private static void flattenArray() {
		
		int arr1[][]= {{4,5},{3,2},{9,5},{8,1}};
		
		int[] array = Arrays.stream(arr1).flatMapToInt(Arrays::stream).toArray();
		System.out.println(Arrays.toString(array));
	}

	private static void Flattenlist() {

		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
		List<Integer> collect = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(collect);
	}

	private static void partitionList() {
		
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> collect = numbers1.stream().collect(Collectors.partitioningBy(e->e%2==0));
		System.out.println(collect);
	}

	private static void sortLength(List<String> list) {
		
		list.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
		
	}

	private static void studentGrade() {
		
		List<Student> studentList=Arrays.asList(new Student("Kasthuri",26),
				new Student("Abby",76),
				new Student("Arun",33),
				new Student("Kumar",32));
		
		Map<String, List<Student>> collect = studentList.stream().collect(Collectors.groupingBy(s->s.getAge()>=70?"pass":"fail"));
		System.out.println(collect);
	}

	private static void mergeTwoList(List<String> list1, List<String> list2) {
		
		List<String> collectlist = Stream.concat(list1.stream(),list2.stream()).distinct().collect(Collectors.toList());
		System.out.println(collectlist);
	}

	private static void mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		
		int[] array = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).sorted().toArray();
		System.out.println(Arrays.toString(array));
		
	}

	private static void printPalindrome(String[] strings) {
		
		Arrays.stream(strings).filter(str->str.equals(new StringBuilder(str).reverse().toString()))
		.forEach(System.out::println);
		
	}

	private static void findUnique(int[] is) {
		
		int arr[]=Arrays.stream(is).distinct().toArray();
		System.out.println(Arrays.toString(arr));
		
	}

	private static void removeDuplicates(int[] is) {
		
		Arrays.stream(is).boxed()
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream()
		.filter(e->e.getValue()>1)
		.map(Map.Entry::getKey)
		.forEach(System.out::println);
		
	}

	private static void countNamesStartsWith(String[] strings) {
		
		Map<Character, Long> collect = Arrays.stream(strings).collect(Collectors.groupingBy(s->s.charAt(0),Collectors.counting()));
		System.out.println(collect);
	}

	private static void integerStartsWith(List<Integer> asList) {
		
		asList.stream().filter(e->String.valueOf(e).startsWith("3")).forEach(System.out::println);
		
	}

	private static void countFrequencyOfEachWord(String sentence) {
		
		Map<String, Long> countMap=Arrays.stream(sentence.split("\\s+"))
		.collect(Collectors.groupingBy(String::toLowerCase,Collectors.counting()));
		
		System.out.println(countMap);
		
	}
}
