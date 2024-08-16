
public class PrimeNumberCheck {

	public static void main(String[] args) {
		
		System.out.println(primeCheck(78));
		System.out.println(primeCheck(2));
	}
	
	public static boolean primeCheck(int num)
	{
		if(num==0||num==1)
		{
			return false;
		}
		if(num==2)
		{
			return true;
		}
		for(int i=2;i<=num/2;i++)
		{
			if(num%i==0)
			{
				return false;
			}
		}
		return true;
	}
}
