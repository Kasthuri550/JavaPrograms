package Basicmaths;

public class FactorialRecursion {

	public static void main(String[] args) {
		
		int n=5;
		
		System.out.println(factorial(n));

	}

	private static int factorial(int n) {
		
		if(n==1)
		{
			return n;
		}
		
		return n*factorial(n-1);
		
	}

}
