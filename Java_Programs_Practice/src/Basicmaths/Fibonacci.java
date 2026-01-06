package Basicmaths;

public class Fibonacci {

	public static void main(String[] args) {
			
		int num=10;
		fibonacci(num);
		
//		for(int i=0;i<num;i++)
//		{
//		 System.out.println(fibonacciRecursion(i));
//		}
	}

	private static int fibonacciRecursion(int count) {
		
		if(count<=1)
		{
			return count;
		}
		
		return fibonacciRecursion(count-1)+fibonacciRecursion(count-2);
	}

	private static void fibonacci(int num) {
		
		int a=0,b=1,c=1;
		
		for(int i=1;i<=num;i++)
		{
			System.out.println(a+" ");
			a=b;
			b=c;
			c=a+b;
		}
	}

}
