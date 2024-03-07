package java8;

import java.util.Optional;

public class OptionalClass {

	public static void main(String[] args) {

		Optional<Integer> opt=Optional.empty();
		System.out.println(opt);
		Optional<Integer> opt1=Optional.of(10);
		System.out.println(opt1);
	}

}
