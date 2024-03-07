import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {

	public static void main(String[] args) {
		
		Deque<Integer> d=new ArrayDeque<Integer>();
		d.add(90);
		d.addFirst(1);
		d.addLast(100);
		d.offerFirst(8);
		d.offerLast(null);
		
		System.out.println(d);
		
//		System.out.println(d.peekFirst());
//		
//		System.out.println(d.peekLast());
//		
//		System.out.println(d.removeFirst());
		
//		System.out.println(d);
		
//		System.out.println(d.removeLast());
		
//		System.out.println(d);
		
//		System.out.println(d.pollFirst());
		
		System.out.println(d);
		

	}

}
