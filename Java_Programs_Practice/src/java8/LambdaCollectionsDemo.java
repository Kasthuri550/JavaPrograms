package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyComparator implements Comparator<Integer>
{
	@Override
	public int compare(Integer o1, Integer o2) {
		
		if(o1<o2)
		{
			return -1;
		}
		else if(o1>o2)
		{
			return 1;
		}
		return 0;
	}
}
public class LambdaCollectionsDemo {

	public static void main(String[] args) {
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(89);
		al.add(34);
		al.add(23);
		al.add(11);
		al.add(76);
		System.out.println(al);
		Comparator<Integer> c=(o1,o2)-> (o1<o2)?-1:(o1>o2)?1:0;
		Collections.sort(al,new MyComparator());
		System.out.println(al);
	}
}
