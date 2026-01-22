package ObjectCloning;

class Person
{
	String name;

	Person(String name)
	{
		this.name=name;
	}
}
public class ShallowCopy {

	public static void main(String[] args) {

		Person p1=new Person("Kasthuri");
		Person p2=p1;

		p2.name="Abby";

		System.out.println(p1.name);
		System.out.println(p2.name);

	}
}
