package designpatterns;

import java.util.ArrayList;
import java.util.List;

interface Observer {
	void update(String message);
}

class Student implements Observer {
	private String name;
	Student(String name) { this.name = name; }
	public void update(String message) { 
		System.out.println(name + " received: " + message); 
	}
}

class Teacher {
	private List<Observer> students = new ArrayList<>();

	public void addStudent(Observer s) { students.add(s); }
	public void notifyStudents(String msg) {
		for (Observer s : students) s.update(msg);
	}
}

public class ObserverDesignPattern {

	public static void main(String[] args) {

		Teacher teacher = new Teacher();

		Student s1 = new Student("Kasthuri");
		Student s2 = new Student("Arun");

		teacher.addStudent(s1);
		teacher.addStudent(s2);

		teacher.notifyStudents("Exam postponed!");
	}
}
