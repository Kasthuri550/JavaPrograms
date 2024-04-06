package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(5);
        integerArrayList.add(20);
        integerArrayList.add(9);
        integerArrayList.add(40);
        integerArrayList.add(15);
        integerArrayList.add(60);

        System.out.println(integerArrayList);

        List<Integer> evenCollector = integerArrayList.stream()
                                        .filter(i->i%2==0)
                                        .map(i->i+5)
                                        .collect(Collectors.toList());
        
        System.out.println(evenCollector);
        
        List<Integer> collect = integerArrayList.stream().filter(i-> i>10).sorted().collect(Collectors.toList());
        System.out.println(collect);
        
        long count = integerArrayList.stream().filter(i->i%2==1).count();
        System.out.println(count);
        
        List<Integer> collect2 = integerArrayList.stream().sorted((c1,c2)->(c1<c2)?1:(c1>c2)?-1:0).collect(Collectors.toList());
        
        System.out.println(collect2);
	}
}
