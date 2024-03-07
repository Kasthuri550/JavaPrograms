package java8;

public class Employee {
	
	private String id;
	private String name;
	private String designation;
	private int age;
			
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String id, String name, String designation, int age) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.age = age;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", age=" + age + "]";
	}
	
}
