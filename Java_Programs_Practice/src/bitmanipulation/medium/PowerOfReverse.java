package bitmanipulation.medium;

public class PowerOfReverse {

	public static void main(String[] args) {

		int n=2;
		
		powerOfReverseBrute(n);
		
		powerOfReverseOptimal(n);
	}

	private static void powerOfReverseOptimal(int n) {

		int reversed=reverse(n);
		
		powerOptimal(n,reversed);
	}

	private static int powerOptimal(int x, int n) {

		int result=1;
		
		while(n>0)
		{
			if(n%2==1)
			{
				result=result*x;
				n=n-1;
			}
			else
			{
				n=n/2;
				x=x*x;
			}
		}
		
		return result;		
	}

	private static void powerOfReverseBrute(int n) {

		int reversed=reverse(n);
		
		System.out.println(powerBrute(n,reversed));
	}

	private static int powerBrute(int b, int e) {

		int result=1;
		
		for(int i=0;i<e;i++)
		{
			result=result*b;
		}
		
		return result;
	}

	private static int reverse(int n) {

		int rev=0;
		
		while(n>0)
		{
			rev=rev*10+(n%10);
			n=n/10;
		}
		
		return rev;
	}
}
