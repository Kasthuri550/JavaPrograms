package collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class linkedhashmap {

	public static void main(String xyz[]) {
		
		Map<Integer,String> hmap=new LinkedHashMap<Integer, String>();
		hmap.put(102, "Kasthuri");
		hmap.put(104, "Arun kumar");
		hmap.put(104, "Arun kumar Kasthuri");
		hmap.put(null,"Suseela");
		hmap.put(null, "Kumar");
		System.out.println(hmap);
	}

}
