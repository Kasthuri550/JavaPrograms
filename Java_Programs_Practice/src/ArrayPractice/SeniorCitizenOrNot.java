package ArrayPractice;

import java.time.LocalDate;
import java.time.Period;

class Employee
{
	private int id;
	private String name;
	private LocalDate date;
	
	public Employee(int id, String name, LocalDate date) {
		super();
		this.id = id;
		
		this.name = name;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}

public class SeniorCitizenOrNot{
	
	public static void main(String[] args) {
		
		Employee e=new Employee(1001,"Kasthuri",LocalDate.of(1998,05,17));
		
		Period period=Period.between(e.getDate(),LocalDate.now());
				
		if(period.getYears()>60)
		{
			System.out.println("Senior Citizen");
		}
		else
		{
			System.out.println("Non-Senior Citizen");
		}
		
		

	}
}
