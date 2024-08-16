package Stringprograms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {
		
		String[][] strings= {{"a","b"},{"c","d"},{"e","f"}};
				
		Stream<String[]> strArrays = Arrays.stream(strings);
		
		Stream<String> strArr = strArrays.flatMap(str->Arrays.stream(str));
		
		List<String> upperCaseCollect = strArr.map(s-> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(upperCaseCollect);
		
		Set<String> fruitsSet=new HashSet<String>();
		fruitsSet.add("Apple");
		fruitsSet.add("Apple");
		fruitsSet.add("Orange");
		fruitsSet.add("Lemon");
		fruitsSet.add("Pine Apple");
		fruitsSet.add("Guava");
		
		Set<String> vegSet=new HashSet<String>();
		vegSet.add("Onion");
		vegSet.add("Tomato");
		vegSet.add("Potato");
		vegSet.add("Beans");
		vegSet.add("Onion");
		vegSet.add("Beetroot");
		
		List<Set<String>> vegList=new ArrayList<Set<String>>();
		vegList.add(fruitsSet);
		vegList.add(vegSet);	
		
		Set<String> vegMatchSet = vegList.stream().flatMap(set -> set.stream())
		.filter(veg->veg.contains("a"))
		.collect(Collectors.toSet());
		
		System.out.println(vegMatchSet);
		
		List<Integer> listNum1=new ArrayList<Integer>();
		listNum1.add(10);
		listNum1.add(50);
		listNum1.add(80);
		
		List<Integer> listNum2=new ArrayList<Integer>();
		listNum2.add(10);
		listNum2.add(50);
		listNum2.add(80);
		
		List<List<Integer>> intList=new ArrayList<List<Integer>>();
		intList.add(listNum1);
		intList.add(listNum2);
		
		intList.stream().flatMapToInt(list -> list.stream().mapToInt(Integer::intValue))
		.map(num -> num+5)
		.forEach(System.out::println);
		
		int array[][]= {{1,2},{3,4},{5,6}};
		
		Arrays.stream(array)
		.flatMapToInt(intArr-> Arrays.stream(intArr))
		.forEach(arr->System.out.print(arr+" "));
		
		long longArray[][]= {{5,4},{3,9}};
		
		Stream.of(longArray)
		.flatMapToLong(longArr-> Arrays.stream(longArr))
		.forEach(longArr-> System.out.print(longArr+" "));
		
		double doubleArray[][]= {{9.3,4.2},{1.2,7.5},{8.4,6.3}};
		
		Stream.of(doubleArray)
		.flatMapToDouble(doubleArr -> Arrays.stream(doubleArr))
		.forEach(ele -> System.out.print(ele+" "));
		
		List<Integer> length = Stream.of("One","Two","Three").map(String::length).collect(Collectors.toList());
		System.out.println(length);
		
		System.out.println("-----------------------------");
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		
		List<Integer> list1=Arrays.asList(3,2,1);
		List<Integer> list2=Arrays.asList(9,6,5);
		List<Integer> list3=Arrays.asList(0,1,3);
		
		list.add(list1);
		list.add(list2);
		list.add(list3);
		
		List<Integer> collect = list.stream().flatMap(listOfList->listOfList.stream()).collect(Collectors.toList());
		System.out.println(collect);
		
		List<Integer> collect2 = Stream.of(3,4,5,1,2,8).map(ele -> ele+5).collect(Collectors.toList());
		System.out.println(collect2);
	}
}
