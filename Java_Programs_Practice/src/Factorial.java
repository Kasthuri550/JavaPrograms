import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n,fact=1;
		System.out.println("Enter factorial of number: ");
		n=sc.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			fact=fact*i;
		}
		System.out.println("Factorial of "+n+"! is "+fact);
		System.out.println("Recurrsive Factorial of "+n+"! is "+factorial(n));
	}

	private static int factorial(int n) {
		
		if(n==1)
		   return 1;
		else
			return n*factorial(n-1);
	}

}
