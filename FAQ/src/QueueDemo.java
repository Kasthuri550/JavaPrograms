import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		
		Queue<Integer> q=new PriorityQueue<Integer>();
		q.add(50);
		q.add(40);
		q.add(10);
		q.offer(20);
		q.offer(5);
		q.offer(5);
		
		System.out.println(q);
//		q.clear();
//		System.out.println(q.element());
		
//		System.out.println(q.peek());
		
//		System.out.println(q.remove());
//		System.out.println(q.poll());

	}

}
