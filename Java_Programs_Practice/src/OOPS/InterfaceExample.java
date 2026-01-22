package OOPS;

interface Animals
{
	void sound();

	default void sleep()
	{
		System.out.println("Animal is sleeping");
	}
}

class Dogs implements Animals
{

	@Override
	public void sound() {

		System.out.println("Dog barks");
	}

}
public class InterfaceExample {

	public static void main(String[] args) {

		Animals animal=new Dogs();
		animal.sound();
		animal.sleep();
	}
}
