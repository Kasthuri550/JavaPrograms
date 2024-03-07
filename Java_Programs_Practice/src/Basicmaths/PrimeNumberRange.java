package Basicmaths;

public class PrimeNumberRange {

	public static void main(String[] args) {
		
		int start=1,end=11;
		
		approach1(start,end);

	}

	private static void approach1(int start, int end) {
		
		
		for(int i=start;i<=end;i++)
		{
			if(isPrime(i))
			{
				System.out.println(i);
			}
		}
	}

	private static boolean isPrime(int n) {
		
		if(n<=1)
			return false;
		
		else if(n==2)
			return true;
		
		else if(n%2==0)
			return false;
		
		for(int i=3;i<=n/2;i+=2)
		{
			if(n%i==0)
				return false;
			
		}
		return true;
	}

}
