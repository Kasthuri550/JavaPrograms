package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Streams.model.EmployeeQ;

public class RealTimeProgram {

	public static void main(String[] args) {

		List<EmployeeQ> employeeList=Arrays.asList(
				new EmployeeQ("101","Siva",35,"Sales",30000),
				new EmployeeQ("102","Bala",42,"HR",42000),
				new EmployeeQ("103","Ramesh",23,"Development",20000),
				new EmployeeQ("104","Devi",54,"Sales",48000),
				new EmployeeQ("105","Ramya",25,"Development",22000));

		//		printEmployees(employeeList);
		//		checkSalary(employeeList);
		//		printEmployeesName(employeeList);
		//		highestSalaryEmployee(employeeList);
		//		minimumSalaryEmployee(employeeList);
		//		removeDuplicateDepartments(employeeList);
		//		sortEmployees(employeeList);
		//		sortEmployeesReverse(employeeList);
		//		sortEmployeesTwo(employeeList);
		//		printNumberOfEmployeeInDept(employeeList);
		printDuplicateDepartments(employeeList);
	}

	private static void printDuplicateDepartments(List<EmployeeQ> employeeList) {
		
		Map<String, Long> empCountByDept = employeeList.stream()
		.collect(Collectors.groupingBy(EmployeeQ::getDepartment,Collectors.counting()));
		
		empCountByDept.entrySet().stream()
		.filter(entry-> entry.getValue()>1)
		.map(Map.Entry::getKey).forEach(System.out::println);
		
	}

	private static void printNumberOfEmployeeInDept(List<EmployeeQ> employeeList) {

		System.out.println("Print the number of employees in each department");

		Map<String, Long> countEmp = employeeList.stream()
				.collect(Collectors.groupingBy(EmployeeQ::getDepartment,Collectors.counting()));

		countEmp.entrySet().forEach(entry -> {
			System.out.println(entry.getKey()+" - "+entry.getValue());
		});

	}

	private static void sortEmployeesTwo(List<EmployeeQ> employeeList) {

		System.out.println("Sort employees based on department and name");
		employeeList.stream()
		.sorted(Comparator.comparing(EmployeeQ::getDepartment).thenComparing(EmployeeQ::getName))
		.forEach(System.out::println);

	}

	private static void sortEmployeesReverse(List<EmployeeQ> employeeList) {

		System.out.println("Sort the employees based on names in reverse order");
		employeeList.stream()
		.map(EmployeeQ::getName)
		.sorted(Comparator.reverseOrder())
		.forEach(System.out::println);
	}

	private static void sortEmployees(List<EmployeeQ> employeeList) {

		System.out.println("Sort employees based on names");
		employeeList.stream()
		.map(EmployeeQ::getName)
		.sorted()
		.forEach(System.out::println);
	}

	private static void removeDuplicateDepartments(List<EmployeeQ> employeeList) {

		System.out.println("Remove duplicate departments");
		String removeDuplicateDept = employeeList.stream()
				.map(EmployeeQ::getDepartment)
				.distinct()
				.collect(Collectors.joining(","));
		System.out.println(removeDuplicateDept);
	}

	private static void minimumSalaryEmployee(List<EmployeeQ> employeeList) {

		System.out.println("The name of the minimum salary employee");
		String minSalaryName = employeeList.stream()
				.min(Comparator.comparing(EmployeeQ::getSalary))
				.map(EmployeeQ::getName).get();
		System.out.println(minSalaryName);
	}

	private static void highestSalaryEmployee(List<EmployeeQ> employeeList) {

		System.out.println("The name of the highest salary employee");
		String highestSalary = employeeList.stream()
				.max(Comparator.comparing(EmployeeQ::getSalary))
				.map(EmployeeQ::getName).get();
		System.out.println(highestSalary);
	}

	private static void printEmployeesName(List<EmployeeQ> employeeList) {

		System.out.println("Print the names of employees in Sales department");
		employeeList.stream()
		.filter(employee -> employee.getDepartment().equals("Sales"))
		.map(EmployeeQ::getName)
		.forEach(System.out::println);
	}

	private static void checkSalary(List<EmployeeQ> employeeList) {

		System.out.println("Printing employees list greater than 40000 using stream");

		employeeList.stream()
		.filter(employee -> employee.getSalary()>40000)
		.forEach(System.out::println);

	}

	private static void printEmployees(List<EmployeeQ> employeeList) {

		System.out.println("Printing employees list using stream");
		employeeList.stream().forEach(System.out::println);
	}

}
