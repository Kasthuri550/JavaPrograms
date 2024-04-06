package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Stream2 {

	public static void main(String[] args) {

		ArrayList<Integer> integerArrayList = new ArrayList<>();
		integerArrayList.add(5);
		integerArrayList.add(20);
		integerArrayList.add(9);
		integerArrayList.add(40);
		integerArrayList.add(15);
		integerArrayList.add(60);

		Integer min = integerArrayList.stream().min((i1,i2)->i1.compareTo(i2)).get();
		System.out.println(min);

		Integer max = integerArrayList.stream().max((i1,i2)->i2.compareTo(i1)).get();
		System.out.println(max);

		integerArrayList.forEach(System.out::println);
		Integer[] array = integerArrayList.stream().toArray(Integer[]::new);     
		
		for(int a:array)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		System.out.println("------------------------");
		Integer[] arrayInt = integerArrayList.stream().toArray(Integer[]::new);
		
		Stream.of(arrayInt).forEach(System.out::println);
		

	}
}
