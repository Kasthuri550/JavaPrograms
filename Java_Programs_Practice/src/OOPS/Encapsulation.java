package OOPS;

class Person
{
	private String name;

	public void setName(String name)
	{
		this.name=name;
	}

	public String getName()
	{
		return name;
	}
}


public class Encapsulation {

	public static void main(String[] args) {

		Person person=new Person();
		person.setName("Kasthuri");
		System.out.println(person.getName());
	}
}
