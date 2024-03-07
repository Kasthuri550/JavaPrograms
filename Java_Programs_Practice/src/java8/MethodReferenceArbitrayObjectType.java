package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
class Sum
{
	public int  doSum(int x)
	{
		return x;
	}
}

public class MethodReferenceArbitrayObjectType {

	public static void main(String[] args) {

		List<String> personList = new ArrayList<>();
		 
        personList.add("vicky");
        personList.add("poonam");
        personList.add("sachin");
 
        Collections.sort(personList,String::compareToIgnoreCase);
 
        personList.forEach(System.out::println);
        
        BiFunction<Sum,Integer,Integer> f=Sum::doSum;
        Integer apply = f.apply(new Sum(), 10);
        System.out.println(apply);
        
        
	}
}
