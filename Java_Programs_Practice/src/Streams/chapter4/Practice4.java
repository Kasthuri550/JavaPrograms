package Streams.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Practice4 {

	public static void main(String[] args) {
		
		List<Integer> numsList=Arrays.asList(1,2,3,4,5);
		
//		listSum(numsList);
//		maxElement(numsList);
//		countStringsThatStartsWithSpecificChar(Arrays.asList("Cherry","Banana","Coconut","Cantalouple"));
//		changeToUpperCase(Arrays.asList("Cherry","Banana","Coconut","Cantalouple"));
//		evenCount(numsList);
//		findAverage(Arrays.asList(1.3,4.5,7.8));
//		concatenateDelimiterInStrings(Arrays.asList("Cherry","Banana","Coconut","Cantalouple"));
//		uniqueElements(Arrays.asList(1,2,3,2,3,1,4,4,5));
		sortStudent();
	}

	private static void sortStudent() {
		
		List<Student> studentList=Arrays.asList(new Student("Kasthuri",26),
				new Student("Abby",16),
				new Student("Arun",33),
				new Student("Kumar",32));
		
//		Collections.sort(studentList,Comparator.comparing(Student::getAge));
//		
//		studentList.forEach(student->{
//			System.out.println(student);
//		});
		
		studentList.stream().sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
		
		boolean allMatch = studentList.stream().allMatch(student->student.getAge()<18);
		System.out.println(allMatch);
		boolean anyMatch = studentList.stream().anyMatch(student->student.getAge()<18);
		System.out.println(anyMatch);
		
	}

	private static void uniqueElements(List<Integer> asList) {
		
		asList.stream().distinct().forEach(System.out::println);
		
	}

	private static void concatenateDelimiterInStrings(List<String> asList) {
		
		String collect = asList.stream().collect(Collectors.joining(","));
		System.out.println(collect);
	}

	private static void findAverage(List<Double> numsList) {
		
		double average=numsList.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
		System.out.println(average);
	}

	private static void evenCount(List<Integer> numsList) {
		
		long count = numsList.stream().filter(num->num%2==0).count();
		System.out.println(count);
	}

	private static void changeToUpperCase(List<String> asList) {
		
		asList.stream().map(String::toUpperCase).forEach(System.out::println);
		
	}

	private static void countStringsThatStartsWithSpecificChar(List<String> asList) {
		
		long count = asList.stream().filter(e->e.startsWith("C")).count();
		System.out.println(count);
	}

	private static void maxElement(List<Integer> numsList) {
		
		Integer max = numsList.stream().max(Comparator.naturalOrder()).get();
		System.out.println(max);
	}

	private static void listSum(List<Integer> numsList) {
		
		int totalSum = numsList.stream().mapToInt(Integer::intValue).sum();
		
		System.out.println(totalSum);
	}
}
