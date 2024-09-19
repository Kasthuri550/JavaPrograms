package Streams.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice3 {

	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee (1, 500));
		empList.add(new Employee(2, 1000));
		empList.add(new Employee (3, 1500));
		empList.add(new Employee(4, 2000));
		empList.add(new Employee(5, 2500));
		empList.add(new Employee (6, 3000));
		empList.add(new Employee (7, 3500));
		
//		sortEmployeesDesc(empList);
//		fetchTop3(empList);
//		employeeLessThan3rdHighestSalary(empList);
		sumArrElements(new int[]{3,4,5,2,1});

	}

	private static void sumArrElements(int arr[]) {
		
		int totalSum = Arrays.stream(arr).sum();
		System.out.println(totalSum);
		
	}

	private static void employeeLessThan3rdHighestSalary(List<Employee> empList) {
		
		empList.stream().sorted((e1,e2)->e2.getSalary()-e1.getSalary())
		.skip(3).forEach(System.out::println);
		
	}

	private static void fetchTop3(List<Employee> empList) {

		empList.stream().sorted((e1,e2)->e2.getSalary()-e1.getSalary()).limit(3)
		.forEach(System.out::println);	
	}

	private static void sortEmployeesDesc(List<Employee> empList) {
		
		empList.stream().sorted((e1,e2)->e2.getSalary()-e1.getSalary())
						.forEach(System.out::println);	
	}
}
