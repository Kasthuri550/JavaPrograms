package Stringprograms.easy;

public class RemoveCharactersExceptAlphabet {

	public static void main(String[] args) {
		
		String str="$Gee*k;s..fo, r'Ge^eks?";
		
		remove1(str);
		remove2(str);
		remove3(str);

	}

	private static void remove3(String str) {
		
		StringBuilder result=new StringBuilder();
		
		for(int i=0;i<str.length();i++)
		{
			if(Character.isLetter(str.charAt(i)))
			{
				result.append(str.charAt(i));
			}
		}
		
		System.out.println(result.toString());
		
	}

	private static void remove2(String str) {
		
		StringBuilder result=new StringBuilder();
		
		for(int i=0;i<str.length();i++)
		{
			if((str.charAt(i)>='A' && str.charAt(i)<='Z')||(str.charAt(i)>='a' && str.charAt(i)<='z'))
			{
				result.append(str.charAt(i));
			}
		}
		
		System.out.println(result.toString());
		
	}

	private static void remove1(String str) {
		
		String removeSpecialChar = str.replaceAll("[^a-zA-Z]", "");
		
		System.out.println(removeSpecialChar);	
	}
}
