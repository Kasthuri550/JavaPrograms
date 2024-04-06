package Streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExample {

	public static void main(String[] args) {
		
		int arr[]= {10,9,1,2,3,4,5,6,6,5,4,3,2,1};
		List<Integer> integerList=Arrays.asList(3,4,5,5,1,2,8);
		
		
		IntStream intStream1 = IntStream.of(arr);
		System.out.println(intStream1.summaryStatistics().getSum());
		
		Stream<Integer> integerStream = integerList.stream();
		integerStream.forEach(System.out::println);
		
		IntStream intStream2 = IntStream.builder().build();
		intStream2.forEach(System.out::println);
		
//		IntStream intStream3=IntStream.range(1, 100);
//		intStream3.forEach(System.out::println);
//		
//		IntStream intStream4=IntStream.rangeClosed(1, 100);
//		intStream4.forEach(System.out::println);
		
		IntStream randomValues = IntStream.generate(()->ThreadLocalRandom.current().nextInt()).limit(3);
		randomValues.forEach(System.out::println);
		
		IntStream intStream5 =  IntStream.of(arr);
		int min = intStream5.min().getAsInt();
		System.out.println(min);
		
		IntStream intStream6=IntStream.of(arr);
		long count = intStream6.count();
		System.out.println(count);
		
		IntStream intStream7=IntStream.of(arr);
		double average = intStream7.average().getAsDouble();
		System.out.println(average);
		
		IntStream intStream8=IntStream.of(arr);
		intStream8.distinct().sorted().forEach(System.out::println);
		
		IntStream intStream9=IntStream.of(arr);
		boolean anyMatch = intStream9.anyMatch(value -> value<=2);
		System.out.println(anyMatch);
		
		IntStream intStream10=IntStream.of(arr);
		System.out.println(intStream10.allMatch(value -> value<=10));
		
		IntStream intStream11=IntStream.of(arr);
		System.out.println(intStream11.noneMatch(value -> value<1));
		
		IntStream intStream12=IntStream.of(arr);
		IntStream filter = intStream12.filter(value -> value%2==0);
		filter.forEach(System.out::println);
		
		IntStream intStream13=IntStream.of(arr);
		intStream13.map(operand -> operand*operand)
				   .forEach(System.out::println);
		
		IntStream intStream14=IntStream.of(arr);
		Stream<Integer> boxed = intStream14.boxed();
		Iterator<Integer> iterator = boxed.iterator();
		
		while(iterator.hasNext())
		{
			System.out.print(iterator.next()+" ");
		}
		
		IntStream intStream15=IntStream.of(arr);
		Stream<String> stringStream = intStream15.mapToObj(value -> "value is "+value);
		Iterator<String> iterator1=stringStream.iterator();
		while(iterator1.hasNext())
		{
			System.out.println(iterator1.next());
		}

	}
}
