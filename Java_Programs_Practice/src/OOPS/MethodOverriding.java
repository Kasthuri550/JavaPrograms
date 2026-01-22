package OOPS;

class Animale
{
	void sound()
	{
		System.out.println("Animal make sounds");
	}
}

class Doge extends Animale
{
	void sound()
	{
		System.out.println("Dog barks");
	}
}
public class MethodOverriding {

	public static void main(String[] args) {

		Animale animale=new Doge();
		animale.sound();
	}
}
