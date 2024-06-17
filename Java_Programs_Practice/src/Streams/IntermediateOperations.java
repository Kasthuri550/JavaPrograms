package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperations {

	public static void main(String[] args) {
		
		ArrayList<Integer> al=new ArrayList<Integer>() {
			
			private static final long serialVersionUID = 1L;

		{
			add(30);
			add(10);
			add(21);
			add(21);
		}};
		List<Integer> collectList = al.stream().filter(i->i%2==0).collect(Collectors.toList());
		
		List<Integer> collectDistinct = al.stream().map(i-> i+5).distinct().sorted().collect(Collectors.toList());
		
		System.out.println(collectDistinct);
		
		System.out.println(collectList);
	}
}
