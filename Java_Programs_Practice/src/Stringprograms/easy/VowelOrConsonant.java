package Stringprograms.easy;

public class VowelOrConsonant {

	public static void main(String[] args) {

		char c='D';
		
		if(isLowerCase(c)||isUpperCase(c))
		{
			System.out.println("Vowel");
		}
		else
		{
			System.out.println("Consonant");
		}
		
		
	}

	private static boolean isLowerCase(char c) {
		
		return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
	}

	private static boolean isUpperCase(char c) {
		
		return c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
	}
}
