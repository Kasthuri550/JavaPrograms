package Streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator.OfLong;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LongStreamExample {

	public static void main(String[] args) {

		long arr[]= {34,88,24,12,78};
		
		LongStream longStream1= LongStream.of(5,3,4,2,8,9);
		longStream1.forEach(System.out::print);
		
		LongStream longStream2=LongStream.empty();
		
		LongStream longStream3=LongStream.of(8,9,4,5,6);
		
		LongStream longStream4=LongStream.concat(longStream2, longStream3);
		List<Long> collect = longStream4.boxed().collect(Collectors.toList());
		System.out.println(collect);
		
		LongStream.Builder longStream5=LongStream.builder();
		longStream5.add(32);
		longStream5.add(98);
		longStream5.add(78);
		longStream5.add(56);
		longStream5.add(34);
		
		List<Long> collect2 = longStream5.build().boxed().collect(Collectors.toList());
		
		System.out.println(collect2);
		
		LongStream longStream6 = LongStream.generate(()-> ThreadLocalRandom.current().nextLong()).limit(5);
		ArrayList<Long> collect3 = longStream6.collect(ArrayList<Long>::new,(list,l)->list.add(l),(list1,list2)->list1.addAll(list2));
		System.out.println(collect3);
		
		LongStream longStream7 = LongStream.range(100,130);
		Iterator<Long> iterator = longStream7.iterator();
		
		while(iterator.hasNext())
		{
			System.out.print(iterator.next()+" ");
		}
		
		boolean allMatch = LongStream.of(arr).allMatch(a-> a%2==0);		
		System.out.println(allMatch);
		
		boolean anyMatch = LongStream.of(arr).anyMatch(a-> a<20);
		System.out.println(anyMatch);
				
	}
}
