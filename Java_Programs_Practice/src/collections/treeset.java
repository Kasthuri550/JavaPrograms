package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class treeset {

	public static void main(String[] args) {
		
		TreeSet set1=new TreeSet();
		set1.add(30);
		set1.add(40);
		set1.add(10);
//		set.add("K");
//		set.add(null);
		System.out.println(set1);
		
//		TreeSet set2=new TreeSet();
//		set2.add(new StringBuffer("A"));
//		set2.add(new StringBuffer("Z"));
//		set2.add(new StringBuffer("L"));
//		set2.add(new StringBuffer("B"));
//		System.out.println(set2);
		
		
//		TreeSet set3=new TreeSet(new MyComparator());
//		set3.add(10);
//		set3.add(0);
//		set3.add(15);
//		set3.add(20);
//		set3.add(20);
//		System.out.println(set3);
		System.out.println(Integer.compare(10,5));
				
		TreeSet set4=new TreeSet(new CustomComparator());
		set4.add("B");
		set4.add("AAA");
		set4.add("XXX");
		set4.add("ABCD");
		set4.add(new StringBuffer("Z"));
		set4.add(new StringBuffer("XX"));
//		set4.add(10);
		System.out.println(set4);
	}

}
