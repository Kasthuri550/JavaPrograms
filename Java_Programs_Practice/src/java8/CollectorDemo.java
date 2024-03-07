package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorDemo {

	public static void main(String[] args) {
		
		List<Employee> emplist=new ArrayList<Employee>();
		
		emplist.add(new Employee ("E40002", "ASHOK", "MANAGER" ,28));
		emplist.add(new Employee ("E40003","PRADEEP", "ASST MANAGER" ,28));
		emplist.add(new Employee("E40004", "SANTHOSH", "STORE MANAGER" ,25));
		emplist.add(new Employee ("E40005","ASHOK", "GENERAL MANAGER" ,26));
		emplist.add(new Employee("E40001","PRADEEP", "H.R", 36));
		
//		emplist.stream().forEach((e) -> System.out.println(e));
//		emplist.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).forEach(e -> System.out.println(e));
//		Map<String, List<Employee>> collect = emplist.stream().collect(Collectors.groupingBy(Employee::getName,TreeMap::new,Collectors.toList()));
//		System.out.println(collect);
		
		Map<String, Long> collect = emplist.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));
		System.out.println(collect);
	}

}
