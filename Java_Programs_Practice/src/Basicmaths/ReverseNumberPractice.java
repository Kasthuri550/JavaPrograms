package Basicmaths;

public class ReverseNumberPractice {

	public static void main(String[] args) {
		
		int n = 3298;
		
		System.out.println(reverseNumberOptimal(n));

	}

	private static int reverseNumberOptimal(int n) {
		
		int reverseNumber=0;
		
		while(n>0)
		{
			reverseNumber=reverseNumber*10+n%10;
			n=n/10;
		}
		
		return reverseNumber;
	}
}
