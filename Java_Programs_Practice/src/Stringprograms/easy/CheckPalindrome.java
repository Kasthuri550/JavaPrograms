package Stringprograms.easy;

public class CheckPalindrome {

	public static void main(String[] args) {
		
		String s = "arora";
		int n=s.length();
		
		System.out.println(palindrome1(s,n));
		System.out.println(palindrome2(s, n));

	}

	private static boolean palindrome2(String s, int n) {
		
		String originalStr=s;
		String reverse="";
		
		for(int i=n-1;i>=0;i--)
		{
			reverse=reverse+s.charAt(i);
		}
		
		
		return originalStr.equals(reverse)?true:false;
	}

	private static boolean palindrome1(String s, int n) {

		for(int i=0;i<n/2;i++)
		{
			if(s.charAt(i) != s.charAt(n-i-1))
			{
				
				return false;
			}
		}
		
		return true;
	}
	
	
}
