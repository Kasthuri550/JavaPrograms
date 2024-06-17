package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertListToMap {

	public static void main(String[] args) {
		
		List<Person> list=Arrays.asList(
				new Person("kasthuri",26),
				new Person("abby",26),
				new Person("arun",33),
				new Person("kumar",33),
				new Person("valls",25),
				new Person("Sangi",18));
		
		TreeMap<String, List<Person>> collectMap = list.stream()
		    .collect(Collectors.groupingBy(Person::getName,TreeMap::new,Collectors.toList()));
		    
		collectMap.forEach((key,value)->System.out.println(key+"->"+value));

	}
}
