package java8;

public class GarbageDemo {

	static Employee e1;
	public static void main(String[] args) {
		
		m1(); 
// One object is eligible for GC
	}
	
	public static Employee m1()
	{
	    e1=new Employee();
		Employee e2=new Employee();
		
		return e1;
	}

}
