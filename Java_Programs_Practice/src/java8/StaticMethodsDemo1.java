package java8;

interface I
{
	public static void m1()
	{
		System.out.println("Interface static method");
	}
}
public class StaticMethodsDemo1 {

	public static void main(String[] args) {
		
		I.m1();

	}
}
