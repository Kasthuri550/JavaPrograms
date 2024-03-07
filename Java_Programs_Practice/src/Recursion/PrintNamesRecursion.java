package Recursion;

public class PrintNamesRecursion {

	public static void main(String[] args) {
		
		printname(5);

	}
	
	static void printname(int n)
	{
		if(n<1)
		{
			return;
		}
		System.out.println("Kasthuri");
		printname(n-1);
	}

}
