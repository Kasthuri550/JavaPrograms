package ObjectCloning;

class Persons
{
	String name;

	Persons(String name)
	{
		this.name=name;
	}

	Persons(Persons p)
	{
		this.name=p.name;
	}
}
public class DeepCopy {

	public static void main(String[] args) {

		Persons p1=new Persons("Kasthuri");
		Persons p2=new Persons(p1);

		p2.name="Abby";

		System.out.println(p1.name);
		System.out.println(p2.name);
	}
}
