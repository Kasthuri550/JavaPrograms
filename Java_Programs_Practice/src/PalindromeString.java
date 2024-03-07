
public class PalindromeString {

	public static void main(String[] args) {
		
		String str="madam";
		System.out.println(checkPalindrome(str));
	}
	
	public static boolean checkPalindrome(String str)
	{
		boolean result=true;
		int len=str.length();
		for(int i=0;i<len/2;i++)
		{
			if(str.charAt(i)!=str.charAt(len-i-1))
			{
				result=false;
			    break;
			}
		}
		return result;		
	}

}
