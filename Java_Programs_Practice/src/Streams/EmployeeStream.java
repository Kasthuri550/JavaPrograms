package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import Streams.model.Employee;

public class EmployeeStream {

	public static void main(String[] args) {
		
		List<Employee> empList=new ArrayList<>();
		empList.add(new Employee(101, "siva", 101, "active", 2000));
		empList.add(new Employee(102, "reddy", 101, "active", 5000));
		empList.add(new Employee(103, "raju", 102, "inactive", 6000));
		empList.add(new Employee(104, "shivam", 102, "inactive",4000));
		empList.add(new Employee(105, "bob", 103, "active", 3500));
		empList.add(new Employee(106, "alice", 103, "inactive", 3500));
		empList.add(new Employee(107, "srinu", 104, "active", 3500));		
		
		Map<Integer, List<Employee>> empListBasedDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.toList()));
		empListBasedDept.forEach((key,value)->{
			System.out.println(key+" - "+value);
		});
		
		Map<Integer, Long> empCountDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.counting()));
		empCountDept.entrySet().forEach(entry -> {
			System.out.println(entry.getKey()+" - "+entry.getValue());
		});
		
		long activeEmpCount = empList.stream().filter(emp -> "active".equals(emp.getStatus())).count();
		long inactiveEmpCount = empList.stream().filter(emp -> "inactive".equals(emp.getStatus())).count();
		System.out.println(activeEmpCount);
		System.out.println(inactiveEmpCount);
		
		Optional<Employee> minEmp = empList.stream().min(Comparator.comparing(Employee::getSalary));
		Optional<Employee> maxEmp = empList.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println(minEmp);
		System.out.println(maxEmp);
		
		Map<Integer, Optional<Employee>> maxEmpSalaryByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,
				Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
	
		maxEmpSalaryByDept.entrySet().forEach(entry -> {
			System.out.println(entry.getKey()+" - "+entry.getValue());
		});
	}
}
