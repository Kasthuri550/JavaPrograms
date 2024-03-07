import java.util.*;
public class PriorityQueueExample {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		pq.add(89);
		pq.add(34);
		pq.add(13);
		pq.add(43);
		pq.add(23);
		
		System.out.println(pq);
		System.out.println(pq.peek());
		System.out.println(pq);
		pq.offer(76);
		System.out.println(pq);
		pq.poll();
		System.out.println(pq);
        System.out.println(pq.isEmpty());
        System.out.println(pq.contains(34));
        System.out.println(pq.size());
        pq.clear();
        System.out.println(pq);
	}

}
