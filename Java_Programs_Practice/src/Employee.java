import java.util.Comparator;

public class Employee implements Comparable<Employee>{

	private int id;
	private String name;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return id + "--" + name;
	}

	@Override
	public int compareTo(Employee o) {
		
		int ceid=this.id;
		int eid=o.getId();
		
		if(ceid < eid)
			return -1;
		else if(ceid > eid)
			return +1;
		else
			return 0;
	}
	
	public static Comparator<Employee> comparator=new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			
//			return -o1.compareTo(o2);
			return +1;
		}
		
	};
	
}
