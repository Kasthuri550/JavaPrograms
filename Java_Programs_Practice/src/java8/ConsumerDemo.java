package java8;

import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		
		Consumer<Integer> c1=i-> System.out.println(i+" "+i.SIZE);
		c1.accept(4);
		Consumer<Integer> c2=i-> System.out.println(i+" "+i.TYPE);
		c2.accept(10);
		
		c1.andThen(c2).accept(20);

	}
}
