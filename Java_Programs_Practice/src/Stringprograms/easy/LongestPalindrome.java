package Stringprograms.easy;

public class LongestPalindrome {

	public static void main(String[] args) {
		
		
		String[] array = {"racecar", "madam", "level", "hello", "noon","edcaabbaacde"};
		
		longestPal(array);

	}

	private static void longestPal(String[] array) {
		
		String longestPalindrome="";
		
		for(String str:array)
		{
			if(isPalindrome(str) && str.length()>longestPalindrome.length())
			{
				longestPalindrome=str;
			}
		}
		
		System.out.println(longestPalindrome);
		
	}

	private static boolean isPalindrome(String str) {
		
		int i=0,j=str.length()-1;
		
		while(i<j)
		{
			if(str.charAt(i)!=str.charAt(j))
			{
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
