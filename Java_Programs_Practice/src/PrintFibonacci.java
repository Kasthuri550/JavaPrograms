
public class PrintFibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacci(10));

	}
	
	public static int fibonacci(int count)
	{
		int a=0,b=1,c=1;
		if(count<=1)
			return count;
		
		for(int i=1;i<=count;i++)
		{
			System.out.println(a);
			a=b;
			b=c;
			c=a+b;
		}
		
		return c;
	}

}
