import java.util.HashMap;

public class Map {

	public static void main(String[] args) {

		HashMap<Employee,Integer> map1=new HashMap<Employee, Integer>();
		Employee e1=new Employee(1001,"Kasthuri");
		Employee e2=new Employee(1001,"Kasthuri");
		
		map1.put(e1,1);
		map1.put(e2,1);
		
		System.out.println(map1);
		
		
		HashMap<Integer,Employee> map2=new HashMap<Integer,Employee>();
		
		map2.put(1,e1);
		map2.put(1,e2);
		
		System.out.println(map2);
		
	}

}
