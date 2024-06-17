package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CheckListEmptyUsingOptional {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("kasthuri","abby","arun","kumar");
		
		Optional<List<String>> ofNullable = Optional.ofNullable(list);
		ofNullable.ifPresent(lst->{
			if(!lst.isEmpty())
			{
				lst.stream().forEach(System.out::println);
			}
			else
			{
				System.out.println("The list is empty");
			}
		});

	}
}
