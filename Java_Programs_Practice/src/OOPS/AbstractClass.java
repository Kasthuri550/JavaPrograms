package OOPS;

abstract class Animal
{
	abstract void sound();

	void sleep()
	{
		System.out.println("Animal is sleeping");
	}
}

class Dog extends Animal
{

	@Override
	void sound() {

		System.out.println("Dog barks");
	}
}
public class AbstractClass {

	public static void main(String[] args) {

		Animal animal=new Dog();	

		animal.sound();
		animal.sleep();
	}
}
