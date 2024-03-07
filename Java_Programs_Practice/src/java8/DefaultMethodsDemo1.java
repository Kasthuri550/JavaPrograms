package java8;

interface Me
{
	default void m1()
	{
		System.out.println("Left interface m1()");
	}
}

public class DefaultMethodsDemo1 implements Me{

	public static void main(String[] args) {
		
		DefaultMethodsDemo1 defaultMethodsDemo1=new DefaultMethodsDemo1();
		defaultMethodsDemo1.m1();
	}

}
