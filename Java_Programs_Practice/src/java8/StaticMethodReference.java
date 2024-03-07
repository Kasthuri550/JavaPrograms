package java8;

interface I1
{
	public void sum(int x,int y);
}
public class StaticMethodReference {
	
	public static int add(int a,int b)
	{
		return a+b;
	}

	public static void main(String[] args) {
		
		I1 i=StaticMethodReference::add;
		i.sum(10, 20);
	}
}
