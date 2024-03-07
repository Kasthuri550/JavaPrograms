import java.util.Arrays;
import java.util.LinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		
		LinkedList<Integer> ll=new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		LinkedList<Integer> ll1=new LinkedList<Integer>();
		ll.descendingIterator().forEachRemaining(ll1::add);
		System.out.println(ll1);
		int a[]= {43,89,23,90,12};
		Arrays.stream(a).forEach(System.out::println);
		int sum = Arrays.stream(a).sum();
		System.out.println(sum);
	}

}
