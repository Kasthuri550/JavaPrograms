package Basicmaths;

public class CountDigits {

	public static void main(String[] args) {
		
		int n=325893;
		System.out.println(countDigit(n));
		
		int digit=(int)Math.log10(n)+1;
		System.out.println(digit);

	}

	private static int countDigit(int n) {
		
		int count=0;
		
		while(n>0)
		{
			count++;
			n=n/10;
		}
		
		return count;
	}

}
