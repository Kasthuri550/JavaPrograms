package Streams.chapter1;

public class Employee {

	private int empId;
	private String empName;
	private int salary;
	private int deptId;
	private boolean status;
			
	public Employee(int empId, String empName, int salary, int deptId, boolean status) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.deptId = deptId;
		this.status = status;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", status=" + status + "]";
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
}
