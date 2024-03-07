package Stringprograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortMethod {

	public static void main(String[] args) {
		
		Integer numbers[]= {9,4,2,1,0,8,6,7};
//		Arrays.sort(numbers);
//		System.out.println("Ascending Order: "+Arrays.toString(numbers));
//		Arrays.sort(numbers,(a,b) -> Integer.compare(b, a));
//		System.out.println("Descending order: "+Arrays.toString(numbers));
		String names[]= {"Kasthuri","Abby","Arun","Kumar"};
//		Arrays.sort(names);
//		System.out.println("Ascending order: "+Arrays.toString(names));
//		Arrays.sort(names,Comparator.reverseOrder());
//		System.out.println("Descending order: "+Arrays.toString(names));
//		Arrays.sort(names,Collections.reverseOrder());
//		System.out.println("Descending order: "+Arrays.toString(names));
//		Arrays.sort(names);
//		Collections.reverse(Arrays.asList(names));
//		System.out.println("Descending order: "+Arrays.toString(names));
		Arrays.sort(names,(x,y) -> y.compareTo(x));
		System.out.println("Descending order: "+Arrays.toString(names));
		Arrays.sort(names,Comparator.comparingInt(String::length));
		System.out.println("Sort based on length: "+Arrays.toString(names));
	}

}
