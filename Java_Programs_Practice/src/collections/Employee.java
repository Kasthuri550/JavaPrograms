package collections;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	
	private int emp_id;
	private String emp_name;
	
	public Employee() {
		super();
	}

	public Employee(int emp_id, String emp_name) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
	}
	
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	@Override
	public int compareTo(Employee o) {
		
		int e1 = this.emp_id;
		int e2=o.getEmp_id();
		
		if(e1<e2)
		{
			return -1;
		}
		else if(e1>e2)
		{
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + "]";
	}
}
