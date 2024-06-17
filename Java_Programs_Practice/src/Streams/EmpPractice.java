package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmpPractice {

	public static void main(String[] args) {
		
		List<Emp> listEmp=Arrays.asList(
				new Emp(1,500),
				new Emp(2,1000),
				new Emp(3,1500),
				new Emp(4,2000),
				new Emp(5,2500),
				new Emp(6,3000),
				new Emp(7,3500));
		
		problem1(listEmp);
		problem2(listEmp);
		problem3(listEmp);
		problem4(new int[]{2,3,4,5,7});

	}

	private static void problem4(int arr[]) {
		
		int sum = Arrays.stream(arr).reduce((n1,n2)->n1+n2).getAsInt();
		System.out.println(sum);
		
		int sum2 = Arrays.stream(arr)
			  .sum();
		System.out.println(sum2);
		
	}

	private static void problem3(List<Emp> listEmp) {
		
		List<Emp> collectList = listEmp.stream()
			   .sorted((e1,e2)->e2.getSalary()-e1.getSalary())
			   .skip(3)
			   .collect(Collectors.toList());
		System.out.println(collectList);
	}

	private static void problem2(List<Emp> listEmp) {
		
		List<Emp> top3Emp = listEmp.stream()
			    .sorted((e1,e2)->e2.getSalary()-e1.getSalary())
			    .limit(3).collect(Collectors.toList());	
		System.out.println(top3Emp);
	}

	private static void problem1(List<Emp> listEmp) {
		
		List<Emp> collectList = listEmp.stream()
			   .sorted((e1,e2)->e2.getSalary()-e1.getSalary())
			   .collect(Collectors.toList());
		System.out.println(collectList);
	}
}
