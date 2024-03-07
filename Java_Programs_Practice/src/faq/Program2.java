package faq;

class Base
{
	public void print()
	{
		System.out.println("Base");
	}
}

class Derived extends Base
{
	public void print()
	{
		System.out.println("Derived");
	}
}

public class Program2 {
	
	public static void doPrint(Base base)
	{
		base.print();
	}

	public static void main(String[] args) {
		
		Base base=new Base();
		Base base1=new Derived();
		Derived derived=new Derived();
		doPrint(base);
		doPrint(base1);
		doPrint(derived);
	}

}
