package java8;

class Student
{
	int rollno;
	String name;
	int marks;
	
	Student()
	{
//		System.out.println("Student object is created");
	}
	
	Student(int rollno,String name,int marks)
	{
		this.rollno=rollno;
		this.name=name;
		this.marks=marks;
		System.out.println(rollno+" "+name+" "+marks);
	}
}
interface StudentInterf
{
//	public Student get();
	public Student get(int rollno,String name,int marks);
}
public class ConstructorReference {

	public static void main(String[] args) {
		
		StudentInterf s=Student::new;
		s.get(1001,"Kasthuri",90);
	}
}
