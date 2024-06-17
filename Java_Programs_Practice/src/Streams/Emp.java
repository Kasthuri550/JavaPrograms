package Streams;

public class Emp {
	
	private int id;
	private int salary;
	public Emp() {
		super();
	}
	public Emp(int id, int salary) {
		super();
		this.id = id;
		this.salary = salary;
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
		return "Emp [id=" + id + ", salary=" + salary + "]";
	}

}
