package copy;

//Deep Copy
class Address1
{
	String city;

	Address1(String city)
	{
		this.city=city;
	}
}

class Student1
{
	int id;
	Address1 address;

	Student1(int id,Address1 address)
	{
		this.id=id;
		this.address=address;
	}

	//	Copy Constructor
	Student1(Student1 s)
	{
		this.id=s.id;
		this.address=new Address1(s.address.city);
	}
}
public class DeepCopy {

	public static void main(String[] args) {
		
		Address1 address=new Address1("Chennai");
		Student1 student1=new Student1(1,address);
		Student1 student2=new Student1(student1);		
		student2.address.city="Banglore";
		
		System.out.println(student1.address.city);
		System.out.println(student2.address.city);
	}
}
