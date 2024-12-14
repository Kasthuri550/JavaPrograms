package Basicmaths;

public class CheckPalindromeInReverseNumber {

	public static void main(String[] args) {
		
		 int number = 451254;
		 
		 System.out.println(IsPalindrome(number));

	}

	private static String IsPalindrome(int number) {
		
		int dup=number,reverseNumber=0;
		
		while(number>0)
		{
			reverseNumber=reverseNumber*10+number%10;
			number=number/10;
		}
		
		if(dup==reverseNumber)
		{
			return "Palindrome";
		}
		
		return "Not Palindrome";
	}
}
