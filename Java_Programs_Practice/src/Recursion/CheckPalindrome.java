package Recursion;

public class CheckPalindrome {

	public static void main(String[] args) {
		
		String s="kasthuri";
		if(palindrome(s,0,s.length()))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not palindrome");
		}
	}

	private static boolean palindrome(String s,int i,int n) {
		
		if(s.isEmpty())
		{
			return true;
		}
		
		if(i>=n/2)
		{
			return true;
		}
		
		if(s.charAt(i)!=s.charAt(n-i-1))
		{
			return false;
		}
		
		return palindrome(s, i+1, n);
		
	}

}
