package java8;

import java.util.function.*;

public class FunctionDemo {

	public static void main(String[] args) {
		
		Function<Integer,Integer> f1=i -> i+1;
		Function<Integer,Integer> f2=i -> i*3;
		
		System.out.println(f1.andThen(f2).apply(3));
		System.out.println(f1.compose(f2).apply(4));
		System.out.println(Function.identity().apply("Hello"));
		System.out.println(f1.apply(5));
	}

}
