package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {

	public static void main(String[] args) {
		
		List<String> stringList=new ArrayList<>();
		stringList.add("AAA");
		stringList.add("AA");
		stringList.add("YY");
		stringList.add("HHHH");
		
		Comparator<String> comparator=new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				int strLen1=o1.length();
				int strLen2=o2.length();
				
				if(strLen1<strLen2)
				{
					return -1;
				}
				else if(strLen1>strLen2)
				{
					return 1;
				}
				else
				{
				return o1.compareTo(o2);
				}
			}
		};
				
		List<String> collect = stringList.stream().sorted(comparator).collect(Collectors.toList());
		System.out.println(collect);
		
	
		
	}
}
