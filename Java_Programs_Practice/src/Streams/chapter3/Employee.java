package Streams.chapter3;

public class Employee {
	
	private int id;
	private int salary;

	public Employee(int id, int salary) {
		
		this.id=id;
		this.salary=salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + "]";
	}
	
}
