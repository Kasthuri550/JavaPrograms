import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(1,"One");
		map.put(2,"Two");
		map.put(3,"Three");
		map.putIfAbsent(2,"Four");
		
		System.out.println(map);
		
		System.out.println(map.get(1));
		
		System.out.println("Keys "+map.keySet());
		System.out.println("Values "+map.values());
		System.out.println(map.entrySet());
		
		System.out.println(map.containsKey(4));
		
		System.out.println(map.containsValue("two"));
		Map<Integer,String> map1=new HashMap<Integer,String>();
		map1.put(5,"Five");
		map1.put(6,"Six");
		map1.put(7,"Seven");
		
		map.putAll(map1);
		
		
		System.out.println(map);
		
		System.out.println(map.getOrDefault(8,"Default"));
		
		map.replace(3,"Four");
		
		System.out.println(map);
		
		Map<String,Integer> map2=new HashMap<String,Integer>();
		map2.put("Arun",50000);
		map2.put("Kasthuri",30000);
		
		map2.replaceAll((names,salary) -> salary+(salary*5)/100);
		
		System.out.println(map2);
		
		map2.put(null,null);
		map2.put(null,null);
		System.out.println(map2);
		
		map2.computeIfPresent("Kasthuri",(names,salary) -> salary+1000);
		
		System.out.println(map2);

	}

}
