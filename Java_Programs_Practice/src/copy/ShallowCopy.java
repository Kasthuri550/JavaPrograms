package copy;

/*
 * Shallow copy copies only object references, whereas deep copy creates independent copies of all nested objects.
 * */

// Shallow Copy
class Address
{
	String city;

	Address(String city)
	{
		this.city=city;
	}
}

class Student
{
	int id;
	Address address;

	Student(int id,Address address)
	{
		this.id=id;
		this.address=address;
	}

	//	Copy Constructor
	Student(Student s)
	{
		this.id=s.id;
		this.address=s.address;
	}
}
public class ShallowCopy {

	public static void main(String[] args) {

		Address address=new Address("Chennai");
		Student student1=new Student(1,address);

		Student student2=new Student(student1);
		student2.address.city="Banglore";

		System.out.println(student1.address.city);
		System.out.println(student2.address.city);
	}
}
