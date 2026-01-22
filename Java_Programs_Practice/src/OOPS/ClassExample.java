package OOPS;

class Student
{
	int id;
	String name;

	void display()
	{
		System.out.println("ID: "+id);
		System.out.println("Name: "+name);
	}
}

public class ClassExample {

	public static void main(String[] args) {

		Student student=new Student();

		student.id=101;
		student.name="Kasthuri";

		student.display();
	}
}
