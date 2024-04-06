package Streams.model;

public class EmployeeQ {
	
	private String id;
	private String name;
	private Integer age;
	private String department;
	private Integer salary;
	
	public EmployeeQ(String id, String name, Integer age, String department, Integer salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeQ [id=" + id + ", name=" + name + ", age=" + age + ", department=" + department + ", salary="
				+ salary + "]";
	}
}
