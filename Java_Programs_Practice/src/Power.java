
public class Power {

	public static void main(String[] args) {
		
		int n=81
				;
		System.out.println(isPowerThree1(n));
		System.out.println(isPowerThree2(n));
		

	}

	private static int isPowerThree2(int n) {
		
		double log3=Math.log(n)/Math.log(3);
		
		return (int)log3;
		}

	private static boolean isPowerThree1(int n) {
		
		while(n>=3)
		{
			if(n%3!=0) return false;
			
			n=n/3;
		}
		
		if(n==1) return true;
		return false;
		
	}

}
