package OOPS;

class Animalss
{
	void eat()
	{
		System.out.println("Animal eats food");
	}
}

class Dogss extends Animalss
{
	void sound()
	{
		System.out.println("Dog barks");
	}
}

public class InheritanceExample {

	public static void main(String[] args) {

		Animalss animal1=new Animalss();
		animal1.eat();

		Dogss dogss=new Dogss();
		dogss.eat();
		dogss.sound();

		Animalss animal=new Dogss();
		animal.eat();
	}
}
