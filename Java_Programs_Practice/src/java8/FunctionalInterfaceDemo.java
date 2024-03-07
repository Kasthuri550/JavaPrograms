package java8;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		
		Interf i=(x,y)-> {return x*y;};
		System.out.println(i.addMe(10, 10));
	}
}
