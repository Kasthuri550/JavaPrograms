import java.util.HashSet;
import java.util.Iterator;
import java.util.Spliterator;

public class HashSetExample {

	public static void main(String[] args) {
		
		HashSet<Integer> hs=new HashSet<Integer>();
		hs.add(10);
		hs.add(20);
		hs.add(30);
		hs.add(40);
		hs.add(50);
		hs.add(null);
		hs.add(null);
				
		System.out.println(hs);
		System.out.println(hs.remove(40));
		System.out.println(hs.contains(30));
		
//		Iterator<Integer> iterator=hs.iterator();
//		
//		while(iterator.hasNext())
//		{
//			System.out.println(iterator.next());
//		}
		
		
		Spliterator<Integer> spliterator=hs.spliterator();
		
		spliterator.forEachRemaining(System.out::println);
		
		HashSet<Integer> clonedSet = (HashSet<Integer>) hs.clone();
		
		hs.add(60);
		
		System.out.println(clonedSet);
		System.out.println(hs);
		System.out.println(hs.size());
		hs.clear();
		System.out.println(hs.isEmpty());
		
	}

}
