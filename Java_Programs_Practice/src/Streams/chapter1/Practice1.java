package Streams.chapter1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Practice1 {

	public static void main(String[] args) {
		
		List<Employee> empList=new ArrayList<>();
		empList.add(new Employee(1001,"Kasthuri",43000,4,true));
		empList.add(new Employee(1002,"Arun",65000,4,true));
		empList.add(new Employee(1003,"Kumar",78238,2,false));
		empList.add(new Employee(1004,"Abby",33225,2,false));
		empList.add(new Employee(1005,"Strawberry",32890,3,true));
		
		Map<Integer, List<Employee>> collect1 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.toList()));
		
		collect1.entrySet().forEach(entry->{
			System.out.println(entry.getKey()+" - "+entry.getValue());
		});
		
		Map<Integer, Long> collect2 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.counting()));
		
		collect2.entrySet().forEach(entry->{
			System.out.println(entry.getKey()+" - "+entry.getValue());
		});
		
		Optional<Employee> maxSalaryEmp = empList.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println(maxSalaryEmp.get());
		Optional<Employee> minSalaryEmp = empList.stream().min(Comparator.comparing(Employee::getSalary));
		System.out.println(minSalaryEmp.get());
		
		long activeCount = empList.stream().filter(e->e.isStatus()==true).count();
		System.out.println(activeCount);
		long inActiveCount = empList.stream().filter(e->e.isStatus()==false).count();
		System.out.println(inActiveCount);
		
		Map<Integer, Optional<Employee>> collect3 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,
				Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
		
		collect3.entrySet().forEach(entry->{
			System.out.println(entry.getKey()+" - "+entry.getValue().get());
		});
	}
}
