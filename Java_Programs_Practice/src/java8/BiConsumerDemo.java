package java8;

import java.util.function.BiConsumer;

public class BiConsumerDemo {

	public static void main(String[] args) {
		
		BiConsumer<Integer,Integer> c=(x,y)-> System.out.println(x+y);
		c.accept(10,20);
	}
}
