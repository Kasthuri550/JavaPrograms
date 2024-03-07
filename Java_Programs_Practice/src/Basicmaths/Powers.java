package Basicmaths;

public class Powers {

	public static void main(String[] args) {
		
		int base=2,expon=3;
		approach1(base,expon);
	}

	private static void approach1(int base, int expon) {

		int result=1;
		for(int i=1;i<=expon;i++)
		{
			result=result*base;			
		}
		
		System.out.println(result);
	}

}
