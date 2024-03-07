import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.ArrayList;

public class PrintMap {

	public static void main(String[] args) {
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();

		hmap.put('a', 1);
		hmap.put('r', 9);
		hmap.put('q', 2);
		hmap.put('b', 3);
		hmap.put('z', 8);
		hmap.put('s', 0);

		Set<Entry<Character, Integer>> entrySet = hmap.entrySet();
		List<Entry<Character,Integer>> list = new ArrayList<Entry<Character,Integer>>(entrySet);
		Collections.sort(list, new Comparator<Map.Entry<Character,Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
			
		});

		for(Map.Entry<Character, Integer> me:list)
		{
			System.out.println(me);
		}

	}

}
