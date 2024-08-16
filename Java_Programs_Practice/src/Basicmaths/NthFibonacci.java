package Basicmaths;

public class NthFibonacci {

	public static void main(String[] args) {
		
		int n=10;
		
		System.out.println(fibonacciIterative(n));
		System.out.println(fibonacciRecurrsive(n));

	}

	private static int fibonacciRecurrsive(int n) {
		
		if(n<=1)
		{
			return n;
		}
		
		return fibonacciIterative(n-1)+fibonacciIterative(n-2);
	}

	private static int fibonacciIterative(int n) {
		
		if(n<=1)
		{
			return n;
		}
		
		int a=0,b=1;
		for(int i=2;i<=n;i++)
		{
			int c=a+b;
//			System.out.println(c);
			a=b;
			b=c;
		}
		
		return b;
	}

}
