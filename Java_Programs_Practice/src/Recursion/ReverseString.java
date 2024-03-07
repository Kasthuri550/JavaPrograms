package Recursion;

public class ReverseString {

	public static void main(String[] args) {
		
		String str="Kasthuri";
		System.out.println(recursiveString(str));
	}

	private static String recursiveString(String str) {
		
		if(str==null || str.length()<=1)
		{
			return str;
		}
		
		return recursiveString(str.substring(1))+str.charAt(0);
	}
}
