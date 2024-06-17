package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmployeePractice {

	public static void main(String[] args) {
		
		List<Employee> employeeList=Arrays.asList(
				new Employee(111, "Jiya Brien", 32, "Female","HR",2001,25000),
				new Employee(122, "Brien", 29, "Male","Sales",2019,21000),
				new Employee(131, "Jiya", 32, "Female","Product",2014,20000),
				new Employee(141, "John", 42, "Male","Security",2013,28000),
				new Employee(152, "Riya", 52, "Female","HR",2012,32000),
				new Employee(164, "Sam", 32, "Male","IT",2010,25000),
				new Employee(178, "Madhuri", 32, "Female","HR",2007,56000),
				new Employee(189, "Rose", 22, "Female","IT",2015,89000),
				new Employee(192, "James", 24, "Male","HR",2016,54000),
				new Employee(123, "Juliat", 52, "Female","IT",2020,90000));
		
		problem1(employeeList);
		problem2(employeeList);

	}

	private static void problem2(List<Employee> employeeList) {
		
		Map<String, Employee> collectMap = employeeList.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment,
							Collectors.collectingAndThen(
									Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary))),
									Optional::get
									)
							));
		System.out.println(collectMap);
	}

	private static void problem1(List<Employee> employeeList) {
		
		Map<String, Double> collectMap = employeeList.stream()
					.collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(collectMap);
	}
}
