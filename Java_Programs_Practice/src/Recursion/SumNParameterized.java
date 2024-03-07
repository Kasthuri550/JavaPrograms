package Recursion;

public class SumNParameterized {

	public static void main(String[] args) {
		
		sumN(0,5);

	}

	private static void sumN(int sum,int n) {
		
		if(n<0)
		{
			System.out.println(sum);
			return;
		}
			
		
		sumN(sum+n,n-1);	
	}

}
