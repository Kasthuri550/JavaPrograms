package Stringprograms.easy;

public class ToggleAlternateCharactersInCaps {

	public static void main(String[] args) {
		
		String str="kasthuri sathyamoorthy";
		
		alternateCaps(str);
	}

	private static void alternateCaps(String str) {
		
		StringBuilder result=new StringBuilder();
		
		for(int i=0;i<str.length();i++)
		{
			if(i%2==0)
			{
				result.append((char)(str.charAt(i)+'A'-'a'));
			}
			else
			{
				result.append(str.charAt(i));
			}
		}
		
		System.out.println(result.toString());
		
	}
}
