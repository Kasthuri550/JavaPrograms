package Recursion;

public class FactorialParameterized {

	public static void main(String[] args) {
		
		fact(1,7);

	}

	private static void fact(int f,int n) {
		
		if(n==0)
		{
			System.out.println(f);
			return;
		}
		
		fact(f*n,n-1);
		
	}

}
