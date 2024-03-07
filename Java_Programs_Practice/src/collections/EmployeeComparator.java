package collections;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{
	
	@Override
	public int compare(Employee o1, Employee o2) {
		
		String emp_name1 = o1.getEmp_name();
		String emp_name2 = o2.getEmp_name();
		
		return emp_name1.compareTo(emp_name2);
	}

}
