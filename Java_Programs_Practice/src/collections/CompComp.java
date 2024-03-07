package collections;

import java.util.TreeSet;

public class CompComp {

	public static void main(String[] args) {
		
		System.out.println("Comparabe-----------------------------");
		TreeSet<Employee> set1=new TreeSet<>();
		set1.add(new Employee(60,"Kasthuri"));
		set1.add(new Employee(40,"Arun"));
		set1.add(new Employee(10,"Kumar"));
		set1.add(new Employee(80,"Abby"));
		set1.add(new Employee(90,"Ganga"));
		
		set1.forEach(e -> System.out.println(e));
		System.out.println("Comparator-----------------------------");
		TreeSet<Employee> set2=new TreeSet<Employee>(new EmployeeComparator());
		set2.add(new Employee(60,"Kasthuri"));
		set2.add(new Employee(40,"Arun"));
		set2.add(new Employee(10,"Kumar"));
		set2.add(new Employee(80,"Abby"));
		set2.add(new Employee(90,"Ganga"));
		
		set2.forEach(e -> System.out.println(e));

	}

}
