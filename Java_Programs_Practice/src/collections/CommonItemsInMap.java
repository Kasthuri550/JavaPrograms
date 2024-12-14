package collections;

import java.util.HashMap;
import java.util.Map;

public class CommonItemsInMap {

	public static void main(String[] args) {
		
		Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Apple");
        map1.put(2, "Banana");
        map1.put(3, "Cherry");

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(2, "Banana");
        map2.put(3, "Cherry");
        map2.put(4, "Date");
        
        map1.entrySet().retainAll(map2.entrySet());
        
        System.out.println(map1);

	}
}
