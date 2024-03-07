package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class hashmap {

	public static void main(String[] args) {
		
		Map<Integer,String> hmap=new HashMap<Integer, String>();
		hmap.put(102, "Kasthuri");
		hmap.put(104, "Arun kumar");
		hmap.put(104, "Arun kumar");
		hmap.put(null,"Suseela");
		hmap.put(null, "Kumar");
		System.out.println(hmap);
		
//		hmap.putIfAbsent(102, "Suseela");
//		1
//		hmap.forEach((a,b) -> System.out.println(a+" "+b));
//		
//		String string = hmap.toString();
////		2
//		System.out.println(string);
//		
//		hmap.replace(102, "Kasthuri","Abby");
//		hmap.replace(104, "Arun");
////		3
//		System.out.println(hmap);
//		
////		String compute = hmap.compute(102, (a,b) ->  a+" "+b);
////		4
////		System.out.println(compute);
//		
//		Map<Integer,String> map=new HashMap<Integer,String>();
//		map.put(201, "Raj");
//		map.put(202,"Yash");
//		hmap.putAll(map);		
////		5
//		System.out.println(hmap);
//		
//		BiConsumer<Integer,String> biConsumer=new BiConsumer<Integer, String>() {
//
//			@Override
//			public void accept(Integer t, String u) {
//				
//				System.out.println(t+"---"+u);
//				
//			}	
//		};
////		6
//		hmap.forEach(biConsumer);
//		hmap.computeIfAbsent(106,(a) -> a+"kalish");
////		7
//		System.out.println(hmap);
//		
//		hmap.computeIfPresent(201,(t,u) -> t+u);
//		System.out.println(hmap);
//		
//		System.out.println(hmap.values());
//		System.out.println(hmap.get(202));
//		hmap.merge(102, "Abby", (a,b) -> a+"Arun");
//		System.out.println(hmap);
//		for(Map.Entry<Integer,String> entryMap:hmap.entrySet())
//		{
//			System.out.println(entryMap.getKey()+" "+entryMap.getValue());
//		}
		
	}

}


/*
 containsKey()
 containsValue()
 values()
 entrySet()
 keySet()
 isEmpty()
 get(obj)
 getOrDefault(obj,String defaultValue)
 put(obj,obj)
 putAll(map)
 putIfAbsent(obj,obj)
 foreach(BiConsumer)
 replace(obj,obj)
 replace(obj,obj,obj)
 compute(obj,Biconsumer accept(t,u))
 computeIfAbsent(obj,Function apply(t))
 computeIfPresent(obj,Bifunction apply(t,u))
 merge(key,value,Bifunction apply(t,u))
 */
