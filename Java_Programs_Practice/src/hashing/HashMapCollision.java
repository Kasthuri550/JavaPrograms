package hashing;

import java.util.HashMap;
import java.util.Objects;

class Person
{
	String name;
	int age;
	
	Person()
	{
		
	}
	
	Person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(this==o) 
			return true;
		if(o==null || getClass()!=o.getClass())
			return false;
		Person person=(Person)o;
		return this.name.equals(person.name) && this.age==person.age;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(name,age);
	}
	
	@Override
    public String toString() {
        return name+" "+age;
    }
}
public class HashMapCollision {

	public static void main(String[] args) {

		HashMap<Person,String> map=new HashMap<Person, String>();
		
		map.put(new Person("Kasthuri",26),"Engineer");
		map.put(new Person("Kasthuri",26),"Developer");
		
		System.out.println(map.size());
		System.out.println(map);
	}
}
