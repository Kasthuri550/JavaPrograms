class Animal
{
	String color;
}

class Cat extends Animal
{
	void meow()
	{
		System.out.println("Meow");
	}
	
	String colors()
	{
		color="Black";
		return color;
	}
}
public class ShowInheritance {

	public static void main(String[] args) {
		
		Cat cat=new Cat();
		cat.meow();
		System.out.print(cat.colors());
	}
}
