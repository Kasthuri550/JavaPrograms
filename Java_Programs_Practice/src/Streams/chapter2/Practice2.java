package Streams.chapter2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Practice2 {

	public static void main(String[] args) {
		
		List<Employee> employeeList = Arrays.asList(
				new Employee ("181","Siva",35,"Sales", 36006),
				new Employee ("102","Bala",42,"HR",  42600),
				new Employee ("183","Ramesh",23, "Development",  20000),
				new Employee ("184","Devi",54, "Sales",  48806),
				new Employee ("185","Ramya",25,"Development",22000));
		
//				printEmployees (employeeList);
//				checkSalary(employeeList);
//				printEmployeeNames (employeeList);
//				highestSalaryEmployee(employeeList);
//				minimumSalaryEmployee(employeeList);
//				removeDuplicateDepartments(employeeList);
//				printNumberOfEmployees(employeeList);
				printDuplicateDepartments(employeeList);
//				sortEmployees(employeeList);
//				sortEmployeesReverse(employeeList);
//				sortEmployeesTwo(employeeList);
	}

	private static void printDuplicateDepartments(List<Employee> employeeList) {
		
		Map<String, Long> duplicateDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		                     
		duplicateDept.entrySet().stream()
					 .filter(emp->emp.getValue()>1)
					 .map(Map.Entry::getKey)
					 .forEach(System.out::println);
	}

	private static void printNumberOfEmployees(List<Employee> employeeList) {
		
		Map<String, Long> numberOfEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		                     
		System.out.println(numberOfEmp);
	}

	private static void sortEmployeesTwo(List<Employee> employeeList) {
		
		employeeList.stream()
		.sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getName))
		.forEach(System.out::println);
		
	}

	private static void sortEmployeesReverse(List<Employee> employeeList) {
		
		employeeList.stream().map(Employee::getName)
							 .sorted(Comparator.reverseOrder())
							 .forEach(System.out::println);
		
	}

	private static void sortEmployees(List<Employee> employeeList) {
		
		employeeList.stream().map(Employee::getName)
							 .sorted()
							 .forEach(System.out::println);
		
	}

	private static void removeDuplicateDepartments(List<Employee> employeeList) {
		
		String uniqueDepartments = employeeList.stream()
					.map(Employee::getDepartment)
					.distinct()
					.collect(Collectors.joining(","));
		System.out.println(uniqueDepartments);
	}

	private static void minimumSalaryEmployee(List<Employee> employeeList) {
		
		String minSalaryEmp = employeeList.stream().min(Comparator.comparing(Employee::getSalary))
							 .map(Employee::getName).get();
		
		System.out.println(minSalaryEmp);
		
	}

	private static void highestSalaryEmployee(List<Employee> employeeList) {
		
		Optional<String> highestSalaryEmp = employeeList.stream().max(Comparator.comparing(Employee::getSalary))
							 .map(Employee::getName);
		System.out.println(highestSalaryEmp.get());		
	}

	private static void printEmployeeNames(List<Employee> employeeList) {
		
		employeeList.stream().filter(emp->emp.getDepartment().equals("Sales"))
							 .map(Employee::getName)
							 .forEach(System.out::println);
				
	}

	private static void checkSalary(List<Employee> employeeList) {
		
		employeeList.stream().filter(emp -> emp.getSalary()>40000)
							 .forEach(System.out::println);
	}

	private static void printEmployees(List<Employee> employeeList) {
		
		employeeList.stream().forEach(System.out::println);
	}

}
