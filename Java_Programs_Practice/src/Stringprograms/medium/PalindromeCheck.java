package Stringprograms.medium;

public class PalindromeCheck {

	public static void main(String[] args) {
		
		String str="madam";
		
		if(isPalindrome(str))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not Palindrome");
		}

	}

	private static boolean isPalindrome(String str) {
		
		int n=str.length();
		
		int left=0,right=n-1;
		
		while(left<right)
		{
			if(str.charAt(left)!=str.charAt(right))
			{
				return false;
			}
			left++;
			right--;
		}
		
		return true;
	}
}
