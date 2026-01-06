package designpatterns;

/*
 * The Prototype Design Pattern is a creational design pattern.

Idea:
Instead of creating a new object using new, we clone an existing object.

This is useful when:

Object creation is costly or complex

You want to avoid repeating initialization logic

You need multiple similar objects with small changes
 * 
 * */
interface Prototype
{
	Prototype clone();
}

class Employee implements Prototype
{
	private String name;
	private String role;

	Employee(String name,String role)
	{
		this.name=name;
		this.role=role;
	}

	@Override
	public Prototype clone()
	{
		return new Employee(this.name, this.role);
	}

	public void showDetails()
	{
		System.out.println(this.name+" "+this.role);
	}

	public void setName(String name)
	{
		this.name=name;
	}
}
public class PrototypeDesignPattern {

	public static void main(String[] args) {

		Employee emp1=new Employee("Kasthuri","Developer");
		Employee emp2=(Employee)emp1.clone();
		emp2.setName("Suseela");
		emp1.showDetails();
		emp2.showDetails();
	}
}
