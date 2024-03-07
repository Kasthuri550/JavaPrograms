import java.util.Arrays;


public class CompComp {

	public static void main(String[] args) {
		
		int arr[]= {89,32,43,12,34,90};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		Employee e1=new Employee(34,"Ramu");
		Employee e2=new Employee(89,"Arun");
		Employee e3=new Employee(56,"Sanjay");
		Employee e4=new Employee(90,"Leela");
        Employee[] e= {e1,e2,e3,e4};
        
        Arrays.sort(e,Employee.comparator);
        
        System.out.println(Arrays.toString(e));

	}

}
