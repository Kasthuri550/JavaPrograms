package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class DoubleStreamExample {

	public static void main(String[] args) {
		
		double array[]= {9.3,4.5,8.3,1.1,1.2,1.3,1.4};
		
		DoubleStream doubleStream1 = DoubleStream.of(array);
		
		ObjDoubleConsumer<List<Double>> objDoubleConsumer=new ObjDoubleConsumer<List<Double>>() {

			@Override
			public void accept(List<Double> t, double value) {
				
				t.add(value);
				
			}	
		};
		
		BiConsumer<List<Double>,List<Double>> biConsumer=new BiConsumer<List<Double>, List<Double>>() {

			@Override
			public void accept(List<Double> t, List<Double> u) {
				t.addAll(u);
				
			}
		};
		
		List<Double> collect = doubleStream1.collect(ArrayList<Double>::new, objDoubleConsumer, biConsumer);
		System.out.println(collect);
		
		DoubleStream doubleStream3=DoubleStream.of(3.4,2.5,9.8,7.8,5.4);
		DoubleStream doubleStream2=DoubleStream.empty();
		
		DoubleStream concatenatedStream =DoubleStream.concat(doubleStream2,doubleStream3);
		List<Double> collect2 = concatenatedStream.boxed().collect(Collectors.toList());
		System.out.println(collect2);
		
		DoubleStream.Builder doubleStream4 = DoubleStream.builder();
		
		doubleStream4.add(4.5);
		doubleStream4.add(3.7);
		doubleStream4.add(2.9);
		doubleStream4.add(5.8);
		
		doubleStream4.build().forEach(ele -> System.out.print(ele+" "));
		
		DoubleStream doubleStream5=DoubleStream.generate(()-> (int)(Math.random()*10)).limit(5);
		doubleStream5.forEach(System.out::println);
		
		DoubleStream.Builder doubleStream6=DoubleStream.builder();
		doubleStream6.add(3.8);
		doubleStream6.add(8.9);
		doubleStream6.add(7.8);
		doubleStream6.add(2.9);
		doubleStream6.add(1.8);
		
//		System.out.println(doubleStream6.build().findFirst().getAsDouble());
//		System.out.println(doubleStream6.build().findAny().getAsDouble());
		System.out.println();
//		doubleStream6.build().skip(2).forEach(System.out::println);
		doubleStream6.build().limit(3).forEach(System.out::println);
		List<Integer> sum = DoubleStream.of(array).mapToInt(arr->(int)arr+5).boxed().collect(Collectors.toList());
		System.out.println(sum);
	}
}
