package OOPS;

class Engine
{
	Engine()
	{
		System.out.println("Engine created");
	}
}

class Cars
{
	private Engine engine;

	Cars()
	{
		engine=new Engine();
		System.out.println("Car created");
	}
}
public class Composition {

	public static void main(String[] args) {

		Cars cars=new Cars();
	}
}
