package java8;

interface In
{
	public int multiply(int a,int b);
}
public class MethodReference {
	
	public int mul(int x,int y)
	{
		return x*y;
	}

	public static void main(String[] args) {
		
		MethodReference mr=new MethodReference();
		In i=mr::mul;
		int multiply = i.multiply(10, 20);
		System.out.println(multiply);
		
	}
}
