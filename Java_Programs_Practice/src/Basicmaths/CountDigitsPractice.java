package Basicmaths;

public class CountDigitsPractice {

	public static void main(String[] args) {
		
		int n = 329823;
		
		System.out.println(countDigitsBrute(n));
		System.out.println(countDigitsOptimal(n));

	}

	private static int countDigitsOptimal(int n) {

		int count=(int)(Math.log10(n)+1);
		return count;
	}

	private static int countDigitsBrute(int n) {
		
		int count=0;
		
		while(n>0)
		{
			count++;
			n=n/10;
		}
		
		return count;
	}
}
