package Stringprograms.easy;

public class StringReverse {

	public static void main(String[] args) {
		
		String str="Kasthuri";
		
		String reverse=reverse(str);
		System.out.println(reverse);
	}
	
	public static String reverse(String str)
	{
		
		if(str.length()>0)
		{
			return reverse(str.substring(1))+str.charAt(0);
		}
		
		return "";
	}

}
