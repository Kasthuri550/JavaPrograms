package OOPS;

class Driver
{
	String name;

	Driver(String name)
	{
		this.name=name;
	}
}

class Car
{
	Driver driver;

	Car(Driver driver)
	{
		this.driver=driver;
	}

	void show()
	{
		System.out.println("Driver name: "+driver.name);
	}

}
public class Aggregation {

	public static void main(String[] args) {

		Driver driver=new Driver("Kasthuri");
		Car car=new Car(driver);
		car.show();
	}
}
