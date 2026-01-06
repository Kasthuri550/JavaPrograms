package Basicmaths;

public class PrimeNumber {

	public static void main(String[] args) {
		
		int n=3;
		
		approach1(n);

	}

	private static void approach1(int n) {
		
		boolean isPrime=true;
		
		if(n<2)
			isPrime=false;
		
		if(n==2)
			isPrime=true;
		
		if(n%2==0)
			isPrime=false;
		
		for(int i=3;i<n/2;i+=2)
		{
			if(n%i==0)
			{
				isPrime=false;
				break;
			}	
		}
		
		String result=isPrime?"Prime":"Not Prime";
		System.out.println(result);
		
	}

}
