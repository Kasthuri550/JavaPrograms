package java8;

import java.util.function.BiPredicate;

public class BiPredicateDemo {

	public static void main(String[] args) {
		
		BiPredicate<Integer,Integer> b=(x,y)-> (x+y)%2==0;
		System.out.println(b.test(10,10)+" "+b.test(20,25));
	}
}
