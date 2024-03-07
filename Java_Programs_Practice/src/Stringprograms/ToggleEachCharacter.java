package Stringprograms;

public class ToggleEachCharacter {

	public static void main(String[] args) {
		
		 String s = "PrePInsTa";
		 approach1(s);
		 approach2(s);
	}


	private static void approach1(String s) {
		
		String str="";
		
		for(int i=0;i<s.length();i++)
		{
			if(Character.isUpperCase(s.charAt(i)))
			{
				str= str+Character.toLowerCase(s.charAt(i));
			}
			else
			{
				str=str+Character.toUpperCase(s.charAt(i));
			}
		}
		
		System.out.println(str);
	}

	private static void approach2(String s) {
		
		String str="";
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>='a' && s.charAt(i)<='z')
			{
				str=str+(char)(s.charAt(i)+'A'-'a');
			}
			else 
			{
				str=str+(char)(s.charAt(i)+'a'-'A');
			}
		}
		
		System.out.println(str);
	}
}
