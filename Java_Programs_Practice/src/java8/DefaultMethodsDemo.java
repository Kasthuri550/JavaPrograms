package java8;

interface Left
{
	default void m1()
	{
		System.out.println("Left interface m1()");
	}
}

interface Right extends Left
{
	default void m1()
	{
		System.out.println("Right interface m1()");
	}
}
public class DefaultMethodsDemo implements Right {
	
	public void m1()
	{
//		System.out.println("DefaultmethodsDemo class");
		Right.super.m1();
//		Left.super.m1();
	}
	
	public static void main(String[] args) {
		
		DefaultMethodsDemo defaultMethodsDemo=new DefaultMethodsDemo();
		defaultMethodsDemo.m1();

	}
}
